package cz.itnetwork.springpojistovna.models.dto.mappers;

import cz.itnetwork.springpojistovna.data.entities.InsuranceEntity;
import cz.itnetwork.springpojistovna.data.entities.InsuredEntity;
import cz.itnetwork.springpojistovna.models.dto.InsuranceDTO;
import cz.itnetwork.springpojistovna.models.dto.InsuredDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InsuredMapper {

    InsuredEntity toEntity(InsuredDTO source);
    InsuredDTO toDTO(InsuredEntity insuredEntity);

    void updateInsuredDTO(InsuredDTO source, @MappingTarget InsuredDTO target);
    void updateInsuredEntity(InsuredDTO source, @MappingTarget InsuredEntity target);


}
