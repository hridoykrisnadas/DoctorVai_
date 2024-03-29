package com.paragonitfeni.main.RestController;

import com.paragonitfeni.main.Model.Degree;
import com.paragonitfeni.main.Model.Doctor;
import com.paragonitfeni.main.Model.MedicalCollege;
import com.paragonitfeni.main.Repository.DegreeRepo;
import com.paragonitfeni.main.Repository.DoctorRepo;
import com.paragonitfeni.main.Repository.MedicalCollegeRepo;
import com.paragonitfeni.main.Service.DoctorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    DoctorRepo doctorRepo;
    @Autowired
    MedicalCollegeRepo medicalCollegeRepo;
    @Autowired
    DegreeRepo degreeRepo;

    @PostMapping("save")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        long medicalCollegeId = doctor.getMedicalCollege().getId();

        MedicalCollege medicalCollege = medicalCollegeRepo.findById(medicalCollegeId).get();
        doctor.setMedicalCollege(medicalCollege);
        doctor.setCreatedAt(new Timestamp(System.currentTimeMillis()).toString());
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
        Doctor doctor1 = doctorService.doctorDetails(id);

        long medicalCollegeId = doctor.getMedicalCollege().getId();
        List<Degree> degreeList = new ArrayList<>();
        for (Degree degree : doctor.getDegree()) {
            Degree degree1 = degreeRepo.findById(degree.getId()).get();
            degreeList.add(new Degree(degree1.getId(), degree1.getName()));
        }

        MedicalCollege medicalCollege = medicalCollegeRepo.findById(medicalCollegeId).get();
        doctor.setMedicalCollege(medicalCollege);
        doctor.setDegree(degreeList);
        doctor.setUpdateAt(new Timestamp(System.currentTimeMillis()).toString());
        doctor.setCreatedAt(doctor1.getCreatedAt());
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.ACCEPTED);
    }

    @GetMapping("doctor-details/{id}")
    public ResponseEntity<Doctor> getSingleDegree(@PathVariable int id) {
        return new ResponseEntity<>(doctorService.doctorDetails(id), HttpStatus.OK);
    }

    @GetMapping("all-doctor")
    public ResponseEntity<List<Doctor>> getAllDegree() {
        return new ResponseEntity<>(doctorService.getAllDoctor(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDegree(@PathVariable long id) {

        if (doctorService.deleteDoctor(id) == 1) {
            return new ResponseEntity<>("Delete Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found!!!", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("add-doctor-degree/{doctor_id}/{degree_id}")
    public ResponseEntity<Doctor> setDoctorDegree(@PathVariable long doctor_id, @PathVariable long degree_id) {
        Doctor doctor = doctorService.doctorDetails(doctor_id);
        List<Degree> degreeList = new ArrayList<>();

        degreeList.add(degreeRepo.findById(degree_id).get());
        doctor.setDegree(degreeList);
        doctor.setUpdateAt(new Timestamp(System.currentTimeMillis()).toString());
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.OK);
    }
}
