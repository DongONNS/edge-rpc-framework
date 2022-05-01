package com.edge.zkExample;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class zkCli {
    private static final int BASE_SLEEP_TIME = 1000;
    private static final int MAX_RETRIES = 3;


    public static void main(String[] args) throws Exception {
        // Retry strategy. Retry 3 times, and will increase the sleep time between retries.
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME, MAX_RETRIES);

        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                // the server to connect to (can be a server list)
                .connectString("192.168.160.129:2181")
                .retryPolicy(retryPolicy)
                .build();
        zkClient.start();

        //创建指定类型的节点
//        zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/node1/00001");

        // 检查节点的创建状态
        Stat stat = zkClient.checkExists().forPath("/node1/00001");
        System.out.println("节点状态" + stat);

        // 删除指定位置的节点
        zkClient.delete().forPath("/node1/00001");

        // 创建指定节点内容的节点并获取节点内容
        zkClient.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/node1/00001","java".getBytes());
        byte[] data = zkClient.getData().forPath("/node1/00001");//获取节点的数据内容，获取到的是 byte数组
        System.out.println(data);

        // 更新节点内容
        zkClient.setData().forPath("/node1/00001","c++".getBytes());//更新节点数据内容
    }


}
