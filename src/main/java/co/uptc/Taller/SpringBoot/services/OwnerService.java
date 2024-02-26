package co.uptc.Taller.SpringBoot.services;

import co.uptc.Taller.SpringBoot.entities.Owner;
import co.uptc.Taller.SpringBoot.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Integer id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        return optionalOwner.orElse(null);
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Integer id, Owner newOwnerData) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (optionalOwner.isPresent()) {
            Owner existingOwner = optionalOwner.get();
            existingOwner.setName(newOwnerData.getName());
            existingOwner.setDocument(newOwnerData.getDocument());
            existingOwner.setPhone(newOwnerData.getPhone());
            return ownerRepository.save(existingOwner);
        } else {
            return null;
        }
    }

    public void deleteOwner(Integer id) {
        ownerRepository.deleteById(id);
    }
}
