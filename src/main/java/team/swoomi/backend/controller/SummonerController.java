package team.swoomi.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.swoomi.backend.dto.SummonerInGameResponseDto;
import team.swoomi.backend.dto.SummonerProfileImageResponseDto;
import team.swoomi.backend.service.SummonerService;

@Api(tags = "1. SUMMONER")
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
            @ApiParam(value = "리전", defaultValue = "KOREA")
            @RequestParam String region) {
        SummonerInGameResponseDto result
                = new SummonerInGameResponseDto(summonerService.getIsSummonerInGame(summonerName, region), summonerName);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/profile-image/{summonerName}")
    @ApiOperation(value = "소환사 프로필 이미지", notes = "소환사명을 받아 프로필 이미지 URL을 리턴합니다.")
    public ResponseEntity<SummonerProfileImageResponseDto> getSummonerProfileImage(
            @ApiParam(value = "소환사명", required = true)
            @PathVariable String summonerName,
            @ApiParam(value = "리전", defaultValue = "KOREA")
            @RequestParam String region) {
        SummonerProfileImageResponseDto result
                = new SummonerProfileImageResponseDto(summonerService.getSummonerProfileImage(summonerName, region), summonerName);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
