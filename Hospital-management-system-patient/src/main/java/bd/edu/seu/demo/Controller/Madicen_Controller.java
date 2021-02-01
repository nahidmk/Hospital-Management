package bd.edu.seu.demo.Controller;


import bd.edu.seu.demo.Model.Madice;
import bd.edu.seu.demo.Model.Room;
import bd.edu.seu.demo.Service.Madicen_Service;
import bd.edu.seu.demo.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/madicen")
public class Madicen_Controller {
    @Autowired
    private Madicen_Service madicen_service;

    @GetMapping("/by-id")
    public ResponseEntity<?> find_by_id(@RequestParam long id){
        Madice by_id = madicen_service.find_by_id(id);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_id==null?"Madicen not found":"Madicne found",by_id),HttpStatus.OK);
    }

    @GetMapping("/by-quantity")
    public ResponseEntity<?> find_by_quantity(@RequestParam int quantity){
        List<Madice> by_quantity = madicen_service.find_by_quantity(quantity);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_quantity==null||by_quantity.isEmpty()?"Madicen's not found":"Madicen's found",by_quantity),HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<?> find_all(){
        List<Madice> all = madicen_service.find_all();
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),all==null||all.isEmpty()?"Madicen's not found":"Madicen's found",all),HttpStatus.OK);

    }

    @GetMapping("/by-period")
    public ResponseEntity<?> find_by_price(@RequestParam double price){
        List<Madice> by_price = madicen_service.find_by_price(price);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),by_price==null||by_price.isEmpty()?"Room's not found":"Room's found",by_price),HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<?> save_Madicne(@RequestBody Madice madice){
        String s = madicen_service.save_madecine(madice);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("CREATED")?"Madicen save successful":"Bed request",null),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update_Madicne(@RequestBody Madice madice){
        String s = madicen_service.update_madecine(madice);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("OK")?"Madicen update successful":"Bed request",null),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete_Madicne(@RequestParam long id){
        String s = madicen_service.delete_madecine(id);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s.equals("OK")?"Madicne Delete successful":"Bed request",null),HttpStatus.OK);

    }
}
