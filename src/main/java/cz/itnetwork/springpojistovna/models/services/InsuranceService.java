package cz.itnetwork.springpojistovna.models.services;

import cz.itnetwork.springpojistovna.models.dto.InsuranceDTO;
import cz.itnetwork.springpojistovna.models.dto.InsuredDTO;

import java.util.List;

public interface InsuranceService {

    void create(InsuranceDTO insurance);

    List<InsuranceDTO> getAll();

    InsuranceDTO getById(long insuranceId);

    void edit(InsuranceDTO insurance);

    void remove(long insuranceId);



}
