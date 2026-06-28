package com.hydrahtec.jpadoc.repository;

import com.hydrahtec.jpadoc.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepositories extends JpaRepository<AuthorModel, UUID> {
    AuthorModel findAuthorModelByName(String name);
}
