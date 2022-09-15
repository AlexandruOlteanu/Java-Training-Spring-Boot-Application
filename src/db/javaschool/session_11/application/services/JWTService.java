package db.javaschool.session_11.application.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import db.javaschool.session_11.application.entities.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    final private Algorithm algorithm = Algorithm.HMAC256("secret");

    public String generateJWT(LoginRequest loginRequest) {
        return JWT.create()
                .withSubject(loginRequest.username)
                .withIssuer("Issuer")
                .withIssuedAt(new Date())
                .sign(algorithm);
    }

    public boolean validate(String jwt) {
        boolean tokenOk = true;
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();

        try {
            jwtVerifier.verify(jwt);
        } catch (JWTVerificationException e) {
            tokenOk = false;
        }

        return tokenOk;
    }

    public boolean validateUser(String username, String jwt) {
        if (!validate(jwt))
            return false;

        return JWT.decode(jwt).getSubject().equals(username);

    }

    public String extractUser(String jwt) {
        if (!validate(jwt))
            return null;
        return JWT.decode(jwt).getSubject();
    }


}
