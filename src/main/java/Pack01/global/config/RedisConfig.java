//package Pack01.global.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//@Configuration
//public class RedisConfig {
//    private final String redisHost;
//    private final int redisPort;
//
//    public RedisConfig( @Value("${spring.data.redis.host}") final String redisHost,
//                        @Value("${spring.data.redis.port}") final int redisPort) {
//        this.redisHost = redisHost;
//        this.redisPort = redisPort;
//    }
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory(redisHost, redisPort);
//    }
//
//    @Bean
//    public StringRedisTemplate redisTemplate() {
//        return new StringRedisTemplate();
//    }
//}
