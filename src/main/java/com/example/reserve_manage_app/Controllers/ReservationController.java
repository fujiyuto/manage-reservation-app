package com.example.reserve_manage_app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.reserve_manage_app.Services.ReservationService;



/**
 * 予約コントローラ
 */
@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservation/{userId}")
    public String getUserReservationData(@PathVariable Long userId) {
        return new String();
    }
    
    @GetMapping("/revservation/{restaurantId}")
    public String getRestaurantReservationData(@PathVariable Long restaurantId) {
        return new String();
    }
    
}
