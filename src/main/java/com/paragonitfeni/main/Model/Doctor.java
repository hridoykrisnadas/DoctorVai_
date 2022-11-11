package com.paragonitfeni.main.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "bmdc_no", nullable = false)
    private String bmdcNo;
    @Column(name = "work_station")
    private String workStation;
    @Column(name = "designation")
    private String designation;
    @Column(name = "mobile_no")
    private String mobileNo;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_medical_college_id")
    private MedicalCollege medicalCollege;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_degree")
    @JoinColumn(name = "doctor_id", referencedColumnName = "degree_id")
    private List<Degree> degree;

    private String createdAt;
    private String updateAt;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {

        this.updateAt = updateAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBmdcNo() {
        return bmdcNo;
    }

    public void setBmdcNo(String bmdcNo) {
        this.bmdcNo = bmdcNo;
    }

    public String getWorkStation() {
        return workStation;
    }

    public void setWorkStation(String workStation) {
        this.workStation = workStation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public MedicalCollege getMedicalCollege() {
        return medicalCollege;
    }

    public void setMedicalCollege(MedicalCollege medicalCollege) {
        this.medicalCollege = medicalCollege;
    }

    public List<Degree> getDegree() {
        return degree;
    }

    public void setDegree(List<Degree> degree) {
        this.degree = degree;
    }
}
