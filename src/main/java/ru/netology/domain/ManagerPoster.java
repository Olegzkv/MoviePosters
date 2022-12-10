package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ManagerPoster {
    private MoviePoster[] movies = new MoviePoster[0];
    private int limit = 10;

    public ManagerPoster(int limit) {
        this.limit = limit;
    }

    public void addMoviePoster(MoviePoster movie) {
        int length = movies.length + 1;
        MoviePoster[] tmp = new MoviePoster[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MoviePoster[] findAll() {
        MoviePoster[] result = new MoviePoster[movies.length];
        System.arraycopy(movies, 0, result, 0, movies.length);
        return result;
    }

    public MoviePoster[] findLast() {
        int resultLength;
        if (limit > movies.length) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        MoviePoster[] result = new MoviePoster[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}