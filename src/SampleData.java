import streamanalytics.model.Movie;
import streamanalytics.model.ViewingRecord;

import java.time.LocalDate;
import java.util.List;

public class SampleData {
    public static List<Movie> getMovies()
    {
        return List.of(
                new Movie(101, "Orbit Run", List.of("Sci-Fi", "Action"), 2022, "English", 8.7, 135, true),
                new Movie(102, "Quiet River", List.of("Drama"), 2020, "English", 8.1, 110, true),
                new Movie(103, "Code Red", List.of("Thriller", "Action"), 2024, "English", 7.9, 125, true),
                new Movie(104, "Moon Garden", List.of("Sci-Fi", "Drama"), 2019, "English", 8.7, 140, false),
                new Movie(105, "City Lights", List.of("Comedy"), 2023, "English", 7.5, 105, true),
                new Movie(106, "The Archive", List.of("Mystery", "Thriller"), 2021, "English", 8.3, 130, true),
                new Movie(107, "Open Road", List.of("Adventure", "Comedy"), 2025, "English", 7.2, 115, true),
                new Movie(108, "The Last Note", List.of("Drama", "Music"), 2018, "English", 8.1, 120, true),
                new Movie(109, "Side Quest", List.of("Comedy", "Action"), 2024, "English", 6.9, 100, false)
        );
    }

    public static List<ViewingRecord>  getViewingRecords()
    {
        return List.of(  new ViewingRecord("S001", 1, 101, 120, LocalDate.of(2026, 10, 25)),
                new ViewingRecord("S002", 2, 102, 90, LocalDate.of(2026, 10, 25)),
                new ViewingRecord("S003", 1, 103, 125, LocalDate.of(2026, 10, 26)),
                new ViewingRecord("S004", 3, 101, 135, LocalDate.of(2026, 10, 26)),
                new ViewingRecord("S005", 2, 104, 60, LocalDate.of(2026, 10, 27)),
                new ViewingRecord("S006", 4, 105, 105, LocalDate.of(2026, 10, 27)),
                new ViewingRecord("S007", 1, 106, 80, LocalDate.of(2026, 10, 28)),
                new ViewingRecord("S008", 3, 102, 110, LocalDate.of(2026, 10, 28)),
                new ViewingRecord("S009", 2, 101, 75, LocalDate.of(2026, 10, 29)),
                new ViewingRecord("S010", 4, 107, 115, LocalDate.of(2026, 10, 29)),
                new ViewingRecord("S011", 1, 108, 50, LocalDate.of(2026, 10, 30)),
                new ViewingRecord("S012", 3, 103, 100, LocalDate.of(2026, 10, 30)),
                new ViewingRecord("S013", 4, 101, 135, LocalDate.of(2026, 10, 31)));
    }
}
