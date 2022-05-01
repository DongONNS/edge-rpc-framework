package com.edge.exception;

import com.edge.enums.RpcErrorMessageEnum;

/**
 * 自定义RpcException.
 */
public class RpcException extends RuntimeException {
    /**
     * Rpc异常构造器
     *
     * @param rpcErrorMessageEnum Rpc异常枚举值
     * @param detail 异常详细信息
     */
    public RpcException(final RpcErrorMessageEnum rpcErrorMessageEnum, final String detail) {
        super(rpcErrorMessageEnum.getMessage() + ":" + detail);
    }
}
