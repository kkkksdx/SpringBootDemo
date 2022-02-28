package com.demo.common;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private int code;

    private Map<String,Object> extend=new HashMap<String, Object>();
    //处理成功
    public static Msg success(){
        Msg result=new Msg();
        result.setCode(100);
        return result;
    }
    //失败
    public static Msg fail(){
        Msg result=new Msg();
        result.setCode(200);
        return result;
    }
    //返回json数据
    public Msg add(String key,Object value){
        this.getExtend().put(key, value);
        return this;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
