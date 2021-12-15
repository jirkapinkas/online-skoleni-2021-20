package com.test.mapper;

import java.util.List;

public interface AbstractMapper <C1, C2> {

    C2 toDto(C1 c1);
    List<C2> toDto(List<C1> list);

}
