package com.example.basicauth.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.basicauth.component.UserSession;
import com.example.basicauth.entity.User;
import com.example.basicauth.exception.MyCustomException;
import com.example.basicauth.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Controller
@Api(value = "auth", description="API for authentication")
//@RestController = Controller + ResponseBody
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    UserSession session;

    // register

    @ApiOperation(value = "Registers a new account", nickname = "register", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account created", response = User.class) ,
            @ApiResponse(code = 404, message = "Error creating account", response = String.class)})
    @PostMapping("/register")
    @ResponseBody
    public User register(@ApiParam(value = "User to be added", required = true) @RequestBody User user) {
        // TODO ERRORS: validare de parametri - ex. parola nu are 8 caractere
        // TODO ERRORS: duplicat username || duplicat email
        User dbUser = userService.addUser(user);
        return dbUser;
    }

    // login
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody User user) throws MyCustomException { // TODO: LoginDTO
        // TODO ERRORS: nu exista username
        // TODO ERRORS: parola e gresita

        // user = email + parola || {username + parola}
        // sa gasesc user dupa username
        User dbUser = userService.getUserByUsername(user.getUsername());
        if (dbUser != null) {
            // verific parola
            // TODO: cu bcrypt
            if (user.getPassword().equals(dbUser.getPassword())) {

                // pot sa setez username pe sesiune
                session.setUsername(dbUser.getUsername());

                // atasez header-ul la raspuns
                return ResponseEntity.ok().headers(generateJWTAuthHeader(dbUser)).body(dbUser);
            }
        } else {
            throw new MyCustomException();
        }
        return null;
    }

    private HttpHeaders generateBasicAuthHeader(User dbUser) {
        // autorizare
        String credentials = dbUser.getId() + ":" + dbUser.getPassword();
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        // authorization header
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Basic " + encodedCredentials);

        return httpHeaders;
    }

    private HttpHeaders generateJWTAuthHeader(User dbUser) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            String token = JWT.create()
                    .withIssuer("DBSchool")
                    .withAudience("users")
                    .withExpiresAt(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                    .withIssuedAt(new Date(System.currentTimeMillis()))
                    .withSubject("Login app")
                    .withClaim("username", dbUser.getUsername())
                    .sign(algorithm);

            // authorization header
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "Bearer " + token);

            return httpHeaders;
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            return null;
        }
    }

    // TODO: de mutat in DashboardController
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers(@RequestHeader("Authorization") String authHeader) {
        // TODO ERRORS: token expirat
        // TODO ERRORS: erori de validare token
        // TODO ERRORS: nu are drepturi suficiente (+ role in db)
        System.out.println(authHeader);

        if (authHeader != null) {

            decodeJWTAuthHeader(authHeader);
            System.out.println(session.getUsername());

            return userService.getAllUsers();
        }
        return null;
    }

    private String decodeBasicAuthHeader(String authHeader) {
        String encodedStr = authHeader.substring(6);
        String decoded = new String(Base64.getDecoder().decode(encodedStr));

        System.out.println(decoded);

        String id = decoded.split(":")[0];

        return decoded;
    }

    private String decodeJWTAuthHeader(String authHeader) {
        String token = authHeader.substring(7);
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret"); //use more secure key
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("DBSchool")
                    .withAudience("users")
                    .withSubject("Login app")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);

            System.out.println(jwt.getClaim("username").asString());

            return jwt.getClaim("username").asString();

        } catch (JWTVerificationException exception) {
            System.out.println(exception.getMessage());
        }

        return null;
    }
}
