package com.academy.sivillageclonebe.review.entity;

import com.academy.sivillageclonebe.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String reviewUuid;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @Column(nullable = false, length = 50)
    private String memberUuid;
    @Column(nullable = false, length = 30)
    private String memberName;
    @Column(nullable = false)
    private Integer rating;
    @Column(nullable = false, length = 50)
    private String productOption;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean deleted = false;

    @Builder
    public Review(
            String reviewUuid,
            String content,
            String memberUuid,
            String memberName,
            Integer rating,
            String productOption,
            Boolean deleted
    ) {
        this.reviewUuid = reviewUuid;
        this.content = content;
        this.memberUuid = memberUuid;
        this.memberName = memberName;
        this.rating = rating;
        this.productOption = productOption;
        this.deleted = deleted;
    }

}
