package com.edge.serialize;

/**
 * @author dongcheng_2018@163.com
 * @date 2022/5/1 12:51
 */
public interface Serializer {
    /**
     * 序列化.
     *
     * @param object 待序列化的对象
     * @return 字节数组
     */
    byte[] serialize(Object object);

    /**
     * 反序列化.
     *
     * @param bytes 字节数组
     * @param clazz 目标类型
     * @param <T> class类的类型
     * @return 反序列化的对象
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz);
}
