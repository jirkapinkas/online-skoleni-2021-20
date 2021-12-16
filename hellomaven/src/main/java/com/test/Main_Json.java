package com.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.test.mapper.TableCat;

public class Main_Json {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        TableCat tableCat = TableCat.builder()
                .id(1)
                .alive(true)
                .lives(9)
                .name("Cica")
                .color("blue")
                .build();
        String string = objectMapper.writeValueAsString(tableCat);
        System.out.println(string);

        String jsonString = "{\"id\":2,\"name\":\"Mica\",\"color\":\"red\",\"lives\":9,\"alive\":true}";
        TableCat newTableCat = objectMapper.readValue(jsonString, TableCat.class);
        System.out.println(newTableCat);
    }

}
