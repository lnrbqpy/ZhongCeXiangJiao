package hznj.com.zhongcexiangjiao.doman;


import java.util.List;

public class loginBean {

    /**
     * list : [{"USERNAME":"姚岚","ROLEID":"7001","ROLENAME":"厂警"}]
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
         * USERNAME : 姚岚
         * ROLEID : 7001
         * ROLENAME : 厂警
         */

        private String USERNAME;
        private String ROLEID;
        private String ROLENAME;

        public String getUSERNAME() {
            return USERNAME;
        }

        public void setUSERNAME(String USERNAME) {
            this.USERNAME = USERNAME;
        }

        public String getROLEID() {
            return ROLEID;
        }

        public void setROLEID(String ROLEID) {
            this.ROLEID = ROLEID;
        }

        public String getROLENAME() {
            return ROLENAME;
        }

        public void setROLENAME(String ROLENAME) {
            this.ROLENAME = ROLENAME;
        }
    }
}
