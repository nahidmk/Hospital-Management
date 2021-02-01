package bd.edu.seu.demo.Service;

import bd.edu.seu.demo.Model.Treatment;
import bd.edu.seu.demo.Repository.Treatment_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Treatment_Service {

    @Autowired
    private Treatment_Repository treatment_repository;

    @Cacheable(cacheNames = "Treatment",key = "#id")
    public Treatment find_by_id(long id){
        Treatment byId = treatment_repository.findById(id);
        if(byId!=null){
            return byId;
        }
        return null;
    }

    public List<Treatment> find_by_name(String  name){
        return treatment_repository.findByName(name);
    }

    public List<Treatment> find_by_date(LocalDate date){
        return treatment_repository.findByTreatmentDate(date);
    }

    public String save_Treatment(Treatment treatment){
        Treatment save = treatment_repository.save(treatment);
        if(save!=null){
            return HttpStatus.CREATED.name();
        }
        return HttpStatus.BAD_REQUEST.name();
    }

    @CachePut(cacheNames = "Treatment", key = "#treatment.id")
    public String update_Treatment(Treatment treatment){
        Treatment save = treatment_repository.save(treatment);
        if(save!=null){
            return HttpStatus.OK.name();
        }
        return HttpStatus.BAD_REQUEST.name();
    }
    @CacheEvict(cacheNames = "Treatment",key = "#id")
    public String delete_Treatment(long id){
        try{
            treatment_repository.deleteById(id);
        }catch (Exception ex){
            return HttpStatus.NOT_FOUND.name();
        }
        return HttpStatus.OK.name();

    }

    public List<Treatment> find_all(){
        return treatment_repository.findAll();
    }
}
