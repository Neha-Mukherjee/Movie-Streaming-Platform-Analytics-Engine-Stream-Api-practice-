import streamanalytics.model.Movie;
import streamanalytics.service.MovieAnalyticsService;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     List<Movie> movies = SampleData.getMovies();
        MovieAnalyticsService service = new MovieAnalyticsService();

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



    }
}