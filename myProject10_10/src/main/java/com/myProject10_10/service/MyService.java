package com.myProject10_10.service;

import com.myProject10_10.dao.RecordMapper;
import com.myProject10_10.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MyService {
//    @Autowired
//    private UpdateThread updateThread;

    @Autowired
    RecordMapper recordMapper;

//    @Async
    public void methodA(){

        System.out.println("methodA开始执行");
        Record record=Record.builder().name("method").build();
//        recordMapper.insert()

        UpdateThread updateThread=new UpdateThread(recordMapper);
        Thread thread=new Thread(updateThread);
        thread.start();

        try{
            Thread.sleep(10*1000);
        }catch (Exception e){
            e.printStackTrace();
        }

//        updateThread.stop();

        System.out.println("methodA结束执行");
    }

    public class UpdateThread implements Runnable{

        private RecordMapper recordMapper;

        public UpdateThread(RecordMapper recordMapper) {
            this.recordMapper = recordMapper;
        }

        private boolean isRunning=true;

        @Override
        public void run() {
            int i=0;
            while(isRunning){
                try {

                    recordMapper.insert(Record.builder().name("test").tag(i).build());
                    //数据库修改逻辑
                    System.out.println("每3秒执行一次-"+i);
                    Thread.currentThread().sleep(3000);
                    i+=3;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void stop(){
            System.out.println("UpdateThread被关闭");
            this.isRunning=false;
        }
    }
}
