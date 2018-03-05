package domain;

import java.util.List;

public class Trend {
    private String trendName;
    private Kweet originKweet;
    private List<String> trendKweets;

    public Trend(String trendName, Kweet originKweet, List<String> trendKweets) {
        this.trendName = trendName;
        this.originKweet = originKweet;
        this.trendKweets = trendKweets;
    }
}
