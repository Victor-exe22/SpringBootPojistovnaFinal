package cz.itnetwork.springpojistovna.models.dto.mappers;

import cz.itnetwork.springpojistovna.data.entities.InsuranceEntity;
import cz.itnetwork.springpojistovna.models.dto.InsuranceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    InsuranceEntity toEntity(InsuranceDTO source);
    InsuranceDTO toDTO(InsuranceEntity insuranceEntity);

    void updateInsuranceDTO(InsuranceDTO source, @MappingTarget InsuranceDTO target);

    void updateInsuranceEntity(InsuranceDTO source, @MappingTarget InsuranceEntity target);
}
