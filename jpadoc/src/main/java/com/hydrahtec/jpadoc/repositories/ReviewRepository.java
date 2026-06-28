package com.hydrahtec.jpadoc.repositories;

import com.hydrahtec.jpadoc.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
