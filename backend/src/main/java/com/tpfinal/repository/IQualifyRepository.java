package com.tpfinal.repository;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tino on 08/06/2016.
 */
public interface IQualifyRepository extends JpaRepository<Rating, Long> {

    public List<Rating> findAll();

}
