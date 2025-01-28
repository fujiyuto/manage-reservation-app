package com.example.reserve_manage_app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reserve_manage_app.dto.requests.CreateReservationRequest;
import com.example.reserve_manage_app.dto.requests.UpdateReservationRequest;
import com.example.reserve_manage_app.dto.requests.UpdateReservationStatusRequest;
import com.example.reserve_manage_app.dto.responses.ApiResponse;
import com.example.reserve_manage_app.dto.responses.GetRestaurantReservationResponse;
import com.example.reserve_manage_app.dto.responses.GetUserReservationResponse;
import com.example.reserve_manage_app.dto.responses.UpdateReservationResponse;
import com.example.reserve_manage_app.services.ReservationService;

import jakarta.validation.Valid;


/**
 * 予約コントローラ
 */
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("{userId}")
    public ResponseEntity<?> getUserReservationData(@PathVariable Long userId) {
        try {
            // 予約データ取得
            GetUserReservationResponse response = reservationService.getUserReservationData(userId);

            // レスポンス返却
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // エラー処理
            ApiResponse response = new ApiResponse("エラーです");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("{restaurantId}")
    public ResponseEntity<?> getRestaurantReservationData(@PathVariable Long restaurantId) {
        try {
            // 予約データ取得
            GetRestaurantReservationResponse response = reservationService.getRestaurantReservationData(restaurantId);

            // レスポンス返却
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // エラー処理
            ApiResponse response = new ApiResponse("エラーです");
            return ResponseEntity.badRequest().body(response);
        }
        
    }
    
    @PostMapping("")
    public ResponseEntity<?> createReservationData(@Valid @RequestBody CreateReservationRequest request) {
        try {
            // 登録処理
            ApiResponse response = reservationService.insertReservation(request);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // エラー処理
            ApiResponse response = new ApiResponse("エラーです");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @PatchMapping("{reservationId}")
    public ResponseEntity<?> updateReservationData(@PathVariable Long reservationId,@Valid @RequestBody UpdateReservationRequest request) {
        try {
            // 予約データ更新処理
            UpdateReservationResponse response = reservationService.updateReservation(reservationId, request);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // エラー処理
            ApiResponse response = new ApiResponse("エラーです");
            e.printStackTrace();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PatchMapping("{reservationId}/status")
    public ResponseEntity<?> updateReservationStatus(@PathVariable Long reservationId, @Valid @RequestBody UpdateReservationStatusRequest request) {
        try {
            // 予約状況更新処理
            UpdateReservationResponse response = reservationService.updateReservationStatus(reservationId, request);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // エラー処理
            ApiResponse response = new ApiResponse("エラーです");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
