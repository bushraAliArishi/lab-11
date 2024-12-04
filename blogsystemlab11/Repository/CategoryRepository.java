package com.example.blogsystemlab11.Repository;

import com.example.blogsystemlab11.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findCategoryById(Integer id);

    Category findCategoryByName(String name);


}
