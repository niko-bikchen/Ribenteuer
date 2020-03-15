//developed by Vladyslav Haponenko
package model.Item;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


//the class describes items and relates to the owner
@Getter
@Setter
public class Item {

    @Id
    private String id;
    private String ownerId;
}
