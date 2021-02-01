package bd.edu.seu.demo.Controller;

import bd.edu.seu.demo.Model.Madice;
import bd.edu.seu.demo.Model.Patient;
import bd.edu.seu.demo.Service.Patient_Service;
import bd.edu.seu.demo.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class Patient_Controller {

    @Autowired
    private Patient_Service patient_service;

    @GetMapping("/by-id")
    public ResponseEntity<?> find_by_id(@RequestParam long id){
        Patient by_id = patient_service.find_By_id(id);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_id==null?"Patient not found":"Patient found",by_id),HttpStatus.OK);
    }

    @GetMapping("/by-four")
    public ResponseEntity<?> find_by_four(@RequestParam String data){
        if(data.equals("")){
            List<Patient> all = patient_service.find_all();
            return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),all==null||all.isEmpty()?"Patient not found":"Patient found",all),HttpStatus.OK);
        }else {
            List<Patient> all = patient_service.find_By_Name_or_Address_or_Contact_or_Gender(data);
            return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),all==null||all.isEmpty()?"Patient not found":"Patient found",all),HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> find_all(){
        List<Patient> all = patient_service.find_all();
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),all==null||all.isEmpty()?"Patient not found":"Patient found",all),HttpStatus.OK);
    }

    @GetMapping("/by-joindate")
    public ResponseEntity<?> find_by_joinDate(String date){
        List<Patient> by_joinDate = patient_service.find_By_JoinDate(LocalDate.parse(date));
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_joinDate==null||by_joinDate.isEmpty()?"Patient not found":"Patient found",by_joinDate),HttpStatus.OK);
    }

    @GetMapping("/by-relasedate")
    public ResponseEntity<?> find_by_dischargedDate(String date){
        List<Patient> by_joinDate = patient_service.find_By_DischargedDate(LocalDate.parse(date));
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_joinDate==null||by_joinDate.isEmpty()?"Patient not found":"Patient found",by_joinDate),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> save_Patient(@RequestBody Patient patient){
        String s = patient_service.save_patient(patient);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("CREATED")?"Patient save successful":"Bed request",null),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update_Patient(@RequestBody Patient patient){
        String s = patient_service.update_Patient(patient);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("OK")?"Patient update successful":"Bed request",null),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete_Patient(@RequestParam long id){
        String s = patient_service.delete_Patient(id);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("OK")?"Patient Delete successful":"Bed request",null),HttpStatus.OK);

    }
}
