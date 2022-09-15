package db.javaschool.session_11.application.controller;

import db.javaschool.session_11.application.entities.Customer;
import db.javaschool.session_11.application.entities.CustomerDTO;
import db.javaschool.session_11.application.entities.LoginRequest;
import db.javaschool.session_11.application.entities.User;
import db.javaschool.session_11.application.repositories.CustomerRepository;
import db.javaschool.session_11.application.repositories.UserJPARepository;
import db.javaschool.session_11.application.services.CustomerService;
import db.javaschool.session_11.application.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController // CONTROLLER
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;
    private CustomerService customerService;

    private UserJPARepository userJPARepository;

    JWTService jwtService;
    private static String history = "";

    @Autowired
    public CustomerController(CustomerRepository customerRepository,
                              CustomerService customerService,
                              UserJPARepository userJPARepository,
                              JWTService jwtService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.userJPARepository = userJPARepository;
        this.jwtService = jwtService;
    }


    @GetMapping("/")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(@CookieValue(name = "history") String history) {
        System.out.println("HISTORY COOKIE " + history);
        List<CustomerDTO> customers = customerService.getAllCustomers();


        return ResponseEntity.ok().body(customers);
    }


    // http://localhost:8080/customers/5
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(value = "id") long id) {
        history += id;

        ResponseCookie cookie = ResponseCookie
                .from("history", history.toString())
                .maxAge(60)
                .path("/")
                .build();

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(customerService.getCustomerById(id));
    }

    @PutMapping("/")
    public void insertCustomer(@RequestBody Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable(value = "id") long id) {
        customerRepository.updateCustomer(customer, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(value = "id") long id) {
        customerRepository.deleteCustomer(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) throws Exception {
        String token = "";
        if (userJPARepository.countByUsernameAndPassword(loginRequest.username, loginRequest.password) == 1) {
            token = jwtService.generateJWT(loginRequest);
        } else {
            throw new Exception("Password or username is incorrect.");
        }
        return token;
    }

    @GetMapping("/get_profile")
    public User user(HttpServletRequest request){
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!header.startsWith("Bearer ")){
            return null;
        }
        String token = header.split(" ")[1];
        if (!jwtService.validate(token)){
            return null;
        }
        String user = jwtService.extractUser(token);
        return userJPARepository.findByUsername(user);
    }
}
