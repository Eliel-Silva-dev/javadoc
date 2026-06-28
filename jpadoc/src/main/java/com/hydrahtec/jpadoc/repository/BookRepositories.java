package com.hydrahtec.jpadoc.repository;

import com.hydrahtec.jpadoc.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepositories extends JpaRepository<BookModel, UUID> {
    BookModel findBookModelByTitle(String title);
}
