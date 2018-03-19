/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.domain.Kweet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
@Default
public class KweetDaoImp implements KweetDao {

    //private static KweetDaoImp instance = null;
    private Map<Long, Kweet> kweets;
    private AtomicLong nextId;


//    public static synchronized KweetDao getKweetDao() {
//        if (instance == null) {
//            instance = new KweetDaoImp();
//        }
//
//        return instance;
//    }

//    private KweetDaoImp() {
//        this.initKwetter();
//    }

    @PostConstruct
    public void initKwetter() {
        kweets = new ConcurrentHashMap<>();
        nextId = new AtomicLong(0);

        //createKweet(new Kweet(new Long(0),"de kweetmeister","welkom bij kwetter" ,new Date()));
        //create(new Kweet("Student 1", "Title 2", "Content 2"));
        //create(new Kweet("Student 1", "Title 3", "Content 3"));
    }

    @Override
    public Kweet createKweet(Kweet kweet) throws Exception {
        if (kweet == null) {
            throw new IllegalArgumentException("Kweet is null");
        }
        try {
            kweet.setKweetId(nextId.getAndIncrement());
            kweets.put(kweet.getKweetId(), kweet);
            return kweet;
        }
        catch (Exception e)
        {
            throw new Exception("createKweet failed");
        }
    }

    @Override
    public Kweet editKweet(Long id,String message) {
        if (message == null) {
            throw new IllegalArgumentException("Content is null");
        }
        if (!kweets.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }

        Kweet k = kweets.get(id);
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
    public List<Kweet> getKweetList()
    {
        return new ArrayList<>(kweets.values());
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
