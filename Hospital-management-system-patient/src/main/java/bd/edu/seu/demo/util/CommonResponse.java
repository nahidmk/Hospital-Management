package bd.edu.seu.demo.util;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse implements Serializable {

    private int status;
    private String message;
    private Object object;
}
