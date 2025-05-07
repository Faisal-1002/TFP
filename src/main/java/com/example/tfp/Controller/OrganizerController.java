package com.example.tfp.Controller;

import com.example.tfp.Api.ApiResponse;
import com.example.tfp.DTO.OrganizerDTO;
import com.example.tfp.Model.Organizer;
import com.example.tfp.Model.User;
import com.example.tfp.Service.OrganizerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organizer")
@RequiredArgsConstructor
public class OrganizerController {

    private final OrganizerService organizerService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrganizers() {
        return ResponseEntity.status(200).body(organizerService.getAllOrganizers());
    }

    @GetMapping("/info")
    public ResponseEntity<?> getMyOrganizerInfo(@AuthenticationPrincipal User user) {
        Organizer organizer = organizerService.getOrganizer(user.getId());
        return ResponseEntity.status(200).body(organizer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrganizerById(@PathVariable Integer id) {
        Organizer organizer = organizerService.getOrganizerById(id);
        return ResponseEntity.status(200).body(organizer);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerOrganizer(@RequestBody @Valid OrganizerDTO dto) {
        organizerService.registerOrganizer(dto);
        return ResponseEntity.status(200).body(new ApiResponse("Organizer registered successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrganizer(@AuthenticationPrincipal User user, @RequestBody @Valid OrganizerDTO dto) {
        organizerService.updateOrganizer(user.getId(), dto);
        return ResponseEntity.status(200).body(new ApiResponse("Organizer updated successfully"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOrganizer(@AuthenticationPrincipal User user) {
        organizerService.deleteOrganizer(user.getId());
        return ResponseEntity.status(200).body(new ApiResponse("Organizer deleted successfully"));
    }
}
