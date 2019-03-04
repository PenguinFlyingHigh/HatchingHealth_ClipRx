package com.hatch.med_adhere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hatch.med_adhere.model.BlisterPop;

@Repository
public interface BlisterpackRepository extends JpaRepository<BlisterPop, String>
{
    BlisterPop findByBlisterpackId(Integer id);
}
