package com.person.consumer.configuration;

import com.person.consumer.entity.Person;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class ListenerConfig {
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Person> kafkaListenerFactory(final KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, Person> factory = new ConcurrentKafkaListenerContainerFactory<String, Person>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }

    private ConsumerFactory<String, Person> consumerFactory(final KafkaProperties kafkaProperties) {
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.addTrustedPackages("*");
        JsonDeserializer<Person> valueDeserializer = new JsonDeserializer<>(Person.class);
        valueDeserializer.setTypeMapper(typeMapper);
        valueDeserializer.setUseTypeMapperForKey(true);
        StringDeserializer stringDeserializer = new StringDeserializer();

        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties(), stringDeserializer, valueDeserializer);
    }
}
