package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/19 14:40
 */

public class bzpChaXunBean {


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
         * YYYYMMDD : 20170315
         * SHIFT : 早
         * CREW : 丁
         * MACHINEID : G02
         * DATETIMEPRODUCED : 20170315101757
         * PROCESSNO : RTN-16-06-139-05
         * VERIFYRESULT : 合格
         * OPERATOR1 : 4419343
         * OPERATOR2 : null
         * BARCODE : C7G2D50948
         */

        private String YYYYMMDD;
        private String SHIFT;
        private String CREW;
        private String MACHINEID;
        private String DATETIMEPRODUCED;
        private String PROCESSNO;
        private String VERIFYRESULT;
        private String OPERATOR1;
        private Object OPERATOR2;
        private String BARCODE;

        public String getYYYYMMDD() {
            return YYYYMMDD;
        }

        public void setYYYYMMDD(String YYYYMMDD) {
            this.YYYYMMDD = YYYYMMDD;
        }

        public String getSHIFT() {
            return SHIFT;
        }

        public void setSHIFT(String SHIFT) {
            this.SHIFT = SHIFT;
        }

        public String getCREW() {
            return CREW;
        }

        public void setCREW(String CREW) {
            this.CREW = CREW;
        }

        public String getMACHINEID() {
            return MACHINEID;
        }

        public void setMACHINEID(String MACHINEID) {
            this.MACHINEID = MACHINEID;
        }

        public String getDATETIMEPRODUCED() {
            return DATETIMEPRODUCED;
        }

        public void setDATETIMEPRODUCED(String DATETIMEPRODUCED) {
            this.DATETIMEPRODUCED = DATETIMEPRODUCED;
        }

        public String getPROCESSNO() {
            return PROCESSNO;
        }

        public void setPROCESSNO(String PROCESSNO) {
            this.PROCESSNO = PROCESSNO;
        }

        public String getVERIFYRESULT() {
            return VERIFYRESULT;
        }

        public void setVERIFYRESULT(String VERIFYRESULT) {
            this.VERIFYRESULT = VERIFYRESULT;
        }

        public String getOPERATOR1() {
            return OPERATOR1;
        }

        public void setOPERATOR1(String OPERATOR1) {
            this.OPERATOR1 = OPERATOR1;
        }

        public Object getOPERATOR2() {
            return OPERATOR2;
        }

        public void setOPERATOR2(Object OPERATOR2) {
            this.OPERATOR2 = OPERATOR2;
        }

        public String getBARCODE() {
            return BARCODE;
        }

        public void setBARCODE(String BARCODE) {
            this.BARCODE = BARCODE;
        }
    }
}
