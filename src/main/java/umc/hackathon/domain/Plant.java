package umc.hackathon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Plant {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int cycle;
}
