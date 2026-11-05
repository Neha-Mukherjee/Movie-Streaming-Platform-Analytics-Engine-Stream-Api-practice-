package streamanalytics.service;

import streamanalytics.model.Movie;
import streamanalytics.model.ViewingRecord;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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


}
