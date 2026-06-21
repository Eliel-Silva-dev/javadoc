package com.hydrahtec.jpadoc.models;

import java.util.Set;
import java.util.UUID;

public class AuthorModel {

    UUID id;
    String name;
    Set<BookModel> books;
}
