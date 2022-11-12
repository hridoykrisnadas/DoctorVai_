package com.paragonitfeni.main.Service;

import com.paragonitfeni.main.Model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);

    Doctor doctorDetails(long id);

    List<Doctor> getAllDoctor();

    int deleteDoctor(long id);

}
