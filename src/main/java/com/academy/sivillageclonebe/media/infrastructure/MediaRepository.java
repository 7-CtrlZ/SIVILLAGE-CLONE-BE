package com.academy.sivillageclonebe.media.infrastructure;


import com.academy.sivillageclonebe.media.domain.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
