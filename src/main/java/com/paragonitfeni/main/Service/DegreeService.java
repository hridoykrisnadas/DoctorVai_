package com.paragonitfeni.main.Service;

import com.paragonitfeni.main.Model.Degree;

import java.util.List;

public interface DegreeService {
    Degree saveDegree(Degree degree);

    Degree getDegreeById(long id);

    List<Degree> getDegree();
}
