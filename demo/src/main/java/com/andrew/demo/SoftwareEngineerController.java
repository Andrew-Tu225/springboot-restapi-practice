package com.andrew.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    @Autowired
    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @PostMapping
    public void addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("/get/{id}")
    public SoftwareEngineer getSoftwareEngineerById(@PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @GetMapping("/get-all")
    public List<SoftwareEngineer> getEngineers()
    {
        return softwareEngineerService.getSoftwareEngineer();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer updatedSoftwareEngineer){
        try{
            softwareEngineerService.updateSoftwareEngineer(id, updatedSoftwareEngineer);
            return ResponseEntity.ok("software engineer is updated sucessfully");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSoftwareEngineer(@PathVariable Integer id){
        try{
            softwareEngineerService.deleteSoftwareEngineer(id);
            return ResponseEntity.ok("software Engineer is deleted sucessfully");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
