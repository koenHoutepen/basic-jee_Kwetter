package dao;


import controller.domain.Kweet;
import controller.domain.Profile;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao
{
    List<Profile> getProfiles();

    Profile getProfile(String userName) throws Exception;

    void setRole(String userName);

    void addProfile(Profile profile);

    void addKweets(Kweet kweet, Profile profile) throws Exception;

    default Profile createUserProfile(
            String username,
            String password) throws InvalidParameterException
    {return createUserProfile(username, password);}

    Profile createProfile(String username, String password);

    List<Kweet> getKweets(Profile profile);
}
