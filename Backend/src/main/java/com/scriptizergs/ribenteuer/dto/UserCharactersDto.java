package com.scriptizergs.ribenteuer.dto;

import com.scriptizergs.ribenteuer.model.Character.GameCharacter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class UserCharacters {
    List<GameCharacter> userCharacters;
}
