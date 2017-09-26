package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/11 13:19
 */

public class vulcanizeBean {


    /**
     * list : [{"BBARCODE":"D7E1B50643","BLADDERCODE":"JBR20-05","CREW":"甲","CURECODE":"CURE0061","CUREOPERATOR1":"102","CURETIME":41.6,"FLAG":"硫化正常","MACHINEID":"G06","MOLDNO":"12R22.5CM187552","PROCESSNO":"RTN-17-33-66-01","PRODUCTNUMBER":"12R22.5-18PR-CM187","SHIFT":"晚","WEIGHTSTD":65.116,"YYYYMMDD":"20170411","YYYYMMDD203":"20170412020048"}]
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
         * BBARCODE : D7E1B50643
         * BLADDERCODE : JBR20-05
         * CREW : 甲
         * CURECODE : CURE0061
         * CUREOPERATOR1 : 102
         * CURETIME : 41.6
         * FLAG : 硫化正常
         * MACHINEID : G06
         * MOLDNO : 12R22.5CM187552
         * PROCESSNO : RTN-17-33-66-01
         * PRODUCTNUMBER : 12R22.5-18PR-CM187
         * SHIFT : 晚
         * WEIGHTSTD : 65.116
         * YYYYMMDD : 20170411
         * YYYYMMDD203 : 20170412020048
         */

        private String BBARCODE;
        private String BLADDERCODE;
        private String CREW;
        private String CURECODE;
        private String CUREOPERATOR1;
        private double CURETIME;
        private String FLAG;
        private String MACHINEID;
        private String MOLDNO;
        private String PROCESSNO;
        private String PRODUCTNUMBER;
        private String SHIFT;
        private double WEIGHTSTD;
        private String YYYYMMDD;
        private String YYYYMMDD203;

        public String getBBARCODE() {
            return BBARCODE;
        }

        public void setBBARCODE(String BBARCODE) {
            this.BBARCODE = BBARCODE;
        }

        public String getBLADDERCODE() {
            return BLADDERCODE;
        }

        public void setBLADDERCODE(String BLADDERCODE) {
            this.BLADDERCODE = BLADDERCODE;
        }

        public String getCREW() {
            return CREW;
        }

        public void setCREW(String CREW) {
            this.CREW = CREW;
        }

        public String getCURECODE() {
            return CURECODE;
        }

        public void setCURECODE(String CURECODE) {
            this.CURECODE = CURECODE;
        }

        public String getCUREOPERATOR1() {
            return CUREOPERATOR1;
        }

        public void setCUREOPERATOR1(String CUREOPERATOR1) {
            this.CUREOPERATOR1 = CUREOPERATOR1;
        }

        public double getCURETIME() {
            return CURETIME;
        }

        public void setCURETIME(double CURETIME) {
            this.CURETIME = CURETIME;
        }

        public String getFLAG() {
            return FLAG;
        }

        public void setFLAG(String FLAG) {
            this.FLAG = FLAG;
        }

        public String getMACHINEID() {
            return MACHINEID;
        }

        public void setMACHINEID(String MACHINEID) {
            this.MACHINEID = MACHINEID;
        }

        public String getMOLDNO() {
            return MOLDNO;
        }

        public void setMOLDNO(String MOLDNO) {
            this.MOLDNO = MOLDNO;
        }

        public String getPROCESSNO() {
            return PROCESSNO;
        }

        public void setPROCESSNO(String PROCESSNO) {
            this.PROCESSNO = PROCESSNO;
        }

        public String getPRODUCTNUMBER() {
            return PRODUCTNUMBER;
        }

        public void setPRODUCTNUMBER(String PRODUCTNUMBER) {
            this.PRODUCTNUMBER = PRODUCTNUMBER;
        }

        public String getSHIFT() {
            return SHIFT;
        }

        public void setSHIFT(String SHIFT) {
            this.SHIFT = SHIFT;
        }

        public double getWEIGHTSTD() {
            return WEIGHTSTD;
        }

        public void setWEIGHTSTD(double WEIGHTSTD) {
            this.WEIGHTSTD = WEIGHTSTD;
        }

        public String getYYYYMMDD() {
            return YYYYMMDD;
        }

        public void setYYYYMMDD(String YYYYMMDD) {
            this.YYYYMMDD = YYYYMMDD;
        }

        public String getYYYYMMDD203() {
            return YYYYMMDD203;
        }

        public void setYYYYMMDD203(String YYYYMMDD203) {
            this.YYYYMMDD203 = YYYYMMDD203;
        }
    }
}
