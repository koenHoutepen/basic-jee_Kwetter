package dao;

import controller.domain.Kweet;
import controller.domain.Profile;
import dao.KweetDao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Stateless
@JPA
public class KweetDaoJPAImp implements KweetDao{
    private List<Kweet> kweets;
    private AtomicLong nextId;


    @PersistenceContext(unitName = "kwetterPU")
    private EntityManager entityManager;

    @PostConstruct
    public void initKwetter() {
        kweets = new ArrayList<>();
        nextId = new AtomicLong(0);
    }

    @Override
    public Kweet createKweet(Kweet kweet) throws Exception {
        try
        {
            getKweet(kweet.getKweetId());
            throw new InvalidParameterException("id already exists");
        } catch (Exception e) {
            Kweet persistKweet = kweet;
            entityManager.persist(kweet);
            return getKweet(kweet.getKweetId());
        }
    }

    @Override
    public Kweet editKweet(Long id,  String message) throws Exception {
        try
        {
            Kweet newKweet = getKweet(id);
            newKweet.setMessage(message);
            entityManager.merge(newKweet);
            return newKweet;
        }
        catch(Exception e)
        {
            throw new Exception("kweet could not be edited");
        }

    }

    @Override
    public void deleteKweet(Long id) throws Exception {
        kweets.remove(id);
        entityManager.remove(getKweet(id));
    }

    @Override
    public List<Kweet> getAllKweets() {
        return null;
    }

    @Override
    public List<Kweet> getKweetList() {
        return entityManager.createQuery("SELECT k FROM Kweet k", Kweet.class)
                .getResultList();
    }

    @Override
    public Kweet getKweet(Long id) throws Exception {
        Kweet kweet;

        try
        {
            kweet = entityManager.createQuery("SELECT kweet FROM Kweet kweet WHERE kweet.kweetId = :id", Kweet.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
        catch (NoResultException e)
        {
            throw new Exception("Kweet with id " + id + " was not found");
        }

        return kweet;
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
