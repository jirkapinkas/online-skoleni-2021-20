package com.example.hellospring.service;

import com.example.hellospring.entity.Item;
import com.example.hellospring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(int id) {
        return itemRepository.findById(id);
    }

}
