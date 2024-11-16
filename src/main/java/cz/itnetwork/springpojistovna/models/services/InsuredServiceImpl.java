package cz.itnetwork.springpojistovna.models.services;


import cz.itnetwork.springpojistovna.data.entities.InsuranceEntity;
import cz.itnetwork.springpojistovna.data.entities.InsuredEntity;
import cz.itnetwork.springpojistovna.data.repositories.InsuredRepository;
import cz.itnetwork.springpojistovna.models.dto.InsuranceDTO;
import cz.itnetwork.springpojistovna.models.dto.InsuredDTO;
import cz.itnetwork.springpojistovna.models.dto.mappers.InsuredMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InsuredServiceImpl implements InsuredService {

    @Autowired
    private InsuredMapper insuredMapper;

    @Autowired
    private InsuredRepository insuredRepository;

    @Override
    public void create(InsuredDTO insured) {
        InsuredEntity newInsured = insuredMapper.toEntity(insured);
        insuredRepository.save(newInsured);
    }

    @Override
    public List<InsuredDTO> getAll() {
        List<InsuredEntity> insuredEntities = StreamSupport.stream(insuredRepository.findAll().spliterator(), false).toList();
        System.out.println("Načítané pojištěnce: " + insuredEntities); // Debug log
        return insuredEntities.stream()
                .map(insuredMapper::toDTO)
                .toList();
    }

    @Override
    public InsuredDTO getById(long insuredId) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insuredId);

        return insuredMapper.toDTO(fetchedInsured);
    }

    @Override
    public void edit(InsuredDTO insured) {
        InsuredEntity fetchedInsured = getInsuredOrThrow(insured.getInsuredId());

        insuredMapper.updateInsuredEntity(insured, fetchedInsured);
        insuredRepository.save(fetchedInsured);
    }

    private InsuredEntity getInsuredOrThrow(long insuredId) {
        return insuredRepository
                .findById(insuredId)
                .orElseThrow();
    }

    @Override
    public void remove(long insuredId) {
        InsuredEntity fetchedEntity = getInsuredOrThrow(insuredId);
        insuredRepository.delete(fetchedEntity);
    }

}
