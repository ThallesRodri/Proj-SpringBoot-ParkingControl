package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //API Rest
@CrossOrigin(origins = "*", maxAge = 3600) //Permitir acesso de qualquer fonte
@RequestMapping("/parking-spot") //URI a nível de classe
public class ParkingSpotController {

    //Ponto de injeção do Service
    final ParkingSpotService parkingSpotService; //Instância do service

    public ParkingSpotController(ParkingSpotService parkingSpotService) { //Construtor do controller utilizando o service
        this.parkingSpotService = parkingSpotService;
    }
}
