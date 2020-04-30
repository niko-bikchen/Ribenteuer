//developed by Vladyslav Haponenko
package model.Character;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepository extends MongoRepository<GameCharacter,String> {

    public List<GameCharacter> findGameCharacterByOwnerId(String id);

    public GameCharacter findByNameAndOwnerId(String name, String ownerId);

    public void deleteAllByOwnerId(String id);



}
