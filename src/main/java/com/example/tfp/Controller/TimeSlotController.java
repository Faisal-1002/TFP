package com.example.tfp.Controller;

import com.example.tfp.Api.ApiResponse;
import com.example.tfp.Model.TimeSlot;
import com.example.tfp.Service.TimeSlotService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/slot")
@RequiredArgsConstructor
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllSlots() {
        List<TimeSlot> slots = timeSlotService.getAllTimeSlots();
        return ResponseEntity.status(200).body(slots);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSlotById(@PathVariable Integer id) {
        TimeSlot slot = timeSlotService.getTimeSlotById(id);
        return ResponseEntity.status(200).body(slot);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSlot(@RequestBody @Valid TimeSlot timeSlot) {
        timeSlotService.addTimeSlot(timeSlot);
        return ResponseEntity.status(200).body(new ApiResponse("TimeSlot added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSlot(@PathVariable Integer id, @RequestBody @Valid TimeSlot updatedSlot) {
        timeSlotService.updateTimeSlot(id, updatedSlot);
        return ResponseEntity.status(200).body(new ApiResponse("TimeSlot updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSlot(@PathVariable Integer id) {
        timeSlotService.deleteTimeSlot(id);
        return ResponseEntity.status(200).body(new ApiResponse("TimeSlot deleted successfully"));
    }
}
