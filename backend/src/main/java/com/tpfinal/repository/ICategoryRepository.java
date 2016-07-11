package com.tpfinal.repository;

import com.tpfinal.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long>{

    public Category findByIdCategory(Long idCategory);
}
