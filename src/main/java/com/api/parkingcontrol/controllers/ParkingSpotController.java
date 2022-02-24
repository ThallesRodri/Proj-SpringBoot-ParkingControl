package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController //API Rest
@CrossOrigin(origins = "*", maxAge = 3600) //Permitir acesso de qualquer fonte
@RequestMapping("/parking-spot") //URI a nível de classe
public class ParkingSpotController {

    //Ponto de injeção do Service
    final ParkingSpotService parkingSpotService; //Instância do service

    public ParkingSpotController(ParkingSpotService parkingSpotService) { //Construtor do controller utilizando o service
        this.parkingSpotService = parkingSpotService;
    }

    //Metodo Post
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        var parkingSpotModel = new ParkingSpotModel();

        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); //conversão de DTO para Model, para os dados serem salvos no BD
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        //salva a requisição e retorna os dados salvos
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }
}
