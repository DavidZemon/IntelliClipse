package name.zemon.david;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by david on 9/8/15.
 */
@Configuration
public class MainConfig {
    @Bean
    public Main main() {
        return new Main();
    }
}
