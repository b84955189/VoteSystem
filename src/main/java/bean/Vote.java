package bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 10:54 AM
 */
@Data
@ToString
public class Vote {
    private int id;
    private String candidate;
    private int poll;
}
