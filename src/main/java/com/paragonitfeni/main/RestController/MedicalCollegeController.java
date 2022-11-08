package com.paragonitfeni.main.RestController;

import com.paragonitfeni.main.Model.MedicalCollege;
import com.paragonitfeni.main.Service.MedicalCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(medicalCollege.toString());
        return new ResponseEntity<>(medicalCollegeService.saveMedicalCollege(medicalCollege), HttpStatus.CREATED);
    }
}
