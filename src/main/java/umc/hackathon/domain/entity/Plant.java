package umc.hackathon.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import umc.hackathon.domain.common.BaseEntity;

@Entity
@Getter
public class Plant extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer cycle;

    private Integer sunLevel;

    private String description;
}
