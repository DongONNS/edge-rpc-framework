package com.edge.registry.zk;

import com.edge.registry.ServiceRegistry;
import com.edge.registry.zk.util.CuratorUtils;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;

/**
 * 基于zookeeper实现服务注册功能.
 */
public class ZKServiceRegistry implements ServiceRegistry {

    /**
     * 注册rpc服务到zk.
     *
     * @param rpcServiceName rpc服务名
     * @param socketAddress 服务地址
     */
    @Override
    public void registerService(final String rpcServiceName, final InetSocketAddress socketAddress) {
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + socketAddress.toString();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        CuratorUtils.createPersistentNode(zkClient, servicePath);
    }
}
