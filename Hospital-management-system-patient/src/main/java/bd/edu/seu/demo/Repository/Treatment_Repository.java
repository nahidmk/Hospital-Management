package bd.edu.seu.demo.Repository;

import bd.edu.seu.demo.Model.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
//public interface StudentRepository extends MongoRepository<Student, Long>
@Repository
public interface Treatment_Repository extends MongoRepository<Treatment,Long> {

    Treatment findById(long id);
    List<Treatment> findByName(String name);
    List<Treatment> findByTreatmentDate(LocalDate date);
}
