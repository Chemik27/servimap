package com.tpfinal.service;

import com.tpfinal.domain.Address;
import com.tpfinal.domain.District;
import com.tpfinal.domain.User;
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

    @Autowired
    UserService userService;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address createAddressFromDTO(String street, Long number, Long idDistrict, Long idUser, Long typeAddress){
        if(typeAddress.equals(Address.NO_WORK_ADDRESS)) {
            return null;
        }
        if(typeAddress.equals(Address.SAME_RECIDENTIAL_ADDRESS)){
            User user = userService.findByIdUser(idUser);
            return addressRepository.findOne(user.getIdAddress().getIdAddress());
        }else{
            Address address = new Address();
            address.setStreet(street);
            address.setNumber(number);

            District district = districtRepository.findByIdDistrict(idDistrict);
            address.setDistrict(district);
            return addressRepository.save(address);
        }

    }
}
