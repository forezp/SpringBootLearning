package io.github.forezp.springbootzkdemo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkTest {

    private static final String address = "127.0.0.1:2181";
    private static final int session_timeout = 5000;
    private static final CountDownLatch cout = new CountDownLatch(1);
    private  static Stat stat=new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper(address, session_timeout, new Watcher() {
            // 事件通知
            @Override
            public void process(WatchedEvent event) {
                // 事件状态
                Event.KeeperState state = event.getState();
                // 连接状态
                if (Event.KeeperState.SyncConnected == state) {
                    Event.EventType type = event.getType();
                    // 事件类型
                    if (Event.EventType.None == type) {
                        cout.countDown();
                        System.out.println("--------zk开始连接.");
                    }
                }
            }
        });

        cout.await();
        //创建节点
        String path="/test";
        String create = zk.create(path, "fzp".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("-------创建节点： " + create);
        System.out.println(new String(zk.getData(path,true,stat)));
        System.out.println(stat.getCzxid()+","+ stat.getMzxid()+","+stat.getVersion());
        zk.setData(path,"123".getBytes(),-1);
        zk.close();

    }

}
