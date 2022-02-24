package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository //Estereótipo do spring para transações com base de dados
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {
}
