package com.mulread;

import java.io.IOException;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: 张扬
 * @Date: 2018/11/20 18:31
 * @Description:
 */
@Log4j
public class TestZk {

    private Logger logger = LoggerFactory.getLogger(TestZk.class);
    private ZooKeeper zk;
    private String parentDir = "/serverName";
    private String childDir1 = "/127.0.0.1:8081";
    private String childDir2 = "/127.0.0.1:8081";
    private String childDir3 = "/127.0.0.1:8081";


    public  void  initZk() throws IOException {
          System.out.println( "开始创建连接" );
        zk = new ZooKeeper("127.0.0.1:2181", 60 * 100000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("触发了 "+watchedEvent.getType()+" 事件");
            }
        });
    }

    public void getDirData() throws InterruptedException, KeeperException {
        int count = 100;

        int b = 0;
        int c = 0;
        int d = 0;

        String parentDir = "/serverName";

        List<String> childDir = zk.getChildren(parentDir, true);
        for(int i = 0; i < count; i++) {
            int temp = i % 3;
            switch(temp) {
                case 0:
                    b++;
                    break;
                case 1:
                    c++;
                    break;
                case 2:
                    d++;
                    break;
                default:
                    break;
            }
            logger.info("you get {}th child Node: {} ",
                        new Object[]{temp,childDir.get(temp)});
            Thread.sleep(100);
        }
        logger.info("the b = {} the c ={} the d ={} ",
                    new Object[]{ b,c,d } );
        String string = new String(zk.getData(parentDir, false, null));

        logger.info("the search node is : {} ", string);
    }

    public void createData() throws KeeperException, InterruptedException {

        //创建父子节点
        zk.create(parentDir, "test".getBytes(),
                  Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        zk.create(parentDir + childDir1, null,
                  Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(parentDir + childDir2, null,
                  Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(parentDir + childDir3, null,
                  Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        List<String> childDir = zk.getChildren(parentDir, true);

        logger.info("the {}  child dir is :{} ",
                    new Object[]{ parentDir,childDir });

        byte[] object = zk.getData(parentDir, false, null);

        if(object != null) {
            String string = new String(object);
            logger.info("you had created an node ,it is :{} ={} ",
                        new Object[]{ parentDir,string });
        } else {
            logger.info("the dir: {} is null", parentDir);
        }

    }

    /**
     * 删除创建的父子节点
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void delete() throws InterruptedException, KeeperException {
        if(zk.exists(parentDir + childDir1, false) != null) {
            zk.delete(parentDir + childDir1, -1);
        }
        if(zk.exists(parentDir + childDir2, false) != null) {
            zk.delete(parentDir + childDir2, -1);
        }
        if(zk.exists(parentDir + childDir3, false) != null) {
            zk.delete(parentDir + childDir3, -1);
        }
        if(zk.exists(parentDir, false) != null) {
            zk.delete(parentDir, -1);
        }

        logger.info("you have deleted the node : {} ", parentDir);
    }

    public static void main(String[] args) throws IOException,
            KeeperException, InterruptedException {
        // 创建一个与服务器的连接
        TestZk demo = new TestZk();
        demo.initZk();
        Thread.sleep(3000);
        //如果创建的节点已经存在，就先删除
        demo.delete();

        demo.createData();

        //均匀获得子目录节点信息
        demo.getDirData();

        //删除创建的新节点
//        demo.delete();
    }



}
