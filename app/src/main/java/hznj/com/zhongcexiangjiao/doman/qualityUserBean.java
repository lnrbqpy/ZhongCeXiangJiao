package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2017/9/14
 * Company    : 杭州能匠
 * Author     : 张新伟
 * Date       : 2017/9/14 20:21
 */

public class qualityUserBean {


    /**
     * list : [{"DUMMY":"X"}]
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
         * DUMMY : X
         */

        private String DUMMY;

        public String getDUMMY() {
            return DUMMY;
        }

        public void setDUMMY(String DUMMY) {
            this.DUMMY = DUMMY;
        }
    }
}
