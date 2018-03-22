package Services;

import controller.domain.Kweet;
import controller.domain.Profile;
import dao.KweetDao;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Startup
public class StartUp {
    @Inject
    private ProfileService profileService;
    private KweetService kweetService;
    private KweetDao kweetDao;

    public StartUp()
    {

    }

    @PostConstruct
    public void createData(){
        try {
            Profile danny = new Profile("Danny");
            danny.setBio("Mijn bio is naderhand ingesteld!");
            danny.setLocation("Tilburg");
            danny.setWeb("www.handmatig.nl");
            Profile bobby = new Profile("Bobby", "Ik ben een test Gebruiker", "Tilburg", "www.waarombenikzo.com", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "niethier.jpg");
            Profile follower1 = new Profile("follower1");
            Profile follower2 = new Profile("follower2");
            this.profileService.addProfile(danny);
            this.profileService.addProfile(bobby);
            this.profileService.addProfile(follower1);
            this.profileService.addProfile(follower2);
            this.profileService.addFollow(danny,follower1);
            this.profileService.addFollow(follower1,follower2);
            this.profileService.addFollow(follower2,danny);
            this.profileService.addFollow(danny,follower2);
            Kweet kweet1 = new Kweet(bobby, "eerste kweet");
            Kweet kweet2 = new Kweet(bobby, "tweede kweet");
            Kweet kweet3 = new Kweet(bobby, "derde kweet");
            Kweet kweet4 = new Kweet(danny,"vierde kweet");
            Kweet kweet5 = new Kweet(danny, "vijfde kweet");
            Kweet kweet6 = new Kweet(danny,"zesde kweet");
            this.profileService.addKweet(kweet1, bobby);
            this.profileService.addKweet(kweet2, bobby);
            this.profileService.addKweet(kweet3, bobby);
            this.profileService.addKweet(kweet4,danny);
            this.profileService.addKweet(kweet5,danny);
            this.profileService.addKweet(kweet6,danny);
        }
        catch (Exception e)
        {
            System.out.println("create profile ging mis");
            System.out.println(e.getMessage());
        }
    }
}
