package com.boxd.films.service;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.boxd.films.repository.FilmRepository;
import com.boxd.films.entity.Film;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepository repo;
    public FilmService(FilmRepository repo) { this.repo = repo; }

    public Film create(Film f) { return repo.save(f); }

    public Page<Film> list(int page, int size, String search) {
        Pageable p = PageRequest.of(page, size, Sort.by("createdAt").descending());
        if (search == null || search.isBlank()) return repo.findAll(p);
        return repo.findByTitleContainingIgnoreCase(search, p);
    }

    public Optional<Film> get(Long id) { return repo.findById(id); }
    public Film update(Long id, Film update) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(update.getTitle());
            existing.setYear(update.getYear());
            existing.setGenre(update.getGenre());
            existing.setDirector(update.getDirector());
            existing.setSynopsis(update.getSynopsis());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Film not found"));
    }
    public void delete(Long id) { repo.deleteById(id); }
}