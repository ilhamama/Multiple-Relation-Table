package com.amajidi.personal.multiplerelationtable.Repository;

import com.amajidi.personal.multiplerelationtable.Entity.Changes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangesRepository extends JpaRepository<Changes, String> {
    
}
