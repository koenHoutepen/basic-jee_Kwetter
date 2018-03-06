/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.domain.Kweet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class KweetDaoImp implements KweetDao {

    private static KweetDaoImp instance = null;
    private ConcurrentHashMap<Long, Kweet> kweets;
    private AtomicLong nextId = new AtomicLong(0L);

    public static synchronized KweetDao getPostingDao() {
        if (instance == null) {
            instance = new KweetDaoImp();
        }

        return instance;
    }

    private KweetDaoImp() {
        this.initWebBlog();
    }

    public void initWebBlog() {
        kweets = new ConcurrentHashMap<>();

        //create(new Kweet("Student 1", "Title 1", "Content 1"));
        //create(new Kweet("Student 1", "Title 2", "Content 2"));
        //create(new Kweet("Student 1", "Title 3", "Content 3"));
    }

    @Override
    public Kweet create(Kweet k) {
        if (k == null) {
            throw new IllegalArgumentException("Posting is null");
        }
        k.setKweetId(nextId.getAndIncrement());
        kweets.put(k.getKweetId(), k);
        return k;
    }

    @Override
    public Kweet edit(Long id, String author, String message) {
        if (author == null || message == null) {
            throw new IllegalArgumentException("Author, Title or Content is null");
        }
        if (!kweets.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }

        Kweet k = kweets.get(id);
        k.setOwner(author);
        k.setMessage(message);

        return k;
    }

    @Override
    public void delete(Long id) {
        if (!kweets.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }

        kweets.remove(id);
    }

    @Override
    public List<Kweet> findAll() {
        return new ArrayList(kweets.values());
    }

    @Override
    public Kweet find(Long id) {
        if (!kweets.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }
        return kweets.get(id);
    }
}
