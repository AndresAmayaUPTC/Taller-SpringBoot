package co.uptc.Taller.SpringBoot.services;


import co.uptc.Taller.SpringBoot.entities.Phone;

import co.uptc.Taller.SpringBoot.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    public Phone getPhoneById(Long id) {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        return optionalPhone.orElse(null);
    }

    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone updatePhone(Long id, Phone newPhoneData) {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()) {
            Phone existingPhone = optionalPhone.get();
            existingPhone.setBrand(newPhoneData.getBrand());
            existingPhone.setReference(newPhoneData.getReference());
            existingPhone.setDeadline(newPhoneData.getDeadline());
            existingPhone.setOwner(newPhoneData.getOwner());
            existingPhone.setTechnicians(newPhoneData.getTechnicians());
            return phoneRepository.save(existingPhone);
        } else {
            return null;
        }
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
}
