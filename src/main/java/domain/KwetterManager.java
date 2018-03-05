package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KwetterManager {
    private List<Profile> profiles;
    private List<Mention> mentions;
    private List<Trend> trends;
    private List<Kweet> kweets;

    public KwetterManager(List<Profile> profiles, List<Mention> mentions, List<Trend> trends,List<Kweet> kweets) {
        this.profiles = profiles;
        this.mentions = mentions;
        this.trends = trends;
        this.kweets = kweets;
    }

    public Kweet CreeerKweet(Profile posterProfile, String message) {
        String userName = posterProfile.getUsername();
        Date createDate = new Date();
        List<String> fillList = new ArrayList<>();
        return new Kweet(userName, message, createDate, fillList, fillList, fillList);
    }

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

    public List<Kweet> ReturnOwnedKweets(Profile profile)
    {
        List<Kweet> mykweets = new ArrayList<>();
        String checkedName = profile.getUsername();
        for (Kweet kweet:kweets )
        {
            if(checkedName.equals(kweet.getOwner()))
            {
                mykweets.add(kweet);
            }
        }
        return mykweets;
    }
    
    public Boolean haveLiked(Kweet kweet,Profile profile)
    {
        return true;
    }
}
