package name.zemon.david.server.config;

import name.zemon.david.common.config.ServiceConfig;
import name.zemon.david.server.controller.SpringMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by david on 9/8/15.
 */
@Configuration
@ComponentScan(basePackageClasses = SpringMarker.class)
@EnableWebMvc
@Import(ServiceConfig.class)
public class MainConfig {
}
