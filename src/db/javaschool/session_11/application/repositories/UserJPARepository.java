package db.javaschool.session_11.application.repositories;

import db.javaschool.session_11.application.entities.CustomerEntity;
import db.javaschool.session_11.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {
    public long countByUsernameAndPassword(String username, String password);

    public User findByUsername(String username);
}

