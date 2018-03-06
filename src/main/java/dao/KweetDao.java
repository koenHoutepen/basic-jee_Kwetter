package dao;

import controller.domain.Kweet;

import java.util.List;

public interface KweetDao {

    Kweet create(Kweet k);
    
    Kweet edit(Long id, String author, String title);
    
    void delete(Long id);

    List<Kweet> findAll();

    Kweet find(Long id);
}
