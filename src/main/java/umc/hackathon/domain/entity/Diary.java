package umc.hackathon.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.hackathon.domain.common.BaseEntity;
import umc.hackathon.web.dto.Diary.DiaryRequestDTO;

@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Diary extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Column(length = 2048)
    private String imageUrl;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public void setUser(User user) {
        this.user = user;
    }

    public void update(DiaryRequestDTO.UpdateDiaryDTO request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }

}
