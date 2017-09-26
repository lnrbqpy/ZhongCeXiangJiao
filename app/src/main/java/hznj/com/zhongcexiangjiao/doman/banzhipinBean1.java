package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/13 13:18
 */

public class banzhipinBean1 {

    /**
     * list : [{"BARCODE":"C7F4A51446","YYYYMMDD":"20170322","SHIFT":"晚班","CREW":"丙","MACHINEID":"F04","DATETIMEPRODUCED":"2017/03/23 07:09:46","PROCESSNO":"RTW-16-08-18-01","VERIFYRESULT":"合格","OPERATOR1":"3353219","OPERATOR2":"4034776","PRODUCTIONCODE":"12.00R24-18PR-CB972-GOODRIDE(好运)-出口"}]
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
         * BARCODE : C7F4A51446
         * YYYYMMDD : 20170322
         * SHIFT : 晚班
         * CREW : 丙
         * MACHINEID : F04
         * DATETIMEPRODUCED : 2017/03/23 07:09:46
         * PROCESSNO : RTW-16-08-18-01
         * VERIFYRESULT : 合格
         * OPERATOR1 : 3353219
         * OPERATOR2 : 4034776
         * PRODUCTIONCODE : 12.00R24-18PR-CB972-GOODRIDE(好运)-出口
         */

        private String BARCODE;
        private String YYYYMMDD;
        private String SHIFT;
        private String CREW;
        private String MACHINEID;
        private String DATETIMEPRODUCED;
        private String PROCESSNO;
        private String VERIFYRESULT;
        private String OPERATOR1;
        private String OPERATOR2;
        private String PRODUCTIONCODE;

        public String getBARCODE() {
            return BARCODE;
        }

        public void setBARCODE(String BARCODE) {
            this.BARCODE = BARCODE;
        }

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

        public String getOPERATOR2() {
            return OPERATOR2;
        }

        public void setOPERATOR2(String OPERATOR2) {
            this.OPERATOR2 = OPERATOR2;
        }

        public String getPRODUCTIONCODE() {
            return PRODUCTIONCODE;
        }

        public void setPRODUCTIONCODE(String PRODUCTIONCODE) {
            this.PRODUCTIONCODE = PRODUCTIONCODE;
        }
    }
}
