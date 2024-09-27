package com.academy.sivillageclonebe.media.entity;

import com.academy.sivillageclonebe.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Media extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String mediaUrl;

    @Column(nullable = false, length = 200)
    private String mediaName;

    @Column(nullable = false, length = 20)
    private String mediaType;

    @Builder
    public Media(Long id, String mediaUrl, String mediaName, String mediaType) {
        this.id = id;
        this.mediaUrl = mediaUrl;
        this.mediaName = mediaName;
        this.mediaType = mediaType;
    }

}
