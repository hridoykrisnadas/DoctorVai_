package com.paragonitfeni.main.RestController;

import com.paragonitfeni.main.Model.Doctor;
import com.paragonitfeni.main.Model.MedicalCollege;
import com.paragonitfeni.main.Service.MedicalCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/medical-college/")
public class MedicalCollegeController {
    @Autowired
    MedicalCollegeService medicalCollegeService;

    public MedicalCollegeController(MedicalCollegeService medicalCollegeService) {
        this.medicalCollegeService = medicalCollegeService;
    }

    @PostMapping("save")
    public ResponseEntity<MedicalCollege> save(@RequestBody MedicalCollege medicalCollege){

        return new ResponseEntity<>(medicalCollegeService.saveMedicalCollege(medicalCollege), HttpStatus.CREATED);
    }

    @GetMapping("doctor-details/{id}")
    public ResponseEntity<MedicalCollege> getSingleDegree(@PathVariable int id){
        return new ResponseEntity<>(medicalCollegeService.getCollegeById(id), HttpStatus.OK);
    }

    @GetMapping("all-doctor")
    public ResponseEntity<List<MedicalCollege>> getAllDegree(){
        return new ResponseEntity<>(medicalCollegeService.getMedicalCollege(), HttpStatus.OK);
    }
}
