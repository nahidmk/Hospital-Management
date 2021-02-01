package bd.edu.seu.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document
@TypeAlias("Madice")
public class Madice implements Serializable {
    @Id
    private long id;
    private int quantity;
    private double price;
}
