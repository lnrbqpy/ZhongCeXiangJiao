package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/19 9:29
 */

public class shujukaBean {

    /**
     * list : [{"HTMLURL":"http://171.188.42.56:8081/app/html/gumInfo.html"}]
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
         * HTMLURL : http://171.188.42.56:8081/app/html/gumInfo.html
         */

        private String HTMLURL;

        public String getHTMLURL() {
            return HTMLURL;
        }

        public void setHTMLURL(String HTMLURL) {
            this.HTMLURL = HTMLURL;
        }
    }
}
