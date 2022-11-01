package com.countryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.countryservice.demo.beans.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}