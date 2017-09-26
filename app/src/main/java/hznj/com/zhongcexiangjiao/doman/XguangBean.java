package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/10 13:31
 */

public class XguangBean {



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
         * TIMEPRODUCED : 003215
         * MACHINENAME : 1#X光机
         * CREW : 甲班
         * BBARCODE : B7F4B50439
         * CBARCODE : B751121744
         * RESULT : 正品
         * ERPNAME : 12.00R24-20PR[CR926B]朝阳
         * PROCESSNO : null
         */

        private String DATEPRODUCED;
        private String TIMEPRODUCED;
        private String MACHINENAME;
        private String CREW;
        private String BBARCODE;
        private String CBARCODE;
        private String RESULT;
        private String ERPNAME;
        private Object PROCESSNO;

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

        public String getMACHINENAME() {
            return MACHINENAME;
        }

        public void setMACHINENAME(String MACHINENAME) {
            this.MACHINENAME = MACHINENAME;
        }

        public String getCREW() {
            return CREW;
        }

        public void setCREW(String CREW) {
            this.CREW = CREW;
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

        public String getRESULT() {
            return RESULT;
        }

        public void setRESULT(String RESULT) {
            this.RESULT = RESULT;
        }

        public String getERPNAME() {
            return ERPNAME;
        }

        public void setERPNAME(String ERPNAME) {
            this.ERPNAME = ERPNAME;
        }

        public Object getPROCESSNO() {
            return PROCESSNO;
        }

        public void setPROCESSNO(Object PROCESSNO) {
            this.PROCESSNO = PROCESSNO;
        }
    }
}
