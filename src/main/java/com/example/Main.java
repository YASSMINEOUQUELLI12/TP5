package com.example;

import com.example.dao.CategoryDao;
import com.example.dao.IDao;
import com.example.entities.Category;
import com.example.entities.Product;
import com.example.util.HibernateConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(HibernateConfig.class)) {

            CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDaoImpl");
            @SuppressWarnings("unchecked")
            IDao<Product> productDao = (IDao<Product>) context.getBean("productDaoImpl");

            // Upsert catégories
            Category cat1 = categoryDao.getOrCreate("Informatique");
            Category cat2 = categoryDao.getOrCreate("Bureau");

            // Produits (évite aussi les doublons si tu relances souvent)
            Product p1 = new Product();
            p1.setName("Clavier mécanique");
            p1.setPrice(450.0);
            p1.setCategory(cat1);
            productDao.create(p1);

            Product p2 = new Product();
            p2.setName("Chaise ergonomique");
            p2.setPrice(1200.0);
            p2.setCategory(cat2);
            productDao.create(p2);

            System.out.println("=== All products ===");
            productDao.findAll().forEach(System.out::println);
        }
    }
}
