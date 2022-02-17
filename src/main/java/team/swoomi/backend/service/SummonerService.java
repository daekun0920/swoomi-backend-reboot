package team.swoomi.backend.service;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static team.swoomi.backend.config.OriannaConfig.RIOT_API_KEY;

@Service
@RequiredArgsConstructor
@Slf4j
public class SummonerService {

    private final RestTemplate restTemplate;

    public boolean getIsSummonerInGame(String summonerName, String region) {
        String summonerId = Orianna
                .summonerNamed(summonerName)
                .withRegion(Region.valueOf(region))
                .get()
                .getId();

        String riotUrl = "https://kr.api.riotgames.com/lol/spectator/v4/active-games/by-summoner/";
        riotUrl = riotUrl + summonerId + "?api_key=" + RIOT_API_KEY;

        try {
            ResponseEntity<String> result = restTemplate.getForEntity(riotUrl, String.class);
            
            return result.getStatusCode() == HttpStatus.OK;
        } catch (Exception e) {
            log.info("Summoner : " + summonerName + ", Not In Game");
            return false;
        }
    }

    public String getSummonerProfileImage(String summonerName, String region) {
        return Orianna
                .summonerNamed(summonerName)
                .withRegion(Region.valueOf(region))
                .get()
                .getProfileIcon()
                .getImage()
                .getURL();
    }
}
