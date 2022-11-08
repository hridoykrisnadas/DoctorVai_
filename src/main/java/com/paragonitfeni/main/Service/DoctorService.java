package com.paragonitfeni.main.Service;

import com.paragonitfeni.main.Model.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);

    Doctor DoctorDetails(long id);

    List<Doctor> getAllDoctor();
}
