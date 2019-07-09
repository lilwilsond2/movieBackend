package com.example.movie.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Entity
public class Movie {
    @Id
    private String id;
    @Size(min = 1, max = 50)
    private String title;
    @Enumerated(EnumType.STRING)
    private Format format;
    @Min(0) @Max(30000)
    private Integer length;
    @Min(1800) @Max(2100)
    private Integer releaseYear;
    @Min(1) @Max(5)
    private Integer rating;
}
