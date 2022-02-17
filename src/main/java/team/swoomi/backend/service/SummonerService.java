package team.swoomi.backend.service;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummonerService {
    public boolean getIsSummonerInGame(String summonerName, String region) {
        return Orianna
                .summonerNamed(summonerName)
                .withRegion(Region.valueOf(region))
                .get()
                .isInGame();
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
