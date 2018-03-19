package dao;

import controller.domain.Kweet;
import controller.domain.Profile;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Stateless
@JPA
public class ProfileDaoJPAImp implements ProfileDao {
    @Override
    public List<Profile> getProfiles() {
        return null;
    }

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
        return null;
    }

    @Override
    public void setRole(String userName) {

    }

    @Override
    public void addProfile(Profile profile) {

    }

    @Override
    public void deleteProfile(String username) throws Exception {

    }

    @Override
    public void addKweets(Kweet kweet, Profile profile) throws Exception {

    }

    @Override
    public Map<Long, Kweet> getKweets(Profile profile) {
        return null;
    }
}
