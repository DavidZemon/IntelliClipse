package name.zemon.david.batch;

import name.zemon.david.common.config.ServiceConfig;
import name.zemon.david.common.service.PeopleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by david on 9/13/15.
 */
@Configuration
@Import(ServiceConfig.class)
public class MainConfig {
    @Bean
    public Runnable main(final PeopleService peopleService) {
        return new Main(peopleService);
    }
}
