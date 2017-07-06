package com.wwq.genesislaw.model.json;

/**
 * Created by 魏文强 on 2017/3/2.
 */

public class RequestErrorEntity {

    /**
     * code : NOT_EXISIT
     * msg : 该用户尚未注册
     * status : true
     */

    private String code;
    private String msg;
    private boolean status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
