package co.uptc.Taller.SpringBoot.entities;


import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "phones")
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    private LocalDate deadline;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToMany
    @JoinTable(
            name = "phone_technical",
            joinColumns = @JoinColumn(name = "phone_id"),
            inverseJoinColumns = @JoinColumn(name = "technical_id")
    )
    private List<Technical> technicians;


    public Phone() {
    }


    public Phone(String brand, String reference, LocalDate deadline, Owner owner, List<Technical> technicians) {
        this.brand = brand;
        this.reference = reference;
        this.deadline = deadline;
        this.owner = owner;
        this.technicians = technicians;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Technical> getTechnicians() {
        return technicians;
    }

    public void setTechnicians(List<Technical> technicians) {
        this.technicians = technicians;
    }
}
