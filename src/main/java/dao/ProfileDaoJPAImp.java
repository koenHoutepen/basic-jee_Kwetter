package dao;

import controller.domain.Kweet;
import controller.domain.Profile;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.xml.registry.infomodel.User;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

@Stateless
@JPA
public class ProfileDaoJPAImp implements ProfileDao {
    @PersistenceContext(unitName = "kwetterPU")
    private EntityManager entityManager;

    @Override
    public List<Profile> getProfiles() {
        return entityManager.createQuery("SELECT p FROM Profile p", Profile.class)
                .getResultList();    }

    @Override
    public Map<String, Profile> getMappedProfiles() {
        return null;
    }

    @Override
    public Profile getMappedProfile(String username) throws Exception {
        return null;
    }

    @Override
    public Profile getProfile(String userName) throws Exception {
        try
        {
            return entityManager.createQuery("SELECT profile FROM Profile profile WHERE profile.username = :username", Profile.class)
                    .setParameter("username", userName)
                    .getSingleResult();
        }
        catch (NoResultException e)
        {
            System.out.println("User " + userName + " was not found");
            throw new Exception("User " + userName + " was not found");
        }
    }

    @Override
    public void setRole(String userName) {

    }

    @Override
    public void addProfile(Profile profile) {
        try
        {
            getProfile(profile.getUsername());
            throw new InvalidParameterException("username already exists");
        } catch (Exception e) {
            Profile persistProfile = profile;
            entityManager.persist(persistProfile);
        }

    }

    @Override
    public Profile createProfile(String username) {
        try
        {
            getProfile(username);
            throw new Exception("User already exists");
        }
        catch (Exception e)
        {
            // continue?
            Profile persistProfile = new Profile(username);
            entityManager.persist(persistProfile);

            return persistProfile;
        }
    }

    @Override
    public void deleteProfile(String username) throws Exception {
        entityManager.remove(getProfile(username));
    }

    @Override
    public void addKweets(Kweet kweet, Profile profile) throws Exception {
        try {
            profile.addKweet(kweet);
            entityManager.merge(profile);
        }
        catch(Exception e)
        {
            System.out.println("profiledao addkweets gaat fout: " + e.getMessage() + ". kweet : " + kweet.getKweetId().toString() + " "+ kweet.getMessage() + " "
                    + kweet.getOwner().getUsername().toString() + ". profile " + profile.getUsername());
        }
    }

    @Override
    public Profile editProfile(Profile profile) throws Exception {
        getProfile(profile.getUsername());

        entityManager.merge(profile);

        return profile;
    }

    @Override
    public List<Kweet> getKweets(Profile profile) {
        return null;
    }
}
