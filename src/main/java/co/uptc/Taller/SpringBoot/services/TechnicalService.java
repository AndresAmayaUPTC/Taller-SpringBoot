package co.uptc.Taller.SpringBoot.services;

import co.uptc.Taller.SpringBoot.entities.Technical;
import co.uptc.Taller.SpringBoot.repositories.TechnicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalService {

    private final TechnicalRepository technicalRepository;

    @Autowired
    public TechnicalService(TechnicalRepository technicalRepository) {
        this.technicalRepository = technicalRepository;
    }

    public List<Technical> getAllTechnicals() {
        return technicalRepository.findAll();
    }

    public Technical getTechnicalById(Integer id) {
        Optional<Technical> optionalTechnical = technicalRepository.findById(id);
        return optionalTechnical.orElse(null);
    }

    public Technical createTechnical(Technical technical) {
        return technicalRepository.save(technical);
    }

    public Technical updateTechnical(Integer id, Technical newTechnicalData) {
        Optional<Technical> optionalTechnical = technicalRepository.findById(id);
        if (optionalTechnical.isPresent()) {
            Technical existingTechnical = optionalTechnical.get();
            existingTechnical.setName(newTechnicalData.getName());
            existingTechnical.setExperience(newTechnicalData.getExperience());
            return technicalRepository.save(existingTechnical);
        } else {
            return null;
        }
    }

    public void deleteTechnical(Integer id) {
        technicalRepository.deleteById(id);
    }
}
