package com.yigou.portal.service;

import com.yigou.common.bean.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("yigou-address")
public interface AddressService {

    @GetMapping("/addr/list/{username}")
    List<Address> getAddressByUsername(@PathVariable String username);

    @GetMapping("/addr/def/{username}")
    Address getDefaultAddressByUsername(@PathVariable String username);

    @GetMapping("/addr/{id}")
    Address getAddressById(@PathVariable Integer id);

}
