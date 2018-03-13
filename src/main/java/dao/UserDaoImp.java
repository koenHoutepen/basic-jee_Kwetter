package dao;


import controller.domain.Kweet;
import controller.domain.Profile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@Default
public class UserDaoImp implements UserDao
{
    private Map<String,Profile> mappedprofiles;
    private List<Profile> profiles;

    @PostConstruct
    public void init()
    {
        profiles = new ArrayList<>();
        mappedprofiles = new ConcurrentHashMap<>();
    }

    @Override
    public List<Profile> getProfiles()
    {
        return new ArrayList<>(profiles);
    }

    @Override
    public Map<String, Profile> getMappedProfiles() {
        return mappedprofiles;
    }

    @Override
    public Profile getMappedProfile(String username) throws Exception {
        if(mappedprofiles.containsKey(username)) {
            return mappedprofiles.get(username);
        }
        throw new Exception("User" + username + "does not exist or could not be found");
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
    public List<Kweet> getKweets(Profile profile) {
        return new ArrayList<>(profile.getKweets());
    }
}
