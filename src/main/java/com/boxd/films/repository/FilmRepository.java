package com.boxd.films.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.boxd.films.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Page<Film> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Film> findByGenreContainingIgnoreCase(String genre, Pageable pageable);
    // combinações podem ser criadas conforme necessário
}
