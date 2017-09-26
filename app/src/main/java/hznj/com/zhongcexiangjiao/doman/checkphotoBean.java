package hznj.com.zhongcexiangjiao.doman;

import java.util.List;



public class checkphotoBean {

    /**
     * list : [{"PICURL":"http://171.188.42.56:8081/app/SafeImage/picture/CJ-07_20170727102354_0.png"},{"PICURL":"http://171.188.42.56:8081/app/SafeImage/picture/CJ-07_20170727102409_0.png"},{"PICURL":"http://171.188.42.56:8081/app/SafeImage/picture/CJ-07_20170727102423_0.png"}]
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
         * PICURL : http://171.188.42.56:8081/app/SafeImage/picture/CJ-07_20170727102354_0.png
         */

        private String PICURL;

        public String getPICURL() {
            return PICURL;
        }

        public void setPICURL(String PICURL) {
            this.PICURL = PICURL;
        }
    }
}
