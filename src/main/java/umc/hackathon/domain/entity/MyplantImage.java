package umc.hackathon.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import umc.hackathon.domain.common.BaseEntity;

@Entity
public class MyplantImage extends BaseEntity {

    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myPlant_id")
    private Myplant myplant;
}
