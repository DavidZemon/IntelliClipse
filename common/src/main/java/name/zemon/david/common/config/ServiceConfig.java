package name.zemon.david.common.config;

import name.zemon.david.common.service.SpringMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by david on 9/13/15.
 */
@Configuration
@ComponentScan(basePackageClasses = SpringMarker.class)
@Import(DaoConfig.class)
public class ServiceConfig {
}
