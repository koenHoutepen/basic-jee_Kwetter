package Services;

import controller.domain.Kweet;
import dao.JPA;
import dao.KweetDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Stateless
public class KweetService {
    @Inject
    @JPA
    private KweetDao kweetDao;

    public Kweet getKweet(Long id)throws Exception
    {
        return this.kweetDao.getKweet(id);
    }

    public List<Kweet> getKweetMap()
    {
        return this.kweetDao.getAllKweets();
    }

    public List<Kweet> getKweetList(){return this.kweetDao.getKweetList();}

    public void deleteKweet(Long id) throws Exception {
        this.kweetDao.deleteKweet(id);
    }
}
