package com.boxd.films.controller;

import org.springframework.web.bind.annotation.*;
import com.boxd.films.entity.Film;
import com.boxd.films.service.FilmService;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/films")
@CrossOrigin(origins = "http://localhost:3000") // ajuste para o seu front
public class FilmController {
    private final FilmService service;
    public FilmController(FilmService service) { this.service = service; }

    @PostMapping
    public Film create(@RequestBody Film film) { return service.create(film); }

    @GetMapping
    public Page<Film> list(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(required = false) String q) {
        return service.list(page, size, q);
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable Long id) {
        return service.get(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PutMapping("/{id}")
    public Film update(@PathVariable Long id, @RequestBody Film film) {
        return service.update(id, film);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}

