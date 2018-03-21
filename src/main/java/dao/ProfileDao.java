package dao;


import controller.domain.Kweet;
import controller.domain.Profile;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProfileDao
{

    List<Profile> getProfiles();

    Map<String,Profile> getMappedProfiles();

    Profile getMappedProfile(String username) throws Exception;

    Profile getProfile(String userName) throws Exception;

    void setRole(String userName);

    void addProfile(Profile profile) throws Exception;

    Profile createProfile(String username);

    void deleteProfile(String username) throws Exception;

    void addKweets(Kweet kweet, Profile profile) throws Exception;

    Profile editProfile(Profile profile) throws Exception;

    List<Kweet> getKweets(Profile profile);
}
