package com.hydrahtec.jpadoc.repositories;

import com.hydrahtec.jpadoc.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
    PublisherModel findPublisherModelByName(String name);
}
