package bd.edu.seu.demo.Repository;

import bd.edu.seu.demo.Model.Madice;
import bd.edu.seu.demo.Model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface Patient_Repository extends MongoRepository<Patient,Long>{

    Patient findById (long id);
    List<Patient> findAllByNameOrAddressOrContactOrGender (String value);

//    List<Patient> findAllByAddress (String address);
//    Patient findByContact (String contact);
    List<Patient> findAllByJoinDate (LocalDate date);
    List<Patient> findAllByDischargedDate (LocalDate date);
//    List<Patient> findAllByGender (String gender);



}
