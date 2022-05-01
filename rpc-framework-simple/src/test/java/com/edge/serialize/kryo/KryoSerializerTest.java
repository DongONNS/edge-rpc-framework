package com.edge.serialize.kryo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongcheng_2018@163.com
 * @date 2022/5/1 22:18
 */
class KryoSerializerTest {

    @Test
    void kryoSerializerTest() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");
        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] bytes = kryoSerializer.serialize(map);
        Map actual = kryoSerializer.deserialize(bytes, HashMap.class);
        Assert.assertEquals("world", actual.get("hello"));
    }
}