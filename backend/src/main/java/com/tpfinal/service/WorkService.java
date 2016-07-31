package com.tpfinal.service;

import com.tpfinal.domain.*;
import com.tpfinal.dto.WorkDTO;
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

    @Autowired
    CategoryService categoryService;

    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;

    private static final int ITEMS_PER_PAGE = 10;

//    public Page<Work> findAll(PageRequest pageRequest) {
//        return workRepository.findAll(pageRequest);
//    }

    public Page<Work> findByNameContaining(String name){
        return workRepository.findByNameContaining(name, new PageRequest(0,ITEMS_PER_PAGE));
    }

    public List<Work> findByIdUser(Long idUser){
        return workRepository.findByUser(userService.findByIdUser(idUser));
    }

    public Work findByIdWork(Long idUser){
        return workRepository.findByIdWork(idUser);
    }

    public Page<Work> findByCategory(Long idCategory){
        return workRepository.findByCategoryIdCategory(idCategory, new PageRequest(0,ITEMS_PER_PAGE));
    }

    public Page<Work> findByDistrict(Long idDistrict){
        return workRepository.findByAddressDistrictIdDistrict(idDistrict, new PageRequest(0,ITEMS_PER_PAGE));
    }

    public Work createFromDTO(WorkDTO workDTO) {
        Work work = new Work();
        User user = userService.findByIdUser(workDTO.getIdUser());
        work.setUser(user);
        work.setDescription(workDTO.getDescription());
        work.setName(workDTO.getName());
        work.setPrice(workDTO.getPrice());

        Category category = categoryService.findByIdCategory(workDTO.getIdCategory());
        work.setCategory(category);

        Address address = addressService.createAddressFromDTO(workDTO.getStreet(), workDTO.getNumber(), workDTO.getIdDistrict(), workDTO.getIdUser(), workDTO.getTypeAddress());
        work.setAddress(address);

        return workRepository.save(work);
    }

//    public List<Work> findByDescriptionContaining(String word){ return workRepository.findByDescriptionContaining(word); }
}
