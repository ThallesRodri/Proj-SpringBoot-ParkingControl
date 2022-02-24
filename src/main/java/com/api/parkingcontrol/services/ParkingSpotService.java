package com.api.parkingcontrol.services;

import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

@Service //Estereótipo  para camada de serviços do Spring
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) { //Injetando dependência  da classe abaixo ao service
        this.parkingSpotRepository = parkingSpotRepository;
    }
}
