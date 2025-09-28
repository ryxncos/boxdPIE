package com.boxd.films.dto;

import jakarta.validation.constraints.NotBlank;

public class FilmCreateDto {
	@NotBlank
	private String title;
	private int year;
	private String genre;
	private String director;
	private String synopsis;
	
}
