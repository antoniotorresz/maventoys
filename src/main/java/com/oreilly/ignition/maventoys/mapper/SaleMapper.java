package com.oreilly.ignition.maventoys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.oreilly.ignition.maventoys.dto.SaleDto;
import com.oreilly.ignition.maventoys.entity.Sale;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "store.id", target = "storeId")
    public SaleDto saleToSaleDto(Sale sale);
    
    public Sale saleDtoToSale(SaleDto saleDto);
}
