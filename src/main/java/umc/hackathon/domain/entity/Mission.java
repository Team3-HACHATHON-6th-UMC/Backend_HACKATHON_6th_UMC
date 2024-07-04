package umc.hackathon.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.hackathon.domain.common.BaseEntity;
import umc.hackathon.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    private Integer point;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "myPlant_id")
    private MyPlant myPlant;

}
