package streamanalytics.dto;

public class MovieSummary
{
    private int movieId;
    private String title;
    private double rating;

    public MovieSummary(int movieId, String title, double rating)
    {
        this.movieId = movieId;
        this.title = title;
        this.rating = rating;
    }
    @Override
    public String toString()
    {
        return "MovieSummary{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
