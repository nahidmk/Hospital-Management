package bd.edu.seu.demo.Service;

import bd.edu.seu.demo.Model.Room;
import bd.edu.seu.demo.Model.Treatment;
import bd.edu.seu.demo.Repository.Room_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Room_Service {

    @Autowired
    private Room_Repository room_repository;

    @Cacheable(cacheNames = "Room",key = "#id")
    public Room find_by_id(long id){
        Room byId = room_repository.findById(id);
        if(byId!=null){
            return byId;
        }
        return null;
    }

    public List<Room> find_by_room_type(String  type){
        return room_repository.findAllByRootType(type);
    }

    public List<Room> find_by_period(int period){
        return room_repository.findAllByPeriod(period);
    }

    public List<Room> find_all(){
        return room_repository.findAll();
    }
    public String save_Room(Room room){
        Room save = room_repository.save(room);
        if(save!=null){
            return HttpStatus.CREATED.name();
        }
        return HttpStatus.BAD_REQUEST.name();
    }

    @CachePut(cacheNames = "Room",key = "#room.id")
    public String update_Room(Room room){
        Room save = room_repository.save(room);
        if(save!=null){
            return HttpStatus.OK.name();
        }
        return HttpStatus.BAD_REQUEST.name();
    }

    @CacheEvict(cacheNames = "Room",key = "#id")
    public String delete_Room(long id){
        try{
            room_repository.deleteById(id);
        }catch (Exception ex){
            return HttpStatus.NOT_FOUND.name();
        }
        return HttpStatus.OK.name();

    }

}
