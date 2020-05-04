package com.scriptizergs.ribenteuer.controllers;

import com.scriptizergs.ribenteuer.dto.NewCharacterDto;
import com.scriptizergs.ribenteuer.dto.UserCharactersDto;
import com.scriptizergs.ribenteuer.helpers.RequestHelper;
import com.scriptizergs.ribenteuer.model.Character.CharacterService;
import com.scriptizergs.ribenteuer.model.Character.ClassesCategories;
import com.scriptizergs.ribenteuer.model.Character.GameCharacter;
import com.scriptizergs.ribenteuer.model.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
@PreAuthorize("hasRole('ROLE_USER')")
public class UserRestController {
    private final RequestHelper requestHelper;

    private final CharacterService characterService;

    @GetMapping("/characters")
    public ResponseEntity<UserCharactersDto> getAllUserCharacters(HttpServletRequest request) {
        User currentUser = requestHelper.getCurrentUser(request);
        List<GameCharacter> characters = characterService.findAllUsersChars(currentUser.getId());
        return ResponseEntity.status(HttpStatus.OK).body(UserCharactersDto.of(characters));
    }

    @PostMapping("/characters")
    public ResponseEntity<UserCharactersDto> createNewCharacter(@RequestBody NewCharacterDto newCharacter, HttpServletRequest request) {
        User currentUser = requestHelper.getCurrentUser(request);
        ClassesCategories characterClass = ClassesCategories.valueOf(newCharacter.getCharacterClass().toUpperCase());
        GameCharacter character = characterService.makeCharacter(characterClass, currentUser.getId(), newCharacter.getName(), newCharacter.getPortraitId());
        character.setAgility(newCharacter.getStats().getAgility());
        character.setIntelligence(newCharacter.getStats().getIntelligence());
        character.setStrength(newCharacter.getStats().getStrength());
        characterService.updateChar(character);

        List<GameCharacter> characters = characterService.findAllUsersChars(currentUser.getId());
        return ResponseEntity.status(HttpStatus.OK).body(UserCharactersDto.of(characters));
    }
}
