package com.tpfinal.service;

import com.tpfinal.domain.Address;
import com.tpfinal.repository.IAddressRepository;
import com.tpfinal.repository.IWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tino on 08/06/2016.
 */
@Service
public class AddressService {

    @Autowired
    IAddressRepository addressRepository;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }
}
