package com.test.mapper;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CatMapper extends AbstractMapper<TableCat, UserCat> {

}
