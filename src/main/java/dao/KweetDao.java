package dao;

import controller.domain.Kweet;

import java.util.List;
import java.util.Map;

public interface KweetDao {

    Kweet createKweet(Kweet kweet) throws Exception;
    
    Kweet editKweet(Long id, String author, String title);
    
    void deleteKweet(Long id);

    Map<Long,Kweet> getAllKweets();

    List<Kweet> getKweetList();

    Kweet getKweet(Long id);

    List<Kweet> get10UserKweets(String Username);

    List<Kweet> getUserKweets(String Username);

    List<Kweet> getKweetsByMention(String mention);

    List<Kweet> getKweetsByTrend(String trend);
}
