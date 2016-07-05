package com.tpfinal.service;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.Category;
import com.tpfinal.domain.District;
import com.tpfinal.domain.Work;
import com.tpfinal.repository.IWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

    @Autowired
    IWorkRepository workRepository;

    private static final int ITEMS_PER_PAGE = 10;

//    public Page<Work> findAll(PageRequest pageRequest) {
//        return workRepository.findAll(pageRequest);
//    }

    public Page<Work> findByNameContaining(String name){
        return workRepository.findByNameContaining(name, new PageRequest(0,ITEMS_PER_PAGE));
    }

    public List<Work> findByIdUser(Long idUser){
        return workRepository.findByIdUser(idUser);
    }

    public Page<Work> findByCategory(Long idCategory){
        return workRepository.findByCategoryIdCategory(idCategory, new PageRequest(0,ITEMS_PER_PAGE));
    }

    public Page<Work> findByDistrict(Long idDistrict){
        return workRepository.findByAddressDistrictIdDistrict(idDistrict, new PageRequest(0,ITEMS_PER_PAGE));
    }

//    public List<Work> findByDescriptionContaining(String word){ return workRepository.findByDescriptionContaining(word); }
}
