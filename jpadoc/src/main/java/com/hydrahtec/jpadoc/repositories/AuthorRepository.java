package com.hydrahtec.jpadoc.repositories;

import com.hydrahtec.jpadoc.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
    AuthorModel findAuthorModelByName(String name);
}
