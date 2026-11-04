import streamanalytics.model.Movie;
import streamanalytics.service.MovieAnalyticsService;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     List<Movie> movies = SampleData.getMovies();
        MovieAnalyticsService service = new MovieAnalyticsService();

        //PART A
        System.out.println("\n Movie Summaries");
       service.getMovieSummary(movies).forEach(System.out::println);

        System.out.println("1. Highly Rated Movies:");
        service.getHighlyRatedMovies(movies).forEach(System.out::println);

        System.out.println("\n2. Movies Released After 2020:");
        service.getMoviesReleasedAfterYear(movies).forEach(System.out::println);

        System.out.println("\n3. Available Action Movies:");
        service.getActionMovies(movies).forEach(System.out::println);

        System.out.println("\n4. Movies Longer Than 120 Minutes:");
        service.getMoviesOnDuration(movies).forEach(System.out::println);

        System.out.println("\n5. Unavailable Movies:");
        service.getUnavailableMovies(movies).forEach(System.out::println);

        System.out.println("\n6. Movies Between 2018 and 2022:");
        service.getMoviesInYearRange(movies, 2018, 2022)
                .forEach(System.out::println);

// 1. Sort by title alphabetically
        System.out.println("\nMovies Sorted by Title:");
        service.sortMovieTitles(movies).forEach(System.out::println);

// 2. Sort by rating descending
        System.out.println("\nMovies Sorted by Rating (High to Low):");
        service.sortMovieByRating(movies).forEach(System.out::println);

// 3. Top 3 highest-rated available movies
        System.out.println("\nTop 3 Available Movies:");
        service.displayTopThreeMovies(movies).forEach(System.out::println);

// 4. Sort by release year descending
        System.out.println("\nMovies Sorted by Release Year:");
        service.sortMoviesByReleaseyear(movies).forEach(System.out::println);

// 5. Rating descending, then title alphabetically
        System.out.println("\nMovies Sorted by Rating and Title:");
        service.tieMovies(movies).forEach(System.out::println);

// 6. Second-highest distinct rating
        System.out.println("\nSecond Highest Distinct Rated Movie:");
        service.secondHighestDistinctMovie(movies)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No second-highest distinct rating found")
                );

        //PART B

// 1. All genres
     System.out.println("All Genres: " + service.getMovieGenres(movies));

// 2. Unique genres, sorted
     System.out.println("Unique Genres: " + service.getUniqueGenres(movies));

// 3. Total genre assignments
     System.out.println("Total Genre Assignments: " + service.totalGenres(movies));

// 4. Movies by a specific genre
     System.out.println("Action Movies:");

     service.getMovieByGenres(movies, "Action").forEach(System.out::println);

// 5. Genres appearing more than once
     System.out.println("Repeated Genres: " + service.getRepeatedGenres(movies));

    }
}