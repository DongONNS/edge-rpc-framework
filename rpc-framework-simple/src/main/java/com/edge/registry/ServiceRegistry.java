package com.edge.registry;

import java.net.InetSocketAddress;

/**
 * 服务注册
 */
public interface ServiceRegistry {

    /**
     * 注册服务.
     *
     * @param rpcServiceName rpc服务名
     * @param socketAddress 服务地址
     */
    void registerService(String rpcServiceName, InetSocketAddress socketAddress);
}
