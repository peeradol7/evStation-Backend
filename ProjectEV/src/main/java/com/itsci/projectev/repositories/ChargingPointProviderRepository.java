package com.itsci.projectev.repositories;

import com.itsci.projectev.models.ChargingPointProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingPointProviderRepository extends JpaRepository<ChargingPointProvider, String> {

    ChargingPointProvider findByProviderUsernameEquals (String providerUsername);
    ChargingPointProvider getChargingPointProviderByProviderUsername (String providerUsername);
}
