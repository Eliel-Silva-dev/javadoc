package com.hydrahtec.jpadoc.models;

import java.util.Set;
import java.util.UUID;

public class PublisherModel {

    UUID id;
    String name;
    Set<BookModel> books;
}
