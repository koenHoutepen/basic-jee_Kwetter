package dao;


import controller.domain.Profile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Default
public class UserDaoImp implements UserDao
{

    private Map<String, Profile> profiles;

    @PostConstruct
    public void init()
    {
        profiles = new HashMap<>();
        // users toevoegen
    }

    @Override
    public List<Profile> getProfiles()
    {
        return new ArrayList<>(profiles.values());
    }


    @Override
    public Profile getProfile(String userName) throws Exception {
        if (!profiles.containsKey(userName))
        {
            throw new Exception("user " + userName + " does not exist");
        }

        return profiles.get(userName);
    }

    @Override
    public void setRole(String userName) {

    }

    @Override
    public Profile createProfile(String username, String password) {
        return null;
    }
}
