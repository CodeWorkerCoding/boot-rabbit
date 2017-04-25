package com.nchu.tech.mq.module;

import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONObject;

/**
 * 对象
 * Created by fujianjian on 2017/4/25.
 */
@Getter@Setter
public class Person {

    private String id;

    private String name;

    private String gender;

    private Integer age;

    private String liverAddr;

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}
