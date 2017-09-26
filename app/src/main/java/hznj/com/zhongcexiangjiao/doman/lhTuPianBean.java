package hznj.com.zhongcexiangjiao.doman;


import java.util.List;

public class lhTuPianBean {


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
         * ASPXURL : http://171.188.42.56:8081/app/models/cureGraph.aspx
         */

        private String ASPXURL;

        public String getASPXURL() {
            return ASPXURL;
        }

        public void setASPXURL(String ASPXURL) {
            this.ASPXURL = ASPXURL;
        }
    }
}
