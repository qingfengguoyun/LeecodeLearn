package com.myProjectRabbitMQLearn.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {


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

    /***序列化方式使用Jackson2JsonMessageConverter序列化器*/
    @Bean
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 创建一个名称为 hello 的队列
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
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

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("myFanout");
    }

    @Bean
    public Binding bindingFanoutExchageRed(Queue queueRed, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueRed).to(fanoutExchange);
    }
    @Bean
    public Binding bindingFanoutExchageBlue(Queue queueBlue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueBlue).to(fanoutExchange);
    }
    @Bean
    public Binding bindingFanoutExchageAll(Queue queueAll, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueAll).to(fanoutExchange);
    }

}

