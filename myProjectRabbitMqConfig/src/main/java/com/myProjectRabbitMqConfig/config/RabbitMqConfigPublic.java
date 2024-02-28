package com.myProjectRabbitMqConfig.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfigPublic {

    /**
     * 创建一个名称为 hello 的队列
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    /**
     * RabbitTemplate是RabbitMQ在与SpringAMQP整合的时，Spring提供的即时消息模板
     * RabbitTemplate提供了可靠性消息投递方法、回调监听消息接口ConfirmCallback、返回值确认接口ReturnCallback等等
     */
    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    /***默认RabbitMQ序列化方式是SerializerMessageConverter序列化器，这么我们使用Jackson2JsonMessageConverter序列化器。我们需要设置下，内容如下：*/
    @Bean
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    final static String red="topic.red";
    final static String blue ="topic.blue";
    final static String all ="topic.all";

    @Bean
    public Queue queueRed(){
        return new Queue(red);
    }

    @Bean
    public Queue queueBlue(){
        return new Queue(blue);
    }

    @Bean
    public Queue queueAll(){
        return new Queue(all);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeRed(Queue queueRed, TopicExchange exchange){
        return BindingBuilder.bind(queueRed).to(exchange).with("topic.red");
    }
    @Bean
    Binding bindingExchangeBlue( Queue queueBlue,  TopicExchange exchange){
        return BindingBuilder.bind(queueBlue).to(exchange).with("topic.blue");
    }
    @Bean
    Binding bindingExchangeAll( Queue queueAll,  TopicExchange exchange){
        return BindingBuilder.bind(queueAll).to(exchange).with("topic.#");
    }
}