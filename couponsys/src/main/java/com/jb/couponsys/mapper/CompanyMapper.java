package com.jb.couponsys.mapper;

import com.jb.couponsys.beans.Company;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void updateCompanyFromDto(Company customerDto, @MappingTarget Optional<Company> entity);
}
