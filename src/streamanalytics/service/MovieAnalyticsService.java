package streamanalytics.service;

import streamanalytics.dto.MovieSummary;
import streamanalytics.model.Movie;

import java.util.*;
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

  //   mapping and data transformation
    public List<String> getMovieTitles(List <Movie> movies) {
        return movies.stream().map(Movie::getTitle).collect(Collectors.toList());
    }
    public List<String> getUppercaseTitles(List <Movie> movies) {
        return movies.stream().map(movie->movie.getTitle().toUpperCase()).collect(Collectors.toList());
    }
    public List<Integer> getDistinctReleaseYears(List <Movie> movies) {
        return movies.stream().map(Movie::getReleaseYear).distinct().collect(Collectors.toList());
    }
    public List<String> getMovieTitlesContainingMoreThanTenCharacters(List <Movie> movies) {
        return movies.stream().map(Movie::getTitle).filter(title->title.length()>10).collect(Collectors.toList());

    }
    public List<String> getMovieDescriptions(List <Movie> movies) {
        return movies.stream().map(movie->movie.getTitle()+"(" + movie.getReleaseYear()+")-Rating: "+movie.getRating()).distinct().collect(Collectors.toList());
    }

    public List<MovieSummary> getMovieSummary(List <Movie> movies) {
        return movies.stream().map(movie->new MovieSummary(movie.getMovieId(), movie.getTitle(), movie.getRating())).collect(Collectors.toList());
    }

    //sorting and ranking
    public List<Movie> sortMovieTitles(List <Movie> movies) {
        return movies.stream().sorted(Comparator.comparing(Movie::getTitle)).collect(Collectors.toList());
    }
    public List<Movie> sortMovieByRating(List <Movie> movies) {
        return movies.stream().sorted(Comparator.comparing(Movie::getRating).reversed()).collect(Collectors.toList());
    }
    public List<Movie> displayTopThreeMovies(List <Movie> movies) {
        return movies.stream().filter(Movie::isAvailable).sorted(Comparator.comparing(Movie::getRating).reversed()).limit(3).collect(Collectors.toList());
   }
   public List<Movie> sortMoviesByReleaseyear(List <Movie> movies) {
        return movies.stream().sorted(Comparator.comparing(Movie::getReleaseYear).reversed()).collect(Collectors.toList());
   }
   public List<Movie> tieMovies(List <Movie> movies) {
        return movies.stream().sorted(Comparator.comparing(Movie::getRating).reversed().thenComparing(Movie::getTitle)).collect(Collectors.toList());
   }
   public Optional<Movie> secondHighestDistinctMovie(List <Movie> movies) {
        return movies.stream().sorted(Comparator.comparing(Movie::getRating).reversed())
                .filter(movie -> movies.stream().map(Movie::getRating).distinct().sorted(Comparator.reverseOrder())
                        .skip(1).findFirst().map(rating->movie.getRating()==rating).orElse(false)).findFirst();
   }
   //Part B - intermediate Stream Operation
    public List<String> getMovieGenres(List <Movie> movies) {
        return movies.stream().flatMap(genre->genre.getGenres().stream()).collect(Collectors.toList());
    }

    public List<String> getUniqueGenres(List <Movie> movies) {
        return movies.stream().flatMap(genre->genre.getGenres().stream()).distinct().sorted().collect(Collectors.toList());
    }
    public Long totalGenres(List <Movie> movies) {
        return movies.stream().flatMap(genre->genre.getGenres().stream()).count();
    }
    public List<Movie> getMovieByGenres(List <Movie> movies , String genre) {
        return movies.stream().filter(g->g.getGenres().contains(genre)).collect(Collectors.toList());
    }
    public List<String> getRepeatedGenres(List <Movie> movies) {
        return movies.stream().flatMap(movie -> movie.getGenres().stream())
                .collect(Collectors.groupingBy(genre->genre,Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).sorted().collect(Collectors.toList());
    }

    public Map<String,List<Movie>> getMoviesByLanguage(List <Movie> movies) {
        return movies.stream().collect(Collectors.groupingBy(Movie::getLanguage));
    }
    public Map<Integer, Long> countMoviesByReleaseYear(List <Movie> movies) {
        return movies.stream().collect(Collectors.groupingBy(Movie::getReleaseYear,Collectors.counting()));
    }
    public Map<String ,Double> averageMovieRating(List <Movie> movies) {
        return movies.stream().collect(Collectors.groupingBy(Movie::getLanguage,Collectors.averagingDouble(Movie::getRating)));
    }
    public Map<Boolean ,List<Movie>> getMoviesByAvailability(List <Movie> movies) {
        return movies.stream().collect(Collectors.groupingBy(Movie::isAvailable));
    }
    public Map<Boolean,List<Movie>> getMovieRange(List <Movie> movies) {
        return movies.stream().collect(Collectors.partitioningBy(movie -> movie.getRating()>=8.0 ));
    }
    public Map<Integer , List<String>> getMovieTitlesByReleaseYear(List <Movie> movies) {
        return movies.stream().collect(Collectors.groupingBy(Movie::getReleaseYear,Collectors.mapping(Movie::getTitle,Collectors.toList())));
    }
}
//


