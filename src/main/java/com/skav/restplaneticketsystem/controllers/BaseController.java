package com.skav.restplaneticketsystem.controllers;

import com.skav.restplaneticketsystem.models.AirlineEntity;
import com.skav.restplaneticketsystem.models.FlightEntity;
import com.skav.restplaneticketsystem.models.TicketEntity;
import com.skav.restplaneticketsystem.repositories.AirlineRepository;
import com.skav.restplaneticketsystem.repositories.FlightRepository;
import com.skav.restplaneticketsystem.services.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BaseController {

    private final AirlineRepository airlineRepo;
    private final FlightRepository flightRepo;
    private final BookingServiceInterface bookingService;


}