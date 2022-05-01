package com.edge.remote.dto;

import com.edge.entity.RpcServiceProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RpcRequest implements Serializable {
    // 序列化号，对于序列化器的版本控制必不可少
    private static final long serialVersionUID = 1905122041950251207L;

    private String requestId;
    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] paramTypes;
    private String version;
    private String group;

    public RpcServiceProperties toRpcProperties(){
        return RpcServiceProperties.builder()
                .serviceName(this.getInterfaceName())
                .version(this.getVersion())
                .group(this.getGroup())
                .build();
    }
}
