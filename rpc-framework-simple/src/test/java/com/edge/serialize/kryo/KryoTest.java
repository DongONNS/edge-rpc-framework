package com.edge.serialize.kryo;


import com.edge.remote.dto.RpcRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

public class KryoTest {

    private KryoSerializer kryoSerializer;

    @BeforeEach
    public void init(){
        kryoSerializer = new KryoSerializer();
    }

    @Test
    public void testSerialize(){
        Person person = new Person();
        person.setName("edge");
        person.setAge(25);
        person.setAddress("beijing");

        byte[] serialize = kryoSerializer.serialize(person);
        System.out.println("kryo序列化的结果为：" + Arrays.toString(serialize));
    }

    @Test
    public void testDeserialize(){
        byte[] source = new byte[]{1, 1, 98, 101, 105, 106, 105, 110, -25, 1, 50, 1, 101, 100, 103, -27};
        Person deserialize = kryoSerializer.deserialize(source, Person.class);
        System.out.println(deserialize.toString());
    }

    @Test
    public void kryoSerializerTest(){
        // 构建RPC请求
        RpcRequest target = RpcRequest.builder()
                .methodName("edge")
                .parameters(new Object[]{"hello edge", "hello kryo"})
                .paramTypes(new Class<?>[]{String.class, String.class})
                .requestId(UUID.randomUUID().toString())
                .group("group1")
                .version("version1")
                .build();

        // 反序列化
        byte[] binarySource = kryoSerializer.serialize(target);
        RpcRequest rpcRequestDecode = kryoSerializer.deserialize(binarySource, RpcRequest.class);

        // 断言
        assert target.getGroup().equals(rpcRequestDecode.getGroup());
        assert target.getVersion().equals(rpcRequestDecode.getVersion());
        assert target.getRequestId().equals(rpcRequestDecode.getRequestId());
        assert target.getMethodName().equals(rpcRequestDecode.getMethodName());
    }

    @AfterEach
    private void destroy(){
        // help GC
        kryoSerializer = null;
    }
}
