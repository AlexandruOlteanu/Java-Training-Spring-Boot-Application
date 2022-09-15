package db.javaschool.session_11.application.repositories;

import db.javaschool.session_11.application.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerJPARepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByUsernameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrderByUsernameDesc(String username, String lastName, String firstName);
}
