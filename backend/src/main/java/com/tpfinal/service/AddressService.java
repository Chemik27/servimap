package com.tpfinal.service;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.District;
import com.tpfinal.domain.User;
import com.tpfinal.dto.UserDTO;
import com.tpfinal.repository.IAddressRepository;
import com.tpfinal.repository.IDistrictRepository;
import com.tpfinal.repository.IWorkRepository;
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

    public Address createAddressFromDTO(UserDTO userDTO){
        Address address = new Address();
        address.setStreet(userDTO.getStreet());
        address.setNumber(userDTO.getNumber());

        District district = districtRepository.findByIdDistrict(userDTO.getIdDistrict());
        address.setDistrict(district);
        return addressRepository.save(address);
    }
}
