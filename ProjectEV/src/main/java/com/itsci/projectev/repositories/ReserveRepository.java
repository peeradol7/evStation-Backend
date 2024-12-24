package com.itsci.projectev.repositories;

import com.itsci.projectev.models.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserve, String> {
}
