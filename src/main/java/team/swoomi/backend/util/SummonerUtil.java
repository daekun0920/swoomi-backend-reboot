package team.swoomi.backend.util;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;

public class SummonerUtil {

    public static String realSummonerName(String summonerName, String region) {
        return Orianna
                .summonerNamed(summonerName)
                .withRegion(Region.valueOf(region))
                .get()
                .getName();
    }
}
