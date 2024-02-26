package co.uptc.Taller.SpringBoot.controllers;



import co.uptc.Taller.SpringBoot.entities.Phone;
import co.uptc.Taller.SpringBoot.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones() {
        List<Phone> phones = phoneService.getAllPhones();
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        Phone phone = phoneService.getPhoneById(id);
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        Phone createdPhone = phoneService.createPhone(phone);
        return new ResponseEntity<>(createdPhone, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
        Phone updatedPhone = phoneService.updatePhone(id, phone);
        return new ResponseEntity<>(updatedPhone, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
        return ResponseEntity.noContent().build();
    }
}
