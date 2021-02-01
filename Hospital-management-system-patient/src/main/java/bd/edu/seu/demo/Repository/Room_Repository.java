package bd.edu.seu.demo.Repository;

import bd.edu.seu.demo.Model.Room;
import bd.edu.seu.demo.Model.Root_Type;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Room_Repository extends MongoRepository<Room,Long> {
    public Room findById(long id);
    public List<Room> findAllByRootType(String type);
    public List<Room> findAllByPeriod(int period);
}
