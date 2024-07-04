package umc.hackathon.domain.entity;

import jakarta.persistence.*;
import umc.hackathon.domain.common.BaseEntity;

@Entity
public class MyPlantImage extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myPlant_id")
    private MyPlant myPlant;
}
