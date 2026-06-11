package com.hydrahtec.userdepartment.repositories;

import com.hydrahtec.userdepartment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
