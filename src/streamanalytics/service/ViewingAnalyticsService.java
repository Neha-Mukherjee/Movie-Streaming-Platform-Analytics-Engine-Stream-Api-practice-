package streamanalytics.service;

import streamanalytics.model.Movie;
import streamanalytics.model.ViewingRecord;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class ViewingAnalyticsService {

    public Integer GetTotalMinutesWatched(List<ViewingRecord> viewingRecords) {
        return viewingRecords.stream().mapToInt(ViewingRecord::getMinutesWatched).sum();
    }

    public Optional<Integer> getHighestViewingUser(List<ViewingRecord> viewingRecords) {
        return viewingRecords.stream().collect(Collectors.groupingBy(ViewingRecord::getUserId, Collectors.summingInt(ViewingRecord::getMinutesWatched)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
    }

    public Map<Integer, Long> getViewingSessionsPerMovie(List<ViewingRecord> viewingRecords) {
        return viewingRecords.stream().collect(Collectors.groupingBy(ViewingRecord::getMovieId,Collectors.counting()));
    }
    public Optional<Integer> getMostWatchedMovie(List<ViewingRecord> viewingRecords) {
        Map<Integer, Integer> totalMinutes = viewingRecords.stream().collect(Collectors.groupingBy(ViewingRecord::getMovieId, Collectors.summingInt(ViewingRecord::getMinutesWatched)));
        Optional<Integer> maxMinutes = totalMinutes.values().stream().max(Integer::compareTo);

        return maxMinutes.flatMap(max -> totalMinutes.entrySet().stream().filter(entry -> entry.getValue().equals(max)).map(Map.Entry::getKey).min(Integer::compareTo));
    }
    public Set<Integer> getUniqueMovieIdsByUser(List<ViewingRecord> viewingRecords, Integer userId) {

        return viewingRecords.stream()
                .filter(record -> record.getUserId()==(userId))
                .map(ViewingRecord::getMovieId)
                .collect(Collectors.toSet());
    }
    public List<Movie> getMoviesWithNoViewingRecords(List<Movie> movies, List<ViewingRecord> viewingRecords) {

        Set<Integer> viewedMovieIds = viewingRecords.stream()
                .map(ViewingRecord::getMovieId)
                .collect(Collectors.toSet());

        return movies.stream()
                .filter(movie -> !viewedMovieIds.contains(movie.getMovieId()))
                .toList();
    }
    public Map<LocalDate, List<ViewingRecord>> groupViewingRecordsByDate(List<ViewingRecord> viewingRecords) {

        return viewingRecords.stream().collect(Collectors.groupingBy(ViewingRecord::getWatchedOn));
    }
    public Optional<Integer> getTotalMinutesUsingReduce(List<ViewingRecord> viewingRecords) {
        return viewingRecords.stream()
                .map(ViewingRecord::getMinutesWatched)
                .reduce(Integer::sum);
    }
    public Integer getTotalMovieDuration(List<Movie> movies) {
        return movies.stream().mapToInt(Movie::getDurationMinutes).sum();
    }

    public OptionalDouble getAverageMovieRating(List<Movie> movies) {
        return movies.stream().mapToDouble(Movie::getRating).average();
    }

  public OptionalDouble getHighestRating(List<Movie> movies ) {
        return  movies.stream().mapToDouble(Movie::getRating).max();
  }
    public OptionalDouble getLowestRating(List<Movie> movies ) {
        return  movies.stream().mapToDouble(Movie::getRating).min();
    }
  //  Obtain count, minimum, maximum, sum, and average movie duration using summary statistics.
  public IntSummaryStatistics getMovieDurationStatistics(List<Movie> movies) {
      return movies.stream()
              .mapToInt(Movie::getDurationMinutes)
              .summaryStatistics();
  }
    public Optional<Movie> findMovieById(List<Movie> movies, int movieId) {
        return movies.stream()
                .filter(movie -> movie.getMovieId() == movieId)
                .findFirst();
    }
    public Movie getMovieByIdOrThrow(List<Movie> movies, int movieId) {
        return findMovieById(movies, movieId)
                .orElseThrow(() ->
                        new NoSuchElementException("Movie ID " + movieId + " not found"));
    }

    //problem 9
    public List<Movie> recommendMovies(
            List<Movie> movies,
            Set<String> preferredGenres,
            double minimumRating,
            int limit) {

        if (preferredGenres == null || preferredGenres.isEmpty()) {
            return List.of();
        }

        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }

        return movies.stream()
                .filter(Movie::isAvailable)
                .filter(movie -> movie.getRating() >= minimumRating)
                .filter(movie -> movie.getGenres().stream()
                        .anyMatch(preferredGenres::contains))
                .distinct()
                .sorted(Comparator.comparingDouble(Movie::getRating)
                        .reversed()
                        .thenComparing(
                                Comparator.comparingInt(Movie::getReleaseYear).reversed()))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
