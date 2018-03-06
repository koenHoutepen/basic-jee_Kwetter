package controller.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KwetterManager {
    private List<Profile> profiles = new ArrayList<>();
    private List<Mention> mentions = new ArrayList<>();
    private List<Trend> trends = new ArrayList<>();
    private List<Kweet> kweets = new ArrayList<>();

    public KwetterManager(List<Profile> profiles, List<Mention> mentions, List<Trend> trends,List<Kweet> kweets) {
        this.profiles = profiles;
        this.mentions = mentions;
        this.trends = trends;
        this.kweets = kweets;
    }

    KwetterManager() {

    }

//    public Kweet CreeerKweet(Profile posterProfile, String message) {
//        String userName = posterProfile.getUsername();
//        Date createDate = new Date();
//        List<String> fillList = new ArrayList<>();
//        return new Kweet(userName, message, createDate, fillList, fillList, fillList);
//    }

    public void AddKweet(Kweet kweet)
    {
        kweets.add(kweet);
    }

    public boolean CheckAdminAccess(Profile profile)
    {
        return true; // implement
    }

    public boolean CheckOwnerAccess(Profile profile)
    {
        return true; // implement
    }

    public void RemoveKweet(Profile profile,Kweet kweet)
    {
        //implement
    }

    public Boolean UsernameTaken(String newUsername)
    {
        for (Profile checkProfile:profiles )
        {
            if(newUsername.equals(checkProfile.getUsername()))
            {
                return true;
            }
        }
        return false;
    }

    public List<Kweet> ReturnOwnedKweets(Profile profile)
    {
        List<Kweet> mykweets = new ArrayList<>();
        String checkedName = profile.getUsername();
        for (Profile checkProfile:profiles )
        {
            if(checkedName.equals(checkProfile.getUsername()))
            {
                mykweets = checkProfile.getKweets();
            }
        }
        return mykweets;
    }
    
    public Boolean haveLiked(Kweet kweet,Profile profile)
    {
        return true;
    }
}
