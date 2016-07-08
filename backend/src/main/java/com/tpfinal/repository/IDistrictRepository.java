package com.tpfinal.repository;

import com.tpfinal.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDistrictRepository extends JpaRepository<District, Long> {

    public District findByIdDistrict(Long idDistrict);
}
