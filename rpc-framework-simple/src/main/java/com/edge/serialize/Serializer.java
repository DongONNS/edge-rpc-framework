package com.edge.serialize;

/**
 * 定义序列化接口规范
 *
 */
public interface Serializer {
    /**
     * 序列化
     * @param object 待序列化的对象
     * @return 字节数组
     */
    byte[] serialize(Object object);

    /**
     * 反序列化
     * @param bytes 字节数组
     * @param clazz 目标类
     * @param <T> 类的类型 eg.{@code String.class}的类型是{@code Class<String>}
     * @return 反序列化的对象
     */
    <T> T deserialize(byte[] bytes,Class<T> clazz);
}
