package Pack01.global.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "Pack01.global.schedule")
@EnableScheduling
public class SchedulingConfig  {


}
