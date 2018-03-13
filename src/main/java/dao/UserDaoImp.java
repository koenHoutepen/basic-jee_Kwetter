package dao;


import controller.domain.Kweet;
import controller.domain.Profile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Default
public class UserDaoImp implements UserDao
{
    private List<Profile> profiles;

    @PostConstruct
    public void init()
    {
        profiles = new ArrayList<>();
        // users toevoegen
    }

    @Override
    public List<Profile> getProfiles()
    {
        return new ArrayList<Profile>(profiles);
    }


    @Override
    public Profile getProfile(String userName) throws Exception {
        for (Profile checkProfile:profiles) {
            if(checkProfile.getUsername().equals(userName))
            {
                return checkProfile;
            }
        }
        throw new Exception("user " + userName + " does not exist");
    }

    @Override
    public void setRole(String userName) {

    }

    @Override
    public void addProfile(Profile profile) {
        this.profiles.add(profile);
    }

    @Override
    public void addKweets(Kweet kweet, Profile profile) throws Exception {
        this.getProfile(profile.getUsername()).addKweet(kweet);
    }

    @Override
    public Profile createUserProfile(String username, String password) throws InvalidParameterException {
        return null;
    }

    @Override
    public Profile createProfile(String username, String password) {
        return null;
    }

    @Override
    public List<Kweet> getKweets(Profile profile) {
        return new ArrayList<>(profile.getKweets());
    }
}
