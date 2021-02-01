package bd.edu.seu.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Document
@TypeAlias("Room")
public class Room implements Serializable {
    @Id
    private long id;
    private Root_Type rootType;
    private int period;
}
