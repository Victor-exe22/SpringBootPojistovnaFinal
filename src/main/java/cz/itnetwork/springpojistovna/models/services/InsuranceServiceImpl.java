package cz.itnetwork.springpojistovna.models.services;

import cz.itnetwork.springpojistovna.data.entities.InsuranceEntity;
import cz.itnetwork.springpojistovna.data.entities.InsuredEntity;
import cz.itnetwork.springpojistovna.data.repositories.InsuranceRepository;
import cz.itnetwork.springpojistovna.data.repositories.InsuredRepository;
import cz.itnetwork.springpojistovna.models.dto.InsuranceDTO;
import cz.itnetwork.springpojistovna.models.dto.mappers.InsuranceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InsuranceServiceImpl implements InsuranceService{

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public void create(InsuranceDTO insurance) {
        InsuranceEntity newInsurance = insuranceMapper.toEntity(insurance);
        insuranceRepository.save(newInsurance);
    }

    @Override
    public List<InsuranceDTO> getAll() {
        return StreamSupport.stream(insuranceRepository.findAll().spliterator(), false)
                .map(j -> insuranceMapper.toDTO(j))
                .toList();
    }

    @Override
    public InsuranceDTO getById(long insuranceId) {
        InsuranceEntity fetchedInsurance = getInsuranceOrThrow(insuranceId);

        return insuranceMapper.toDTO(fetchedInsurance);
    }

    @Override
    public void edit(InsuranceDTO insurance) {
        InsuranceEntity fetchedInsurance = getInsuranceOrThrow(insurance.getInsuranceID());

        insuranceMapper.updateInsuranceEntity(insurance, fetchedInsurance);
        insuranceRepository.save(fetchedInsurance);
    }

    private InsuranceEntity getInsuranceOrThrow(long insuranceId) {
        return insuranceRepository
                .findById(insuranceId)
                .orElseThrow();
    }

    @Override
    public void remove(long insuranceId) {
        InsuranceEntity fetchedEntity = getInsuranceOrThrow(insuranceId);
        insuranceRepository.delete(fetchedEntity);
    }

}
