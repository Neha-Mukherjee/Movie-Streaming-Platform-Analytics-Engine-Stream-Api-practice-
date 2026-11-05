package streamanalytics.model;

import java.time.LocalDate;

public class ViewingRecord {
    private String sessionId;
    private int userId;
    private int movieId;
    private int minutesWatched;
    private LocalDate watchedOn;

    public ViewingRecord(String sessionId, int userId, int movieId, int minutesWatched, LocalDate watchedOn) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.movieId = movieId;
        this.minutesWatched = minutesWatched;
        this.watchedOn = watchedOn;
    }

    public String getSessionId() {
        return sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getMinutesWatched() {
        return minutesWatched;
    }

    public LocalDate getWatchedOn() {
        return watchedOn;
    }

    public String toString() {
        return "Session id:"+sessionId +"\t" + "User id:\t "+ userId + "\t"+"Movie Id:\t "  + movieId + "\t"+"Minutes Watched:\t " + minutesWatched+ "\t"+ "Watched On:\t " + watchedOn+ "\t";
    }
}
