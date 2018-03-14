package Services;

import controller.domain.Kweet;
import controller.domain.Profile;
import dao.KweetDao;
import dao.UserDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Stateless
public class KweetService {
    @Inject
    private KweetDao kweetDao;

    public Kweet getKweet(Long id)throws Exception
    {
        return this.kweetDao.getKweet(id);
    }

    public Map<Long,Kweet> getKweetMap()
    {
        return this.kweetDao.getAllKweets();
    }

    public void deleteKweet(Long id)
    {
        this.kweetDao.deleteKweet(id);
    }
}
