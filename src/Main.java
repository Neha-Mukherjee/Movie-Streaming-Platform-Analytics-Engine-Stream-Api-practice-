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


     // Problem 5

// 1. Group movies by language
     System.out.println("\nMovies by Language:");
     service.getMoviesByLanguage(movies)
             .forEach((language, movieList) -> {
              System.out.println(language + ":");
              movieList.forEach(System.out::println);
             });

// 2. Count movies by release year
     System.out.println("\nCount by Release Year:");
     service.countMoviesByReleaseYear(movies)
             .forEach((year, count) ->
                     System.out.println(year + ": " + count));

// 3. Average rating by language
     System.out.println("\nAverage Rating by Language:");
     service.averageMovieRating(movies)
             .forEach((language, average) ->
                     System.out.println(language + ": " + average));

// 4. Group by availability
     System.out.println("\nMovies by Availability:");
     service.getMoviesByAvailability(movies)
             .forEach((available, movieList) -> {
              System.out.println("Available = " + available + ":");
              movieList.forEach(System.out::println);
             });

// 5. Partition by rating >= 8
     System.out.println("\nMovies with Rating >= 8:");
     service.getMovieRange(movies).get(true)
             .forEach(System.out::println);

     System.out.println("\nMovies with Rating < 8:");
     service.getMovieRange(movies).get(false)
             .forEach(System.out::println);

// 6. Group movie titles by release year
     System.out.println("\nMovie Titles by Release Year:");
     service.getMovieTitlesByReleaseYear(movies)
             .forEach((year, titles) ->
                     System.out.println(year + ": " + titles));





// 1. Movie ID -> Movie
        System.out.println("\nMovie ID to Movie:");
        service.createMapAndDuplicationHandling(movies)
                .forEach((id, movie) ->
                        System.out.println(id + " -> " + movie));

// 2. Movie Title -> Rating
        System.out.println("\nMovie Title to Rating:");
        service.createMapMoviesTitlesAndRating(movies)
                .forEach((title, rating) ->
                        System.out.println(title + " -> " + rating));

// 3. Movie Title -> Release Year
        System.out.println("\nMovie Title to Release Year:");
        service.createMapMoviesTitlesAndReleaseYears(movies)
                .forEach((title, year) ->
                        System.out.println(title + " -> " + year));

// 4. Movie Title -> Movie (duplicate titles handled)
        System.out.println("\nMovie Title to Movie with Duplicate Handling:");
        service.createMapWithDuplicateHandling(movies)
                .forEach((title, movie) ->
                        System.out.println(title + " -> " + movie));
    }




}