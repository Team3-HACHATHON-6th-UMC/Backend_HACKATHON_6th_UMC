package umc.hackathon.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import umc.hackathon.domain.common.BaseEntity;

@Entity
public class Plant extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private Integer cycle;

    private Integer sumLevel;

    private String description;
}
