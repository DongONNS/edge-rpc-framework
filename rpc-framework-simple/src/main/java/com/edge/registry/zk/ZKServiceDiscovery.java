package com.edge.registry.zk;

import com.edge.enums.RpcErrorMessageEnum;
import com.edge.exception.RpcException;
import com.edge.extension.ExtensionLoader;
import com.edge.loadbalance.LoadBalance;
import com.edge.registry.ServiceDiscovery;
import com.edge.registry.zk.util.CuratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;
import java.util.List;

@Slf4j
public class ZKServiceDiscovery implements ServiceDiscovery {

    private final LoadBalance loadBalance;

    public ZKServiceDiscovery() {
        this.loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
    }

    /**
     * 查找指定rpc服务名的service。
     *
     * @param rpcServiceName rpc服务名
     * @return 指定服务名的服务地址
     */
    @Override
    public InetSocketAddress lookupService(final String rpcServiceName) {
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, rpcServiceName);
        if (serviceUrlList == null || serviceUrlList.size() == 0) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND, rpcServiceName);
        }

        // 负载均衡
        String targetServiceUrl = loadBalance.selectServerAddress(serviceUrlList, rpcServiceName);
        log.info("successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);
    }
}
