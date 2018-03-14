package Services;


import controller.domain.Kweet;
import controller.domain.Profile;
import dao.UserDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Stateless
public class ProfileService {
    @Inject
    private UserDao userDao;

    public Profile getProfile(String profileName) throws Exception {
        return this.userDao.getProfile(profileName);
    }

    public Profile getMappedProfile(String profileName) throws Exception
    {
        return this.userDao.getMappedProfile(profileName);
    }

    public Map<String,Profile> getProfileMap()
    {
        return this.userDao.getMappedProfiles();
    }

    public List<Profile> getProfiles()
            {
                return this.userDao.getProfiles();
            }

    public void addProfile(Profile profile){this.userDao.addProfile(profile);}
    public void addKweet(Kweet kweet, Profile profile) throws Exception {this.userDao.addKweets(kweet,profile);}
}
