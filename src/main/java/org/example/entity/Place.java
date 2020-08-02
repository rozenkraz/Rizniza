package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Place {
    @Id
    private int id;

    private String name;
}
