package Services;


import controller.domain.Kweet;
import controller.domain.Profile;
import dao.JPA;
import dao.KweetDao;
import dao.ProfileDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Stateless
public class ProfileService {
    @Inject
    @JPA
    private ProfileDao profileDao;
    @Inject
    @JPA
    private KweetDao kweetDao;

    public Profile getProfile(String profileName) throws Exception {
        return this.profileDao.getProfile(profileName);
    }

    public Profile getMappedProfile(String profileName) throws Exception
    {
        return this.profileDao.getMappedProfile(profileName);
    }

    public Map<String,Profile> getProfileMap()
    {
        return this.profileDao.getMappedProfiles();
    }

    public List<Profile> getProfiles()
            {
                return this.profileDao.getProfiles();
            }

    public void addProfile(Profile profile) throws Exception
    {
        //this.profileDao.addProfile(profile);
        this.profileDao.createProfile(profile.getUsername());

    }

    public void deleteProfile(Profile deleteProfile) throws Exception {this.profileDao.deleteProfile(deleteProfile.getUsername());}

    public void addKweet(Kweet kweet, Profile profile) throws Exception
    {
        this.profileDao.addKweets(this.kweetDao.createKweet(kweet),profile);
    }
}
