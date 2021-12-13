package com.amajidi.personal.multiplerelationtable.Repository;

import com.amajidi.personal.multiplerelationtable.Entity.Shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
    
}
