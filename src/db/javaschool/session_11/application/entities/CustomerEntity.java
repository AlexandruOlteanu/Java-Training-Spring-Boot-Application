package db.javaschool.session_11.application.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "customer2")
@Data
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String country;

    public CustomerEntity(CustomerDTO customerDTO){
        this.id = customerDTO.getId();
        this.username = customerDTO.getUsername();
        this.lastName = customerDTO.getLastName();
        this.firstName = customerDTO.getFirstName();
        this.phone = customerDTO.getPhone();
        this.address = customerDTO.getAddress();
        this.city = customerDTO.getCity();
        this.postalCode = customerDTO.getPostalCode();
        this.country = customerDTO.getCountry();

    }



}
