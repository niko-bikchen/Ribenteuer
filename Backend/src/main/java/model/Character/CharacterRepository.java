//developed by Vladyslav Haponenko
package model.Character;


import model.Character.Character;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepository extends MongoRepository<Character,String> {

    public List<Character> findCharacterByOwnerId(String id);

}
