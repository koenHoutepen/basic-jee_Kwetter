package Services;

import controller.domain.Kweet;
import controller.domain.Profile;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;

@Singleton
@Startup
public class StartUp {
    @Inject
    private ProfileService service;

    public StartUp()
    {

    }

    @PostConstruct
    public void createData()
    {
        ArrayList<Kweet> kweets = new ArrayList<Kweet>();
        kweets.add(new Kweet(new Long(1), "bobby","eerste kweet", new Date()));
        kweets.add(new Kweet(new Long(2), "bobby","tweede kweet", new Date()));
        kweets.add(new Kweet(new Long(3), "bobby","derde kweet", new Date()));
        this.service.addProfile(new Profile("Bobby", "Ik ben een test Gebruiker","Tilburg","www.waarombenikzo.com", kweets, new ArrayList<>(), new ArrayList<>(),"niethier.jpg"));
    }
}
