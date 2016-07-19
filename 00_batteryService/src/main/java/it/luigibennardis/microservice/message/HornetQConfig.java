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
	/*
	 * #HORNETQ SERVER
spring.hornetq.mode=native
spring.hornetq.host=10.17.188.191
spring.hornetq.port=9876
spring.hornetq.embedded.enabled=false
#org.hornetq.jms.server.config.JMSQueueConfiguration=provaCodaMessaggi
#9876 5445
#spring.hornetq.mode=native
#spring.hornetq.host=localhost
#spring.hornetq.port=9876
#spring.hornetq.embedded.enabled=false



# application properties
jms.queueName=queue1
jms.selector=CLIENT_ID=1
sleepTime=0

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
    */
}
