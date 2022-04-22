package com.edge.registry;

import java.net.InetSocketAddress;

/**
 * 服务发现
 */
public interface ServiceDiscovery {
    /**
     * 根据服务名查找服务.
     *
     * @param rpcServiceName rpc服务名
     * @return 服务地址
     */
    InetSocketAddress lookupService(String rpcServiceName);
}
