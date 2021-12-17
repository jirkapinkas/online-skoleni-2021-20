package com.example.hellospring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
//@Table(name = "item")
public class Item {

    @Id
    @Column(name = "item_id")
    private int id;

    private String name;

    private double price;

    private String description;

}
