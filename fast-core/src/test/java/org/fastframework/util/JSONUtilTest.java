package org.fastframework.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link JSONUtil} 测试用例
 * <p/>
 * Created by bysocket on 16/7/19.
 */
public class JSONUtilTest {

    @Test
    public void testToJSONString() {
        JSONObject jsonObject = new JSONObject(1, "bysocket", 33);
        String jsonStr = JSONUtil.toJSONString(jsonObject);
        Assert.assertEquals("{\"age\":1,\"name\":\"bysocket\",\"id\":33}", jsonStr);
    }

    @Test(expected = RuntimeException.class)
    public void testToJSONStringError() {
        JSONUtil.toJSONString(System.out);
    }

    @Test
    public void testToObject() {
        JSONObject jsonObject = new JSONObject(1, "bysocket", 33);
        String jsonStr = JSONUtil.toJSONString(jsonObject);
        JSONObject resultObject = JSONUtil.toObject(jsonStr, JSONObject.class);
        Assert.assertEquals(jsonObject.toString(), resultObject.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testToObjectError() {
        JSONUtil.toObject("{int:1}", JSONObject.class);
    }
}

class JSONObject {
    int age;
    String name;
    Integer id;

    public JSONObject() {
    }

    public JSONObject(int age, String name, Integer id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JSONObject{" +
            "age=" + age +
            ", name='" + name + '\'' +
            ", id=" + id +
            '}';
    }
}
