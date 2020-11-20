package com.yishudan.bills.common;

import lombok.Data;

/**
 * @description:
 * @author: Stunievi
 * @time: 2020/11/20 16:43
 */
@Data
public class Result {
    /**
     * 错误信息
     */
    private String errMessage;
    /**
     * 是否成功
     */
    private boolean success = true;
    /**
     * 返回数据
     */
    private Object data;

    /**
     * 成功
     * @param data
     * @return
     */
    public Result success(Object data){
        this.setData(data);
        this.setSuccess(true);
        this.setErrMessage("");
        return this;
    }

    /**
     * 失败
     * @param errMessage
     * @return
     */
    public Result failure(String errMessage){
        this.setData("");
        this.setSuccess(false);
        this.setErrMessage(errMessage);
        return this;
    }

}
