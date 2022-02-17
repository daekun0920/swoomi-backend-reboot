package team.swoomi.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SummonerInGameResponseDto {
    private boolean isInGame;
    private String summonerName;
}
