package com.paragonitfeni.main.Service;

import com.paragonitfeni.main.Model.MedicalCollege;

import java.util.List;

public interface MedicalCollegeService {
    MedicalCollege saveMedicalCollege(MedicalCollege medicalCollege);

    MedicalCollege getCollegeById(long id);

    List<MedicalCollege> getMedicalCollege();
}
