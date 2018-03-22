package dao;


import controller.domain.Kweet;
import controller.domain.Profile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
@Default
public class ProfileDaoImp implements ProfileDao
{
    private Map<String,Profile> mappedProfiles;
    private List<Profile> profiles;

    @PostConstruct
    public void init()
    {
        profiles = new ArrayList<>();
        mappedProfiles = new ConcurrentHashMap<>();
    }

    @Override
    public List<Profile> getProfiles()
    {
        return new ArrayList<>(profiles);
    }

    @Override
    public Map<String, Profile> getMappedProfiles() {
        return mappedProfiles;
    }

    @Override
    public Profile getMappedProfile(String username) throws Exception {
        if(mappedProfiles.containsKey(username)) {
            return mappedProfiles.get(username);
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
    public void addProfile(Profile profile) throws Exception {
        if(this.mappedProfiles.containsKey(profile.getUsername()))
        {
            throw new Exception("Username already exists");
        }
        else{
            this.mappedProfiles.put(profile.getUsername(),profile);
        }
    }

    @Override
    public Profile createProfile(String username) {
        return null;
    }

    @Override
    public void deleteProfile(String username) throws Exception {
        if(mappedProfiles.containsKey(username)) {
            mappedProfiles.remove(username);
        }
        throw new Exception("User" + username + "does not exist or could not be found");
    }

    @Override
    public void addKweets(Kweet kweet, Profile profile) throws Exception {
        try {
            profile.addKweet(kweet);
        }
        catch(Exception e)
        {
            System.out.println("Userdao addkweets gaat fout: " + e.getMessage());
        }
    }

    @Override
    public void addFollow(Profile followed, Profile follower) {
        //
    }

    @Override
    public Profile editProfile(Profile profile) {
        return null;
    }

    @Override
    public List<Kweet> getKweets(Profile profile) {
        return profile.getKweets();
    }
}
