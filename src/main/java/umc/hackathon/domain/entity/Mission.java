package umc.hackathon.domain.entity;

import jakarta.persistence.*;
import umc.hackathon.domain.enums.MissionStatus;

@Entity
public class Mission {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    private int point;

}
