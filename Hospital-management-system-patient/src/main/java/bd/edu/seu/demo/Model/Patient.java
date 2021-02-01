package bd.edu.seu.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document
@TypeAlias("Patient")
public class Patient implements Serializable {
    @Id
    private long id;
    private String name;
    private Gender gender;
    private String address;
    private String contact;
    private LocalDate joinDate;
    private LocalDate dischargedDate;
    private List<Madice> madiceList;
    private List<Treatment> treatmentList;
    private Room room;
}
