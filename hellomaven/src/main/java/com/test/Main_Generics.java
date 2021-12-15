package com.test;

import com.test.mapper.CatMapper;
import com.test.mapper.TableCat;
import com.test.mapper.UserCat;
import org.mapstruct.factory.Mappers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main_Generics {

    public static void main(String[] args) {
        TableCat tableCat = TableCat.builder()
                .id(123)
                .alive(true)
                .lives(9)
                .color("black")
                .name("Micina")
                .build();

        CatMapper mapper = Mappers.getMapper(CatMapper.class);

        UserCat userCat = mapper.toDto(tableCat);

        System.out.println(userCat);
        test(Arrays.asList(1d,2d,3d));
    }

    public static void test(List<? extends Number> numbers) {

    }

}
