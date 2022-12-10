package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerPosterTest {
    private ManagerPoster manager = new ManagerPoster();
    private MoviePoster first = new MoviePoster(1, "Бладшот", "Боевик");
    private MoviePoster second = new MoviePoster(2, "Вперед", "Мультфильм");
    private MoviePoster third = new MoviePoster(3, "Отель Белград", "Комедия");
    private MoviePoster fourth = new MoviePoster(4, "Джентельмены", "Боевик");

    @BeforeEach
    public void setUp() {
        manager.addMoviePoster(first);
        manager.addMoviePoster(second);
        manager.addMoviePoster(third);
    }

    @Test
    public void shouldAddMovie() {
        manager.addMoviePoster(fourth);
        MoviePoster[] actual = manager.getMovies();
        MoviePoster[] expected = new MoviePoster[]{first, second, third, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetAll() {
        MoviePoster[] actual = manager.findAll();
        MoviePoster[] expected = new MoviePoster[]{first, second, third};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetLastMovieWithLimit() {
        MoviePoster[] actual = manager.findLast();
        MoviePoster[] expected = new MoviePoster[]{third, second, first};
        assertArrayEquals(actual, expected);
    }
}