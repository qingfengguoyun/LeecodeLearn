package com.myProjectRedisPractice.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    //RedisConnectionFactory已由lettuce提供
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        /**
         * mapper 是一个 ObjectMapper 对象，是用于进行对象的序列化和反序列化的主要类
         */
        ObjectMapper objectMapper=new ObjectMapper();
        /**
         * setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY) 是 ObjectMapper 类中的一个方法，用于设置属性的可见性。
         * PropertyAccessor.ALL 是一个枚举值，表示将所有的属性都包括在内。它包括了 Field、Getter、Setter、Creator 等所有访问器类型。
         * JsonAutoDetect.Visibility.ANY 也是一个枚举值，表示属性对于序列化和反序列化是可见的，即所有属性都可以被访问。
         */
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        /**
         * activateDefaultTyping() 是 ObjectMapper 类中的一个方法，用于激活默认的类型信息处理方式。
         * LaissezFaireSubTypeValidator.instance 是一个子类型验证器，用于检查和验证子类型的关系。是默认子类型验证器实例，可以接受任何子类型。
         * ObjectMapper.DefaultTyping.NON_FINAL 是一个枚举值，表示只对非 final 类型的对象进行类型信息的序列化和反序列化。
         * JsonTypeInfo.As.PROPERTY 是一个枚举值，表示类型信息将作为属性的方式进行处理，即在序列化和反序列化过程中会添加一个属性来存储类型信息。
         */
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        FastJson2JsonRedisSerializer serializer=new FastJson2JsonRedisSerializer(Object.class);
        serializer.setObjectMapper(objectMapper);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);



        /**
         * 用于保存对template的设置
         */
        template.afterPropertiesSet();
        return template;
    }
}
