package com.tpfinal.repository;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.Category;
import com.tpfinal.domain.User;
import com.tpfinal.domain.Work;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWorkRepository extends JpaRepository<Work, Long> {

    public Page<Work> findByNameContainingOrderByUserPremiumDesc(String name, Pageable pageable);

    public List<Work> findByUser(User user);

    public Page<Work> findByCategoryIdCategoryOrderByUserPremiumDesc(Long idCategory, Pageable pageable);

    public Page<Work> findByAddressDistrictIdDistrictOrderByUserPremiumDesc(Long idDistrict, Pageable pageable);

    public Work findByUserIdUser(Long idUser);

//    public List<Work> findByDescriptionContaining(String word);
}
