package com.yigou.address.mapper;

import com.yigou.common.bean.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

    List<Address> getAddressByUsername(String username);

    Address getDefaultAddressByUsername(String username);

    Address getAddressById(Integer id);
}
