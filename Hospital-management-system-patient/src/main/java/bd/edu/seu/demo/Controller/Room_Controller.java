package bd.edu.seu.demo.Controller;


import bd.edu.seu.demo.Model.Room;
import bd.edu.seu.demo.Service.Room_Service;
import bd.edu.seu.demo.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class Room_Controller {

    @Autowired
    private Room_Service room_service;

    @GetMapping("/by-id")
    public ResponseEntity<?> find_by_id(@RequestParam long id){
        Room by_id = room_service.find_by_id(id);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_id==null?"Room not found":"Room found",by_id),HttpStatus.OK);
    }

    @GetMapping("/by-type")
    public ResponseEntity<?> find_by_type(@RequestParam String type){
        List<Room> by_room_type = room_service.find_by_room_type(type);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_room_type==null||by_room_type.isEmpty()?"Room's not found":"Room's found",by_room_type),HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<?> find_all(){
        List<Room> all = room_service.find_all();
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),all==null||all.isEmpty()?"Room's not found":"Room's found",all),HttpStatus.OK);

    }

    @GetMapping("/by-period")
    public ResponseEntity<?> find_by_period(@RequestParam int period){
        List<Room> by_room_type = room_service.find_by_period(period);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_room_type==null||by_room_type.isEmpty()?"Room's not found":"Room's found",by_room_type),HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<?> save_Room(@RequestBody Room room){
        String s = room_service.save_Room(room);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("CREATED")?"Room save successful":"Bed request",null),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update_Room(@RequestBody Room room){
        String s = room_service.update_Room(room);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("OK")?"Room update successful":"Bed request",null),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete_Room(@RequestParam long id){
        String s = room_service.delete_Room(id);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("OK")?"Room Delete successful":"Bed request",null),HttpStatus.OK);

    }

}
