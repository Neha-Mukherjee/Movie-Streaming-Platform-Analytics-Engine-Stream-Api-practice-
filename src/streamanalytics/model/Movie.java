package streamanalytics.model;

import java.util.List;

public class Movie {
    private int movieId;
    private String title;
    private List<String> genres;
    private int releaseYear;
    private String language ;
    private double rating;
    private int durationMinutes;
    private boolean available;

    public Movie(int movieId, String title, List<String> genres, int releaseYear, String language, double rating, int durationMinutes, boolean available) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.language = language;
        this.rating = rating;
        this.durationMinutes = durationMinutes;
        this.available = available;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getLanguage() {
        return language;
    }

    public double getRating() {
        return rating;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
                return "Movie{" +
                        "movieId=" + movieId +
                        ", title='" + title + '\'' +
                        ", genres=" + genres +
                        ", releaseYear=" + releaseYear +
                        ", language='" + language + '\'' +
                        ", rating=" + rating +
                        ", durationMinutes=" + durationMinutes +
                        ", available=" + available +
                        '}';
    }
}
