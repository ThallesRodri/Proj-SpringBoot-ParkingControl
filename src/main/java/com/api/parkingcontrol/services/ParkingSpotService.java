package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service //Estereótipo  para camada de serviços do Spring
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) { //Injetando dependência  da classe abaixo ao service
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional //garante um rollback caso algo dê errado
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel); //Usando JPA para salvar
    }
}
