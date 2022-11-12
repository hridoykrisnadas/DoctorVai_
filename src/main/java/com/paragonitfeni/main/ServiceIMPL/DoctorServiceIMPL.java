package com.paragonitfeni.main.ServiceIMPL;

import com.paragonitfeni.main.Exception.NotFoundException;
import com.paragonitfeni.main.Model.Doctor;
import com.paragonitfeni.main.Repository.DoctorRepo;
import com.paragonitfeni.main.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceIMPL implements DoctorService {
    @Autowired
    DoctorRepo doctorRepo;

    public DoctorServiceIMPL(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepo.findAll();
    }

    @Override
    public int deleteDoctor(long id) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
        if (doctor.isPresent()){
            doctorRepo.deleteById(id);
            return 1;
        } else {
            return 0;
        }
    }


    @Override
    public Doctor doctorDetails(long id) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
        if (doctor.isPresent()) {
            return doctor.get();
        } else {
            throw new NotFoundException("Doctor", "Id", id);
        }
    }
}
