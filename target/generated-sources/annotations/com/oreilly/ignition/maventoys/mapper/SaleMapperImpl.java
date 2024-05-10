package com.oreilly.ignition.maventoys.mapper;

import com.oreilly.ignition.maventoys.dto.SaleDto;
import com.oreilly.ignition.maventoys.entity.Employee;
import com.oreilly.ignition.maventoys.entity.Sale;
import com.oreilly.ignition.maventoys.entity.Store;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-02T17:44:51-0600",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Override
    public SaleDto saleToSaleDto(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleDto saleDto = new SaleDto();

        saleDto.setEmployeeId( saleEmployeeId( sale ) );
        saleDto.setStoreId( saleStoreId( sale ) );

        return saleDto;
    }

    @Override
    public Sale saleDtoToSale(SaleDto saleDto) {
        if ( saleDto == null ) {
            return null;
        }

        Sale sale = new Sale();

        return sale;
    }

    private Integer saleEmployeeId(Sale sale) {
        if ( sale == null ) {
            return null;
        }
        Employee employee = sale.getEmployee();
        if ( employee == null ) {
            return null;
        }
        Integer id = employee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer saleStoreId(Sale sale) {
        if ( sale == null ) {
            return null;
        }
        Store store = sale.getStore();
        if ( store == null ) {
            return null;
        }
        Integer id = store.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
