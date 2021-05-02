package com.edge.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum RpcResponseCodeEnum {
    SUCCESS(10000,"服务远程调用成功"),
    FAILED(100001,"服务远程调用失败");

    private final Integer code;
    private final String message;
}
