package com.scriptizergs.ribenteuer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class NewCharacterDto {
    private String name;
    private String level;
    private int portraitId;
    private CharacterStatsDto stats;
    private String characterClass;
}
