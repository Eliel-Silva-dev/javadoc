package com.hydrahtec.jpadoc.models;

import java.util.Set;
import java.util.UUID;

public class BookModel {

    UUID id;
    String title;
    Publisher publisher;
    Set<Author> authors;
    Review review;
}
