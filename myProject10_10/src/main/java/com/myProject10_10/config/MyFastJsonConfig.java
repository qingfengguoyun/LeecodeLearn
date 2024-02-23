package com.myProject10_10.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFastJsonConfig {

    @Bean
    public FastJsonConfig fastJsonConfig(){
        FastJsonConfig config=new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //禁用循环引用检测
        //config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        return config;
    }
}
