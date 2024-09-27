package com.academy.sivillageclonebe.media.repository;


import com.academy.sivillageclonebe.media.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
