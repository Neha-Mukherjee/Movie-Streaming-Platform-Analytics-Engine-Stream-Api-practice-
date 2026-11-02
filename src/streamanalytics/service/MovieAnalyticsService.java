package streamanalytics.service;

import streamanalytics.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

public class MovieAnalyticsService {
    public List<Movie> getHighlyRatedMovies(List <Movie> movies) {
        List<Movie> movie = movies.stream().filter(m-> m.getRating()>=8.0).collect(Collectors.toList());
        return movie;
    }

    public List<Movie> getMoviesReleasedAfterYear(List <Movie> movies) {
        List<Movie> movie = movies.stream().filter(release->release.getReleaseYear()>2020).collect(Collectors.toList());
        return movie;
    }
    public List<Movie> getActionMovies(List <Movie> movies) {
        List<Movie> movie = movies.stream().filter(g->g.isAvailable() && g.getGenres().contains("Action")).collect(Collectors.toList());
        return movie;
    }
    public List<Movie> getMoviesOnDuration(List <Movie> movies) {
        List<Movie> movie = movies.stream().filter(d->d.getDurationMinutes()>120).collect(Collectors.toList());
        return movie;
    }
    public List<Movie> getUnavailableMovies(List <Movie> movies) {
        List<Movie> movie = movies.stream().filter(m->!m.isAvailable()).collect(Collectors.toList());
        return movie;
    }
    public List<Movie>  getMoviesInYearRange(List <Movie> movies , int startYear, int endYear) {
        List<Movie> movie = movies.stream().filter(y->y.getReleaseYear()>=startYear && y.getReleaseYear()<=endYear).collect(Collectors.toList());
    return movie;
    }


}


