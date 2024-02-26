package co.uptc.Taller.SpringBoot.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "technicals")
public class Technical implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String experience;


    public Technical() {
    }


    public Technical(String name, String experience) {
        this.name = name;
        this.experience = experience;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
