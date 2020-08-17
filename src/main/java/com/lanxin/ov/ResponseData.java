package com.lanxin.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //全参构造方法
public class ResponseData {
    private  String code; //响应码
    private  String msg;  //消息
    private  Object data;  //数据

    public ResponseData(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
