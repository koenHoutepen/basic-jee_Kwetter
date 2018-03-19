package controller.domain;

import javax.persistence.Entity;
import java.util.List;

//@Entity
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
