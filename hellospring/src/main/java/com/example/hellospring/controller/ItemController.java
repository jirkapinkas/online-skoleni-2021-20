package com.example.hellospring.controller;

import com.example.hellospring.entity.Item;
import com.example.hellospring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // http://localhost:8080/item
    @GetMapping
    public List<Item> items() {
        return itemService.findAll();
    }

    // http://localhost:8080/item/1
    @GetMapping("/{id}")
    public Optional<Item> item(@PathVariable int id) {
        return itemService.findById(id);
    }
}
