package cz.itnetwork.springpojistovna.models.services;

import cz.itnetwork.springpojistovna.models.dto.InsuranceDTO;
import cz.itnetwork.springpojistovna.models.dto.InsuredDTO;

import java.util.List;

public interface InsuredService {

    void create(InsuredDTO insured);

    List<InsuredDTO> getAll();

    InsuredDTO getById(long insuredId);

    void edit(InsuredDTO insured);

    void remove(long insuredId);
}
