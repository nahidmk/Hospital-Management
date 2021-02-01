package bd.edu.seu.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document
@TypeAlias("Treatment")
public class Treatment implements Serializable {
    @Id
    private long id;
    private String name;
    private LocalDate treatmentDate;
}
