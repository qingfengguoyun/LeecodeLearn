package com.myProjectSocketIoPractice.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;

import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class SocketIoService {

    @Autowired
    SocketIOServer socketIOServer;

    private static Map<String, SocketIOClient> clients=new ConcurrentHashMap<>();

    private static Map<String, String> clientsName=new ConcurrentHashMap<>();

    public static String MESSAGE="message";

    /**
     * Spring IoC容器创建之后，在加载SocketIOServiceImpl Bean之后启动
     */
    @PostConstruct
    private void autoStartup() {
//        log.info("socketIO start："+socketIOServer.getConfiguration().getHostname()+":"+socketIOServer.getConfiguration().getPort());
        start();
    }

    /**
     * Spring IoC容器在销毁SocketIOServiceImpl Bean之前关闭,避免重启项目服务端口占用问题
     */
    @PreDestroy
    private void autoStop() {
        stop();
    }

    public void start(){
        //启动方法中添加各种监听事件
        //必须事件connect，disconnect
        socketIOServer.addConnectListener(client ->{
            String sessionId = client.getSessionId().toString();
            log.info(client.getRemoteAddress().toString());
            String userName=getParamFromClient(client);
            if(userName!=null){
                clients.put(sessionId,client);
                clientsName.put(sessionId,userName);
                String msg="用户"+userName+"加入聊天室";
                log.info(msg);
                socketIOServer.getBroadcastOperations().sendEvent(MESSAGE,msg);
            }

        } );

        socketIOServer.addDisconnectListener(client->{
            String sessionId = client.getSessionId().toString();
            String userName = clientsName.get(sessionId);
            String msg="用户"+userName+"退出聊天室";
            log.info("用户"+userName+"退出聊天室");
            clients.remove(sessionId);
            clientsName.remove(sessionId);
            socketIOServer.getBroadcastOperations().sendEvent(MESSAGE,msg);
        });

        socketIOServer.addEventListener(MESSAGE,String.class,(client, data, ackSender)->{
            String userName = clientsName.get(client.getSessionId().toString());
            String msg="用户"+userName+": "+data;
            log.info(msg);
            socketIOServer.getBroadcastOperations().sendEvent(MESSAGE,msg);
        });

        socketIOServer.start();

//        MyThread myThread=new MyThread();
//        myThread.run();
    }

    public void stop(){
        if(socketIOServer!=null){
            socketIOServer.stop();
            socketIOServer=null;
        }
    }


    class MyThread implements Runnable{
        @Override
        public void run() {
//            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            while (true) {
                try {
                    // 每3秒发送一次广播消息
                    Thread.sleep(3000);
                    socketIOServer.getBroadcastOperations().sendEvent("message", "广播消息 :" + DateUtil.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String getParamFromClient(SocketIOClient client){
        return client.getHandshakeData().getSingleUrlParam("userName");
    }
}
