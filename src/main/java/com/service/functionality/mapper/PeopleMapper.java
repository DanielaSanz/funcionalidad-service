package com.service.functionality.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PeopleMapper {

   String descriptionPeople();
}
