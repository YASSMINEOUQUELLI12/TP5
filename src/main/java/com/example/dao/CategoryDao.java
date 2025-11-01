package com.example.dao;

// com/example/dao/CategoryDao.java


import com.example.entities.Category;

public interface CategoryDao extends IDao<Category> {
    Category findByLabel(String label);
    Category getOrCreate(String label);
}

