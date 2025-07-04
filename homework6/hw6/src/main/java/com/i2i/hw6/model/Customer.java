package com.i2i.hw6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    private int id;

    private String name;

    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}