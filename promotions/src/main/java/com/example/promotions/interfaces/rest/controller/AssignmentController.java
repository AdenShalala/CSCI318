package com.example.promotions.interfaces.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.promotions.interfaces.rest.dto.AssignmentRequest;
import com.example.promotions.interfaces.rest.dto.Suggestion;

import java.util.List;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = { "http://127.0.0.1:5500", "http://localhost:5500" })
public class AssignmentController {

  @PostMapping("/assign")
  public ResponseEntity<String> assignResource(@RequestBody AssignmentRequest request) {
    System.out.println("Assigning " + request.employee() + " to " + request.equipment());
    return ResponseEntity.ok("Assigned " + request.employee() + " to " + request.equipment());
  }

  @GetMapping("/suggestions")
  public List<Suggestion> getSuggestions() {
    return List.of(
        new Suggestion(1, "Shift Optimization",
            "Assign Sarah to Cashier role this week as she has the highest customer satisfaction ratings."),
        new Suggestion(2, "Equipment Maintenance",
            "Schedule maintenance for Forklift #3 next Tuesday during off-peak hours."),
        new Suggestion(3, "Team Assignment",
            "Pair Michael with Emma for inventory audit - their skills complement each other."),
        new Suggestion(4, "Coverage Alert",
            "Saturday afternoon shift is understaffed. Consider calling in part-time help."));
  }

  @PostMapping("/suggestions/{id}/apply")
  public ResponseEntity<String> applySuggestion(@PathVariable int id) {
    System.out.println("Applying suggestion with ID: " + id);
    return ResponseEntity.ok("Suggestion " + id + " applied successfully!");
  }
}
