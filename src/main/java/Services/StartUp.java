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
            Profile bobby = new Profile("Bobby", "Ik ben een test Gebruiker", "Tilburg", "www.waarombenikzo.com", new HashMap<>(), new ArrayList<>(), new ArrayList<>(), "niethier.jpg");
            this.profileService.addProfile(bobby);
            Kweet kweet1 = new Kweet(new Long(0l), bobby, "eerste kweet", new Date());
            Kweet kweet2 = new Kweet(new Long(0l), bobby, "tweede kweet", new Date());
            Kweet kweet3 = new Kweet(new Long(0l), bobby, "derde kweet", new Date());
            this.profileService.addKweet(kweet1, bobby);
            this.profileService.addKweet(kweet2, bobby);
            this.profileService.addKweet(kweet3, bobby);
        }
        catch (Exception e)
        {
            System.out.println("create profile ging mis");
            System.out.println(e.getMessage());
        }
    }
}
