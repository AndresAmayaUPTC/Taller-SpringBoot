package co.uptc.Taller.SpringBoot.controllers;

import co.uptc.Taller.SpringBoot.entities.Technical;
import co.uptc.Taller.SpringBoot.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technicals")
public class TechnicalController {

    private final TechnicalService technicalService;

    @Autowired
    public TechnicalController(TechnicalService technicalService) {
        this.technicalService = technicalService;
    }


    @GetMapping
    public ResponseEntity<List<Technical>> getAllTechnicals() {
        List<Technical> technicals = technicalService.getAllTechnicals();
        return new ResponseEntity<>(technicals, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Technical> getTechnicalById(@PathVariable Integer id) {
        Technical technical = technicalService.getTechnicalById(id);
        if (technical != null) {
            return new ResponseEntity<>(technical, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<Technical> createTechnical(@RequestBody Technical technical) {
        Technical createdTechnical = technicalService.createTechnical(technical);
        return new ResponseEntity<>(createdTechnical, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Technical> updateTechnical(@PathVariable Integer id, @RequestBody Technical technical) {
        Technical updatedTechnical = technicalService.updateTechnical(id, technical);
        if (updatedTechnical != null) {
            return new ResponseEntity<>(updatedTechnical, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnical(@PathVariable Integer id) {
        technicalService.deleteTechnical(id);
        return ResponseEntity.noContent().build();
    }
}
