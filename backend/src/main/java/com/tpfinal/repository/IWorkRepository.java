package com.tpfinal.repository;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.Category;
import com.tpfinal.domain.Work;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWorkRepository extends JpaRepository<Work, Long> {

    public Page<Work> findByNameContaining(String name, Pageable pageable);

    public List<Work> findByIdUser(Long idUser);

    public List<Work> findByCategoryIdCategory(Long idCategory);

    public List<Work> findByAddressDistrictIdDistrict(Long idDistrict);

//    public List<Work> findByDescriptionContaining(String word);
}
