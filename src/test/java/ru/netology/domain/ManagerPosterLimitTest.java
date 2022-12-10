package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerPosterLimitTest {

    private ManagerPoster manager = new ManagerPoster(3);
    private MoviePoster first = new MoviePoster(1, "Бладшот", "Боевик");
    private MoviePoster second = new MoviePoster(2, "Вперед", "Мультфильм");
    private MoviePoster third = new MoviePoster(3, "Отель Белград", "Комедия");
    private MoviePoster fourth = new MoviePoster(4, "Джентельмены", "Боевик");

    @BeforeEach
    public void setUp() {
        manager.addMoviePoster(first);
        manager.addMoviePoster(second);
        manager.addMoviePoster(third);
        manager.addMoviePoster(fourth);
    }

    @Test
    public void shouldGetLastMovieWithLimitManual() {
        MoviePoster[] actual = manager.findLast();
        MoviePoster[] expected = new MoviePoster[]{fourth, third, second};
        assertArrayEquals(actual, expected);
    }
}