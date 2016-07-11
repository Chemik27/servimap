package com.tpfinal.service;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.District;
import com.tpfinal.repository.IAddressRepository;
import com.tpfinal.repository.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressRepository addressRepository;

    @Autowired
    IDistrictRepository districtRepository;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address createAddressFromDTO(String street, Long number, Long idDistrict){
        Address address = new Address();
        address.setStreet(street);
        address.setNumber(number);

        District district = districtRepository.findByIdDistrict(idDistrict);
        address.setDistrict(district);
        return addressRepository.save(address);
    }
}
