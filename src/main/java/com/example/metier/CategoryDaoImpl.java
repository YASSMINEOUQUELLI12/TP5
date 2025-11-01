// com/example/metier/CategoryDaoImpl.java
package com.example.metier;

import com.example.dao.CategoryDao;
import com.example.entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("categoryDaoImpl")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session s() { return sessionFactory.getCurrentSession(); }

    @Override public boolean create(Category c) { s().save(c); return true; }
    @Override public boolean delete(Category c) { s().delete(c); return true; }
    @Override public boolean update(Category c) { s().update(c); return true; }
    @Override public Category findById(int id) { return s().get(Category.class, id); }
    @Override public List<Category> findAll() {
        return s().createQuery("from Category", Category.class).list();
    }

    @Override
    public Category findByLabel(String label) {
        return s().createQuery("from Category c where c.label = :label", Category.class)
                .setParameter("label", label)
                .uniqueResult();
    }

    @Override
    public Category getOrCreate(String label) {
        Category c = findByLabel(label);
        if (c == null) {
            c = new Category(label);
            s().save(c);
        }
        return c;
    }
}
