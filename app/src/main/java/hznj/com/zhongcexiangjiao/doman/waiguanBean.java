package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/10 13:31
 */

public class waiguanBean {

    /**
     * list : [{"DATEPRODUCED":"20170328","TIMEPRODUCED":"02:40:08","SBNAME":"G002","DJNAME":"C级品","GXNAME":"外观检测","BLPNAME":"胎里不平","BBARCODE":"C7G1D52438","CBARCODE":"C7G1D52438"},{"DATEPRODUCED":"20170328","TIMEPRODUCED":"02:39:01","SBNAME":"G002","DJNAME":"C级品","GXNAME":"外观检测","BLPNAME":"胎里不平","BBARCODE":"C7G1D52439","CBARCODE":"C7G1D52439"}]
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
         * DATEPRODUCED : 20170328
         * TIMEPRODUCED : 02:40:08
         * SBNAME : G002
         * DJNAME : C级品
         * GXNAME : 外观检测
         * BLPNAME : 胎里不平
         * BBARCODE : C7G1D52438
         * CBARCODE : C7G1D52438
         */

        private String DATEPRODUCED;
        private String TIMEPRODUCED;
        private String SBNAME;
        private String DJNAME;
        private String GXNAME;
        private String BLPNAME;
        private String BBARCODE;
        private String CBARCODE;

        public String getDATEPRODUCED() {
            return DATEPRODUCED;
        }

        public void setDATEPRODUCED(String DATEPRODUCED) {
            this.DATEPRODUCED = DATEPRODUCED;
        }

        public String getTIMEPRODUCED() {
            return TIMEPRODUCED;
        }

        public void setTIMEPRODUCED(String TIMEPRODUCED) {
            this.TIMEPRODUCED = TIMEPRODUCED;
        }

        public String getSBNAME() {
            return SBNAME;
        }

        public void setSBNAME(String SBNAME) {
            this.SBNAME = SBNAME;
        }

        public String getDJNAME() {
            return DJNAME;
        }

        public void setDJNAME(String DJNAME) {
            this.DJNAME = DJNAME;
        }

        public String getGXNAME() {
            return GXNAME;
        }

        public void setGXNAME(String GXNAME) {
            this.GXNAME = GXNAME;
        }

        public String getBLPNAME() {
            return BLPNAME;
        }

        public void setBLPNAME(String BLPNAME) {
            this.BLPNAME = BLPNAME;
        }

        public String getBBARCODE() {
            return BBARCODE;
        }

        public void setBBARCODE(String BBARCODE) {
            this.BBARCODE = BBARCODE;
        }

        public String getCBARCODE() {
            return CBARCODE;
        }

        public void setCBARCODE(String CBARCODE) {
            this.CBARCODE = CBARCODE;
        }
    }
}
