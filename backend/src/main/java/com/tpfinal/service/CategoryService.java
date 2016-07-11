package com.tpfinal.service;

import com.tpfinal.domain.Category;
import com.tpfinal.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    public Category findByIdCategory(Long idCategory){
        return categoryRepository.findByIdCategory(idCategory);
    }
}
