package com.academy.sivillageclonebe.review.entity;

import com.academy.sivillageclonebe.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class MediaByReview extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long mediaId;
    private String mediaType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    @Builder
    public MediaByReview(Long mediaId, Review review, String mediaType) {
        this.mediaId = mediaId;
        this.review = review;
        this.mediaType = mediaType;
    }

}
