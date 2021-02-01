package bd.edu.seu.demo.Service;

import bd.edu.seu.demo.Model.Madice;
import bd.edu.seu.demo.Repository.Madice_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Madicen_Service {

    @Autowired
    private Madice_Repository madice_repository;

    @Cacheable(cacheNames = "Madine",key = "#id")
    public Madice find_by_id(long id){
        Madice byId = madice_repository.findById(id);
        if(byId!=null){
            return byId;
        }
        return null;
    }

    public List<Madice> find_by_quantity(int quantity){
        return madice_repository.findAllByQuantity(quantity);
    }

    public List<Madice> find_by_price(double price){
        return madice_repository.findAllByPrice(price);
    }
    public List<Madice> find_all(){
        return madice_repository.findAll();
    }

    public String save_madecine(Madice madice){
        Madice save = madice_repository.save(madice);
        if(save!=null){
            return HttpStatus.CREATED.name();
        }
        return HttpStatus.BAD_REQUEST.name();
    }

    @CachePut(cacheNames = "Madine",key = "#madice.id")
    public String update_madecine(Madice madice){
        Madice save = madice_repository.save(madice);
        if(save!=null){
            return HttpStatus.OK.name();
        }
        return HttpStatus.BAD_REQUEST.name();
    }

    @CacheEvict(cacheNames = "Madine",key = "#id")
    public String delete_madecine(long id){
        try{
            madice_repository.deleteById(id);
        }catch (Exception ex){
            return HttpStatus.NOT_FOUND.name();
        }
        return HttpStatus.OK.name();

    }




}
