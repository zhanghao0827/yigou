package com.yigou.address.controller;

import com.yigou.address.service.AddressService;
import com.yigou.common.bean.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addr")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/list/{username}")
    public List<Address> getAddressByUsername(@PathVariable String username) {
        return addressService.getAddressByUsername(username);
    }

    @GetMapping("/def/{username}")
    public Address getDefaultAddressByUsername(@PathVariable String username) {
        return addressService.getDefaultAddressByUsername(username);
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Integer id) {
        return addressService.getAddressById(id);
    }

}
