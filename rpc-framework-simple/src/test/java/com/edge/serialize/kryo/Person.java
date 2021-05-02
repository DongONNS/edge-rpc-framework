package com.edge.serialize.kryo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {
    private Integer age;
    private String name;
    private String address;
}
