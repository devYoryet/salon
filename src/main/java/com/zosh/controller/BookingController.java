package com.zosh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {

    // Endpoint para chart de bookings
    @GetMapping("/chart/bookings")
    public ResponseEntity<Map<String, Object>> getBookingsChart() {
        Map<String, Object> response = new HashMap<>();
        
        // Datos de ejemplo para el gráfico de bookings
        List<Map<String, Object>> bookingsData = new ArrayList<>();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
        int[] bookingCounts = {10, 15, 8, 20, 25, 18};
        
        for (int i = 0; i < months.length; i++) {
            Map<String, Object> monthData = new HashMap<>();
            monthData.put("month", months[i]);
            monthData.put("bookings", bookingCounts[i]);
            bookingsData.add(monthData);
        }
        
        response.put("data", bookingsData);
        response.put("total", Arrays.stream(bookingCounts).sum());
        
        return ResponseEntity.ok(response);
    }

    // Endpoint para chart de earnings
    @GetMapping("/chart/earnings")
    public ResponseEntity<Map<String, Object>> getEarningsChart() {
        Map<String, Object> response = new HashMap<>();
        
        // Datos de ejemplo para el gráfico de earnings
        List<Map<String, Object>> earningsData = new ArrayList<>();
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
        double[] earningAmounts = {1500.0, 2200.0, 1800.0, 2800.0, 3200.0, 2900.0};
        
        for (int i = 0; i < months.length; i++) {
            Map<String, Object> monthData = new HashMap<>();
            monthData.put("month", months[i]);
            monthData.put("earnings", earningAmounts[i]);
            earningsData.add(monthData);
        }
        
        response.put("data", earningsData);
        response.put("total", Arrays.stream(earningAmounts).sum());
        
        return ResponseEntity.ok(response);
    }

    // Endpoint básico para obtener todas las reservas
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllBookings() {
        List<Map<String, Object>> bookings = new ArrayList<>();
        
        // Datos de ejemplo
        Map<String, Object> booking1 = new HashMap<>();
        booking1.put("id", 1);
        booking1.put("customerName", "Juan Pérez");
        booking1.put("service", "Corte de cabello");
        booking1.put("date", "2025-07-03");
        booking1.put("time", "10:00");
        booking1.put("status", "confirmed");
        bookings.add(booking1);
        
        Map<String, Object> booking2 = new HashMap<>();
        booking2.put("id", 2);
        booking2.put("customerName", "María García");
        booking2.put("service", "Manicure");
        booking2.put("date", "2025-07-03");
        booking2.put("time", "14:00");
        booking2.put("status", "pending");
        bookings.add(booking2);
        
        return ResponseEntity.ok(bookings);
    }
}
