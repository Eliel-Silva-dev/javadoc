package com.hydrahtec.dsaula05.repositories;

import com.hydrahtec.dsaula05.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
