package com.paragonitfeni.main.Repository;

import com.paragonitfeni.main.Model.MedicalCollege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCollegeRepo extends JpaRepository<MedicalCollege, Long> {

}
