package dao;

import controller.domain.Kweet;
import controller.domain.Profile;
import dao.KweetDao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Stateless
@JPA
public class KweetDaoJPAImp implements KweetDao{
    @Override
    public Kweet createKweet(Kweet kweet) throws Exception {
        return null;
    }

    @Override
    public Kweet editKweet(Long id, String author, String title) {
        return null;
    }

    @Override
    public void deleteKweet(Long id) {

    }

    @Override
    public Map<Long, Kweet> getAllKweets() {
        return null;
    }

    @Override
    public List<Kweet> getKweetList() {
        return null;
    }

    @Override
    public Kweet getKweet(Long id) {
        return null;
    }

    @Override
    public List<Kweet> get10UserKweets(String Username) {
        return null;
    }

    @Override
    public List<Kweet> getUserKweets(String Username) {
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
