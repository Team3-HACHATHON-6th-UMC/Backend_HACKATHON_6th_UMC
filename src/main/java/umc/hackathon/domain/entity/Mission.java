package umc.hackathon.domain.entity;

import jakarta.persistence.*;
import umc.hackathon.domain.common.BaseEntity;
import umc.hackathon.domain.enums.MissionStatus;

@Entity
public class Mission extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    private Integer point;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "myplant_id")
    private Myplant myplant;

}
