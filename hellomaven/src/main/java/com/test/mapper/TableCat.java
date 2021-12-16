package com.test.mapper;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TableCat {

    private int id;

    private String name;

    private String color;

    private int lives;

    private boolean alive;

}
