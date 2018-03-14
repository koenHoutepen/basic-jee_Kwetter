/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.domain.Kweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class KweetDaoImp implements KweetDao {

    private static KweetDaoImp instance = null;
    private Map<Long, Kweet> kweets;
    private AtomicLong nextId = new AtomicLong(0L);

    public static synchronized KweetDao getKweetDao() {
        if (instance == null) {
            instance = new KweetDaoImp();
        }

        return instance;
    }

    private KweetDaoImp() {
        this.initKwetter();
    }

    public void initKwetter() {
        kweets = new ConcurrentHashMap<>();

        createKweet(new Kweet(new Long(0),"de kweetmeister","welkom bij kwetter" ,new Date()));
        //create(new Kweet("Student 1", "Title 2", "Content 2"));
        //create(new Kweet("Student 1", "Title 3", "Content 3"));
    }

    @Override
    public Kweet createKweet(Kweet k) {
        if (k == null) {
            throw new IllegalArgumentException("Kweet is null");
        }
        k.setKweetId(nextId.getAndIncrement());
        kweets.put(k.getKweetId(), k);
        return k;
    }

    @Override
    public Kweet editKweet(Long id, String author, String message) {
        if (author == null || message == null) {
            throw new IllegalArgumentException("Author, Title or Content is null");
        }
        if (!kweets.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }

        Kweet k = kweets.get(id);
        k.setOwner(author);
        k.setMessage(message);

        return k;
    }

    @Override
    public void deleteKweet(Long id) {
        if (!kweets.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }

        kweets.remove(id);
    }

    @Override
    public Map<Long,Kweet> getAllKweets() {
        return kweets;
    }

    @Override
    public Kweet getKweet(Long id) {
        return null;
    }

    @Override
    public List<Kweet> get10UserKweets(String username) {
        List<Kweet> list = new ArrayList<>();
        int limit = 10;
        for (Map.Entry<Long, Kweet> longKweetEntry : kweets.entrySet()) {
            if (longKweetEntry.getValue().getOwner().equals(username)) {
                Kweet value = longKweetEntry.getValue();
                if (limit-- == 0) break;
                list.add(value);
            }
        }
        return list;
    }

    @Override
    public List<Kweet> getUserKweets(String username) {
        return null;
    }

    @Override
    public List<Kweet> getKweetsByMention(String mention) {
        return null;
    }

    @Override
    public List<Kweet> getKweetsByTrend(String trend) {
        return null;
    }
}
