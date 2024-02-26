package co.uptc.Taller.SpringBoot.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "owners")
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String document;

    @OneToOne(mappedBy = "owner")
    private Phone phone;


    public Owner() {
    }


    public Owner(String name, String document, Phone phone) {
        this.name = name;
        this.document = document;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
