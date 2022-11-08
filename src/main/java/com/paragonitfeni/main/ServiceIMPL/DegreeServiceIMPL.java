package com.paragonitfeni.main.ServiceIMPL;

import com.paragonitfeni.main.Exception.NotFoundException;
import com.paragonitfeni.main.Model.Degree;
import com.paragonitfeni.main.Model.Doctor;
import com.paragonitfeni.main.Repository.DegreeRepo;
import com.paragonitfeni.main.Service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DegreeServiceIMPL implements DegreeService {
    @Autowired
    DegreeRepo degreeRepo;

    public DegreeServiceIMPL(DegreeRepo degreeRepo) {
        this.degreeRepo = degreeRepo;
    }

    @Override
    public Degree saveDegree(Degree degree) {
        return degreeRepo.save(degree);
    }

    @Override
    public Degree getDegreeById(long id) {
        Optional<Degree> degree = degreeRepo.findById(id);
        if (degree.isPresent()) {
            return degree.get();
        } else {
            throw new NotFoundException("Degree", "Id", id);
        }
    }

    @Override
    public List<Degree> getDegree() {
        return degreeRepo.findAll();
    }
}
