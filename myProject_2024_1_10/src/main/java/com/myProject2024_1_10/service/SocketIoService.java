package com.myProject2024_1_10.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.myProject2024_1_10.utils.SocketIoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SocketIoService {

    static final String CONNECT="connection";
    static final String DISCONNECT="disconnection";
    static final String MESSAGE="message";


    @Autowired
    private SocketIOServer socketIOServer;

    @EventListener(ApplicationReadyEvent.class)
    public void startSocketIO(){
        socketIOServer.start();

        log.info("SocketIoStart");
    }

    @OnConnect
    public void onConnectOrg(SocketIOClient client){

        log.info("client connect{}",client.getRemoteAddress());
//        SocketIoUtils.addClient(client,userName);
//        socketIOServer.getBroadcastOperations().sendEvent(MESSAGE,info);
    }

    @OnDisconnect
    public void onDisconnectOrg(SocketIOClient client){

        log.info("client disconnect{}",client.getRemoteAddress());
//        SocketIoUtils.addClient(client,userName);
//        socketIOServer.getBroadcastOperations().sendEvent(MESSAGE,info);
    }

//    @OnEvent(CONNECT)
//    public void onConnect(SocketIOClient client,String userName){
//        String info=userName+" 加入聊天室";
//        log.info(info);
//        SocketIoUtils.addClient(client,userName);
//        socketIOServer.getBroadcastOperations().sendEvent(MESSAGE,info);
//    }
//
//    @OnEvent(DISCONNECT)
//    public void onDisConnect(SocketIOClient client,String userName){
//        String info=userName+" 退出聊天室";
//        log.info(userName+" 退出聊天室");
//        SocketIoUtils.removeClient(client);
//        socketIOServer.getBroadcastOperations().sendEvent(MESSAGE,info);
//    }
}
