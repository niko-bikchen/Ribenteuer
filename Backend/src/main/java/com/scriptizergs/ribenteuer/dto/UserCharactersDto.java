package com.scriptizergs.ribenteuer.dto;

import com.scriptizergs.ribenteuer.model.Character.GameCharacter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class UserCharactersDto {
    private final List<GameCharacter> userCharacters;
}
