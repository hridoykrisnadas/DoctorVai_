package com.paragonitfeni.main.Repository;

import com.paragonitfeni.main.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    @Query("from Doctor order by name desc")
    List<Doctor> getAllDoctor();

    @Query("from Doctor where id=?1")
    Doctor getDoctorById(long id);


}
