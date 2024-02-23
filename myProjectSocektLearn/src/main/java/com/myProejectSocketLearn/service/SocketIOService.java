package com.myProejectSocketLearn.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class SocketIOService {

    /**
     * 存放已连接的客户端
     */
    private static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    private static Map<String, String> ipUserNameMap = new ConcurrentHashMap<>();

    /**
     * 自定义事件`push_data_event`,用于服务端与客户端通信
     */
//    private static final String PUSH_DATA_EVENT = "push_data_event";

    private static final String RECEIVED_MESSAGE ="push_data_event";

    private static final String SEND_MESSAGE="message";

    @Autowired
    private SocketIOServer socketIOServer;

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


    public void start() {
        // 监听客户端连接
        socketIOServer.addConnectListener(client -> {
            log.debug("************ 客户端： " + getSesstionIdString(client) + " 已连接 ************");
            // 自定义事件`connected` -> 与客户端通信  （也可以使用内置事件，如：Socket.EVENT_CONNECT）
            client.sendEvent(SEND_MESSAGE, "你成功连接上了哦...");
//            clientMap.put(getSesstionIdString(client),client);
            String userName = getParamsByClient(client);
            if (userName != null) {
                log.info("用户名："+userName);
                clientMap.put(getSesstionIdString(client), client);
                ipUserNameMap.put(getSesstionIdString(client),userName);
            }
            socketIOServer.getBroadcastOperations().sendEvent(SEND_MESSAGE,"用户："+userName+"已登录");
        });

        // 监听客户端断开连接
        socketIOServer.addDisconnectListener(client -> {
            String clientIp = getIpByClient(client);
            log.info(clientIp + " *********************** " + "客户端已断开连接");
            String username = ipUserNameMap.get(getSesstionIdString(client));
            clientMap.remove(getSesstionIdString(client));
            ipUserNameMap.remove(getSesstionIdString(client));
            socketIOServer.getBroadcastOperations().sendEvent(SEND_MESSAGE,"用户："+username+"已下线");

        });

        // 自定义事件`client_info_event` -> 监听客户端消息
        socketIOServer.addEventListener(RECEIVED_MESSAGE, String.class, (client, data, ackSender) -> {
            // 客户端推送`client_info_event`事件时，onData接受数据，这里是string类型的json数据，还可以为Byte[],object其他类型
//            String clientIp = getIpByClient(client);

            String userName = ipUserNameMap.get(getSesstionIdString(client));
            log.info("用户:"+userName+ "发送消息：" + data);
            socketIOServer.getBroadcastOperations().sendEvent(SEND_MESSAGE,"用户"+userName+":"+data.toString());
        });

        // 启动服务
        socketIOServer.start();

//         broadcast: 默认是向所有的socket连接进行广播，但是不包括发送者自身，如果自己也打算接收消息的话，需要给自己单独发送。
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    // 每3秒发送一次广播消息
                    Thread.sleep(3000);
                    socketIOServer.getBroadcastOperations().sendEvent("myBroadcast", "广播消息 " + DateUtil.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void stop() {
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }

    public void pushMessageToUser(String userId, String msgContent) {
        SocketIOClient client = clientMap.get(userId);
        if (client != null) {
            client.sendEvent(SEND_MESSAGE, msgContent);
        }
    }

    /**
     * 获取客户端url中的userId参数（这里根据个人需求和客户端对应修改即可）
     *
     * @param client: 客户端
     * @return: java.lang.String
     */
    private String getParamsByClient(SocketIOClient client) {
        // 获取客户端url参数（这里的userId是唯一标识）
        Map<String, List<String>> params = client.getHandshakeData().getUrlParams();
        List<String> userIdList = params.get("userName");
        if (!CollectionUtils.isEmpty(userIdList)) {
            return userIdList.get(0);
        }
        return null;
    }

    /**
     * 获取连接的客户端ip地址
     *
     * @param client: 客户端
     * @return: java.lang.String
     */
    private String getIpByClient(SocketIOClient client) {
        String sa = client.getRemoteAddress().toString();
        String clientIp = sa.substring(1, sa.indexOf(":"));
        return clientIp;
    }

    private String getSesstionIdString(SocketIOClient client){
        return client.getSessionId().toString();
    }

}
