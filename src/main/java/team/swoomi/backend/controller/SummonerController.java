package team.swoomi.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.swoomi.backend.dto.SummonerInGameResponseDto;
import team.swoomi.backend.service.SummonerService;

@Api(tags = "1. SUMMONER_V4")
@RestController
@RequestMapping("/summoner")
@RequiredArgsConstructor
public class SummonerController {

    private final SummonerService summonerService;

    @GetMapping("/status/{summonerName}")
    @ApiOperation(value = "게임 시작 여부 반환", notes = "소환사명을 받아 현재 게임 시작 여부를 리턴합니다.")
    public ResponseEntity<SummonerInGameResponseDto> getIsSummonerInGame(
            @ApiParam(value = "소환사명", required = true)
            @PathVariable String summonerName,
            @ApiParam(value = "리전", required = false, defaultValue = "KR")
            @PathVariable String region) {
        SummonerInGameResponseDto result
                = new SummonerInGameResponseDto(summonerService.getIsSummonerInGame(summonerName, region), summonerName);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
