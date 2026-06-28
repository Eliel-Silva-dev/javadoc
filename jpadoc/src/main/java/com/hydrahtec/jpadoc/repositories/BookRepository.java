package com.hydrahtec.jpadoc.repositories;

import com.hydrahtec.jpadoc.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {
    BookModel findBookModelByTitle(String title);
}
