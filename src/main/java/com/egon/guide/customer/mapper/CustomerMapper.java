package com.egon.guide.customer.mapper;

import com.egon.guide.customer.dto.CustomerDto;
import com.egon.guide.customer.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity toEntity(CustomerDto dto);
    CustomerDto toDto(CustomerEntity entity);
}
