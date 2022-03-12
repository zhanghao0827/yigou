package com.yigou.address.service;

import com.yigou.common.bean.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAddressByUsername(String username);

    Address getDefaultAddressByUsername(String username);

    Address getAddressById(Integer id);
}
