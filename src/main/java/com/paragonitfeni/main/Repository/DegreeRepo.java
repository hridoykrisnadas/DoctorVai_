package com.paragonitfeni.main.Repository;

import com.paragonitfeni.main.Model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepo extends JpaRepository<Degree, Long> {

}
