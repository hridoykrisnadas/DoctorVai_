package com.paragonitfeni.main.RestController;

import com.paragonitfeni.main.Model.Degree;
import com.paragonitfeni.main.Model.Doctor;
import com.paragonitfeni.main.Model.MedicalCollege;
import com.paragonitfeni.main.Repository.DegreeRepo;
import com.paragonitfeni.main.Repository.MedicalCollegeRepo;
import com.paragonitfeni.main.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/doctor/")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Autowired
    MedicalCollegeRepo medicalCollegeRepo;
    @Autowired
    DegreeRepo degreeRepo;

    @PostMapping("save")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        long medicalCollegeId = doctor.getMedicalCollege().getId();
        List<Degree> degreeList = new ArrayList<>();
        for (Degree degree : doctor.getDegree()) {
            Degree degree1 = degreeRepo.findById(degree.getId()).get();
            degreeList.add(new Degree(degree1.getId(), degree1.getName()));
        }

        MedicalCollege medicalCollege = medicalCollegeRepo.findById(medicalCollegeId).get();
        doctor.setMedicalCollege(medicalCollege);
        doctor.setDegree(degreeList);
        doctor.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        long medicalCollegeId = doctor.getMedicalCollege().getId();
        List<Degree> degreeList = new ArrayList<>();
        for (Degree degree : doctor.getDegree()) {
            Degree degree1 = degreeRepo.findById(degree.getId()).get();
            degreeList.add(new Degree(degree1.getId(), degree1.getName()));
        }

        MedicalCollege medicalCollege = medicalCollegeRepo.findById(medicalCollegeId).get();
        doctor.setMedicalCollege(medicalCollege);
        doctor.setDegree(degreeList);
        doctor.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.ACCEPTED);
    }

    @GetMapping("doctor-details/{id}")
    public ResponseEntity<Doctor> getSingleDegree(@PathVariable int id) {
        return new ResponseEntity<>(doctorService.DoctorDetails(id), HttpStatus.OK);
    }

    @GetMapping("all-doctor")
    public ResponseEntity<List<Doctor>> getAllDegree() {
        return new ResponseEntity<>(doctorService.getAllDoctor(), HttpStatus.OK);
    }
}
