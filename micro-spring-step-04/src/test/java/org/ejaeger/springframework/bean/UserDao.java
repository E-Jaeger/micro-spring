package org.ejaeger.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "胡桃");
        hashMap.put("10002", "行秋");
        hashMap.put("10003", "钟离");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}