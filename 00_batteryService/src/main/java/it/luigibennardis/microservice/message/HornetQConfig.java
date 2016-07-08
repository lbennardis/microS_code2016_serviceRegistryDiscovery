package it.luigibennardis.microservice.message;

import java.util.HashMap;
import java.util.Map;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.jms.client.HornetQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;

@EnableJms
@Configuration
public class HornetQConfig {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory =
                new CachingConnectionFactory();
        cachingConnectionFactory.setSessionCacheSize(10);
        cachingConnectionFactory.setCacheProducers(false);
        cachingConnectionFactory.setTargetConnectionFactory(hornetQConnectionFactory());
        return cachingConnectionFactory;
    }

    @Bean
    public HornetQConnectionFactory hornetQConnectionFactory() {

        HornetQConnectionFactory connectionFactory =
                new HornetQConnectionFactory(false, transportConfiguration());
        return connectionFactory;
    }

    @Bean
    public TransportConfiguration transportConfiguration() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("host", "localhost");
        map.put("port", 5445);
        TransportConfiguration configuration =
                new TransportConfiguration(
                        "org.hornetq.core.remoting.impl.netty.NettyConnectorFactory", map);
        return configuration;
    }

}
