package com.edge.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class RpcServiceProperties {

    /**
     * 服务名
     */
    private String version;

    /**
     * 当接口有多个实现类时，通过分组进行区分
     */
    private String group;

    private String serviceName;

    private String toRpcServiceName(){
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }

}
