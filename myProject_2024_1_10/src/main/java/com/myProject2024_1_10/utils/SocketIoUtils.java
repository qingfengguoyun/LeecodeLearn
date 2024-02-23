package com.myProject2024_1_10.utils;

import com.corundumstudio.socketio.SocketIOClient;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class SocketIoUtils {

    public static Map<String, SocketIOClient> clientsMap;
    public static Map<String, String> clientNameMap;

    public static void addClient(SocketIOClient client,String userName){
        clientsMap.put(client.getSessionId().toString(),client);
        clientNameMap.put(client.getSessionId().toString(),userName);
    }

    public static void removeClient(SocketIOClient client){
        clientsMap.remove(client.getSessionId().toString());
        clientNameMap.remove(client.getSessionId().toString());
    }
}
