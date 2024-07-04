package umc.hackathon.domain.entity;

import jakarta.persistence.*;
import umc.hackathon.domain.common.BaseEntity;

public class Diary extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
