package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2017/9/13
 * Company    : 杭州能匠
 * Author     : 张新伟
 * Date       : 2017/9/13 15:16
 */

public class querenhuawenBean {


    /**
     * list : [{"PATTERN":"CB995A"}]
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
         * PATTERN : CB995A
         */

        private String PATTERN;

        public String getPATTERN() {
            return PATTERN;
        }

        public void setPATTERN(String PATTERN) {
            this.PATTERN = PATTERN;
        }
    }
}
