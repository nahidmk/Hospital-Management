package bd.edu.seu.demo.Repository;

import bd.edu.seu.demo.Model.Madice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Madice_Repository extends MongoRepository<Madice,Long> {

    List<Madice> findAllByPrice(double price);
    List<Madice> findAllByQuantity(int quantity);
    Madice findById (long id);
}
