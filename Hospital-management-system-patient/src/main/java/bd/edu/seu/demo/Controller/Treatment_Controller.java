package bd.edu.seu.demo.Controller;

import bd.edu.seu.demo.Model.Treatment;
import bd.edu.seu.demo.Service.Treatment_Service;
import bd.edu.seu.demo.util.CommonResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping( "/")
public class Treatment_Controller {

    @Autowired
    private Treatment_Service treatment_service;

//    @GetMapping(path = "all",produces = "application/json")
    @GetMapping("/all")
    public ResponseEntity<?> find_all(){
        List<Treatment> all = treatment_service.find_all();
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),all==null || all.isEmpty() ?"Treatment List Not Found":"Treatment List Found",all),HttpStatus.OK);
    }

//    @GetMapping(path = "treatment",produces = "application/json")
    @GetMapping("/by-id")
    public ResponseEntity<?> find_by_id(@RequestParam  long id){
        Treatment by_id = treatment_service.find_by_id(id);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_id==null? "Treatment not fount":"Treatment found",by_id),HttpStatus.OK);
    }

//    @GetMapping(path = "by-name",produces = "application/json")
    @GetMapping("/by-name")
    public ResponseEntity<?> find_all_By_Name(@RequestParam String name){
        List<Treatment> all = treatment_service.find_by_name(name);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),all==null || all.isEmpty() ?"Treatment List Not Found":"Treatment List Found",all),HttpStatus.OK);
    }

//    @GetMapping(path = "by-name",produces = "application/json")
    @GetMapping("/by-date")
    public ResponseEntity<?> find_all_By_date(@RequestParam String date){
        List<Treatment> all = treatment_service.find_by_date(LocalDate.parse(date));
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),all==null || all.isEmpty() ?"Treatment List Not Found":"Treatment List Found",all),HttpStatus.OK);
    }

//    @PostMapping(path = "add", produces = "application/json")
    @PostMapping("/add")
    public ResponseEntity<CommonResponse> addTreatment(@RequestBody Treatment treatment) {
        String status = treatment_service.save_Treatment(treatment);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),status.equals("CREATED")?"Treatment Save Successful":"Bad Request",null),HttpStatus.OK);
    }

//    @PutMapping(path = "update", produces = "application/json")
    @PutMapping("/update")
    public ResponseEntity<?> updateTreatment(@RequestBody Treatment treatment) {
        String status = treatment_service.update_Treatment(treatment);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),status.equals("OK")?"Treatment Update Successful":"Bad Request",null),HttpStatus.OK);
    }

//    @DeleteMapping(path = "delete", produces = "application/json")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTreatment(@RequestParam long id) {
        String status = treatment_service.delete_Treatment(id);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),status.equals("OK")?"Treatment Delete Successful":"Treatment not found by this ID",null),HttpStatus.OK);
    }

}
