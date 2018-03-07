package dao;

import controller.domain.Kweet;

import java.util.List;

public interface KweetDao {

    Kweet create(Kweet k);
    
    Kweet edit(Long id, String author, String title);
    
    void delete(Long id);

    List<Kweet> findAll();

    Kweet findKweet(Long id);

    List<Kweet> get10UserKweets(String Username);

    List<Kweet> getUserKweets(String Username);

    List<Kweet> getKweetsByMention(String mention);

    List<Kweet> getKweetsByTrend(String trend);
}
