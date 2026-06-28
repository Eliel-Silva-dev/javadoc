package com.hydrahtec.jpadoc.repository;

import com.hydrahtec.jpadoc.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepositories extends JpaRepository<PublisherModel, UUID> {
    PublisherModel findpuPublisherModelByName(String name);
}
