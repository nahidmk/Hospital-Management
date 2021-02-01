package bd.edu.seu.demo.Service;

import bd.edu.seu.demo.Model.Patient;
import bd.edu.seu.demo.Repository.Patient_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class Patient_Service {
    @Autowired
    private Patient_Repository patient_repository;

    @Cacheable(cacheNames = "Patient",key = "#id")
    public Patient find_By_id(long id)
    {
        Patient patient = patient_repository.findById(id);
        if(patient!=null){
            return patient;
        }else{
            return null;
        }

    }

    public List<Patient> find_By_Name_or_Address_or_Contact_or_Gender(String data){
        return patient_repository.findAllByNameOrAddressOrContactOrGender(data);
    }

    public List<Patient> find_By_JoinDate(LocalDate date){
        return patient_repository.findAllByJoinDate(date);
    }

    public List<Patient> find_all(){
        return patient_repository.findAll();
    }

    public List<Patient> find_By_DischargedDate(LocalDate date){
        return patient_repository.findAllByDischargedDate(date);
    }

    public String save_patient(Patient patient){
        Patient save = patient_repository.save(patient);
        if(save!=null){
            return HttpStatus.CREATED.name();
        }
        return HttpStatus.BAD_REQUEST.name();
    }

    @CachePut(cacheNames = "Patient",key = "#patient.id")
    public String update_Patient(Patient patient) {
        Patient update = patient_repository.save(patient);
        if (update != null) {
            return HttpStatus.OK.name();
        }
        return HttpStatus.BAD_REQUEST.name();
    }

    @CacheEvict(cacheNames = "Patient",key = "#id")
    public String delete_Patient(Long id) {
        try {
            patient_repository.deleteById(id);
        }catch (Exception ex){
            return HttpStatus.NOT_FOUND.name();
        }
        return HttpStatus.OK.name();
    }

}
