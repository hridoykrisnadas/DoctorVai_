package com.paragonitfeni.main.RestController;

import com.paragonitfeni.main.Model.Degree;
import com.paragonitfeni.main.Service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/degree/")
public class DegreeController {
    @Autowired
    DegreeService degreeService;

    public DegreeController(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    @PostMapping("save")
    public ResponseEntity<Degree> saveDegree(@RequestBody Degree degree){
        degree.setCreatedAt(new Timestamp(System.currentTimeMillis()).toString());
        return new ResponseEntity<>(degreeService.saveDegree(degree), HttpStatus.CREATED);
    }

    @GetMapping("degree-details/{id}")
    public ResponseEntity<Degree> getSingleDegree(@PathVariable int id){
        return new ResponseEntity<>(degreeService.getDegreeById(id), HttpStatus.OK);
    }

    @GetMapping("all-degree")
    public ResponseEntity<List<Degree>> getAllDegree(){
        return new ResponseEntity<>(degreeService.getDegree(), HttpStatus.OK);
    }
}
