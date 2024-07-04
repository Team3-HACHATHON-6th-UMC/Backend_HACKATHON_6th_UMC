package umc.hackathon.domain.entity;

import jakarta.persistence.*;
import umc.hackathon.domain.common.BaseEntity;

public class DiaryImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id")
    private Diary diary;

}




