package com.amajidi.personal.multiplerelationtable.Repository;

import com.amajidi.personal.multiplerelationtable.Entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{
    
}
