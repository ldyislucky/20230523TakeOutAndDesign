package mode.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * @author : ldy
 * @version : 1.0
 */
@Slf4j
@Data
public class Book {
    private String id;
    private String title;
    private String author;
}
