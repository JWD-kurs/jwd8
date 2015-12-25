package jwd.wafepa.repository;

import jwd.wafepa.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
