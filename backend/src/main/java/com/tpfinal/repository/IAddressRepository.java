package com.tpfinal.repository;

import com.tpfinal.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tino on 08/06/2016.
 */
public interface IAddressRepository extends JpaRepository<Address, Long> {

    public List<Address> findAll();
}
