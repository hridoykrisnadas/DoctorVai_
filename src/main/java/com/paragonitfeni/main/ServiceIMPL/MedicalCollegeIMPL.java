package com.paragonitfeni.main.ServiceIMPL;

import com.paragonitfeni.main.Exception.NotFoundException;
import com.paragonitfeni.main.Model.MedicalCollege;
import com.paragonitfeni.main.Repository.MedicalCollegeRepo;
import com.paragonitfeni.main.Service.MedicalCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalCollegeIMPL implements MedicalCollegeService {
    @Autowired
    MedicalCollegeRepo medicalCollegeRepo;

    public MedicalCollegeIMPL(MedicalCollegeRepo medicalCollegeRepo) {
        this.medicalCollegeRepo = medicalCollegeRepo;
    }

    @Override
    public MedicalCollege saveMedicalCollege(MedicalCollege medicalCollege) {
        return medicalCollegeRepo.save(medicalCollege);
    }

    @Override
    public MedicalCollege getCollegeById(long id) {
        Optional<MedicalCollege> medicalCollege = medicalCollegeRepo.findById(id);
        if (medicalCollege.isPresent()){
            return medicalCollege.get();
        } else {
            throw new NotFoundException("Medical College", "Id", id);
        }
    }

    @Override
    public List<MedicalCollege> getMedicalCollege() {
        return medicalCollegeRepo.findAll();
    }
}
