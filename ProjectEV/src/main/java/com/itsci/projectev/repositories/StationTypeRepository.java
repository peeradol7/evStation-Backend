package com.itsci.projectev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsci.projectev.models.StationType;

public interface StationTypeRepository extends JpaRepository<StationType, Integer> {

}
