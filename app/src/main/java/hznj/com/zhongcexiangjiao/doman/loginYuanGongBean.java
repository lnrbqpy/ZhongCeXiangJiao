package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2017/9/12
 * Company    : 杭州能匠
 * Author     : 张新伟
 * Date       : 2017/9/12 13:54
 */

public class loginYuanGongBean {

    /**
     * list : [{"PERSONNELCODE":"J1204","PERSONNELNAME":"何良军"}]
     * msg : 请求成功
     * result : 1
     */

    private String msg;
    private String         result;
    private List<ListBean> list;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * PERSONNELCODE : J1204
         * PERSONNELNAME : 何良军
         */

        private String PERSONNELCODE;
        private String PERSONNELNAME;

        public String getPERSONNELCODE() {
            return PERSONNELCODE;
        }

        public void setPERSONNELCODE(String PERSONNELCODE) {
            this.PERSONNELCODE = PERSONNELCODE;
        }

        public String getPERSONNELNAME() {
            return PERSONNELNAME;
        }

        public void setPERSONNELNAME(String PERSONNELNAME) {
            this.PERSONNELNAME = PERSONNELNAME;
        }
    }
}
