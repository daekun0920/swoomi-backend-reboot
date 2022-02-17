package team.swoomi.backend.config;

import com.merakianalytics.orianna.Orianna;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class OriannaConfig {
    public static String RIOT_API_KEY = "";

    @PostConstruct
    public void setApiKey() {
        Orianna.setRiotAPIKey(RIOT_API_KEY);
    }
}
