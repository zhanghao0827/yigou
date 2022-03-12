package com.yigou.address.service.impl;

import com.yigou.address.mapper.AddressMapper;
import com.yigou.address.service.AddressService;
import com.yigou.common.bean.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<Address> getAddressByUsername(String username) {
        return addressMapper.getAddressByUsername(username);
    }

    @Override
    public Address getDefaultAddressByUsername(String username) {
        return addressMapper.getDefaultAddressByUsername(username);
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressMapper.getAddressById(id);
    }
}
