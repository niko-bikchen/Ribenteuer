package com.scriptizergs.ribenteuer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class CharacterStatsDto {
    private int agility;
    private int strength;
    private int intelligence;
}
