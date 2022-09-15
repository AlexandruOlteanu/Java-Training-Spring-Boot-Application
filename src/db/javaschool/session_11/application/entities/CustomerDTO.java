package db.javaschool.session_11.application.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class CustomerDTO {

    private Long id;
    private String username;
    private String lastName;
    private String firstName;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    public CustomerDTO(CustomerEntity customerEntity) {
        if (customerEntity != null) {
            this.address = customerEntity.getAddress();
            this.city = customerEntity.getCity();
            this.country = customerEntity.getCountry();
            this.phone = customerEntity.getPhone();
            this.firstName = customerEntity.getFirstName();
            this.lastName = customerEntity.getLastName();
            this.id = customerEntity.getId();
            this.postalCode = customerEntity.getPostalCode();
            this.username = customerEntity.getUsername();
        }
    }
}