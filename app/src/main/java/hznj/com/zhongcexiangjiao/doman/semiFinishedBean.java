package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/11 13:33
 */

public class semiFinishedBean {


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
         * DATESHIFT : 20170411
         * MACHINEID : B03
         * DATESHIFT1 : 中班
         * CREW : 丁
         * VERIFYRESULT : 合格
         * PARTID : TM
         * PARTNUMBER : TM17336601R
         * DATACHR : A011/EA108
         * THICKNESS : 21±0.8/22.5±0.8
         * WIDTH : 252±5
         * LENGTH : 3250±10
         * KXCODE : KB233251-187-1
         * PARTINVEND : RTN-17-33-66-01
         * BARCODE : A00TM1704112004501704162004501TM17336601R
         * VIRTUALCARTNUMBER : A00A5DE6C0C_RTN173366TMTM17336601R1704112001001
         */

        private String DATESHIFT;
        private String MACHINEID;
        private String DATESHIFT1;
        private String CREW;
        private String VERIFYRESULT;
        private String PARTID;
        private String PARTNUMBER;
        private String DATACHR;
        private String THICKNESS;
        private String WIDTH;
        private String LENGTH;
        private String KXCODE;
        private String PARTINVEND;
        private String BARCODE;
        private String VIRTUALCARTNUMBER;

        public String getDATESHIFT() {
            return DATESHIFT;
        }

        public void setDATESHIFT(String DATESHIFT) {
            this.DATESHIFT = DATESHIFT;
        }

        public String getMACHINEID() {
            return MACHINEID;
        }

        public void setMACHINEID(String MACHINEID) {
            this.MACHINEID = MACHINEID;
        }

        public String getDATESHIFT1() {
            return DATESHIFT1;
        }

        public void setDATESHIFT1(String DATESHIFT1) {
            this.DATESHIFT1 = DATESHIFT1;
        }

        public String getCREW() {
            return CREW;
        }

        public void setCREW(String CREW) {
            this.CREW = CREW;
        }

        public String getVERIFYRESULT() {
            return VERIFYRESULT;
        }

        public void setVERIFYRESULT(String VERIFYRESULT) {
            this.VERIFYRESULT = VERIFYRESULT;
        }

        public String getPARTID() {
            return PARTID;
        }

        public void setPARTID(String PARTID) {
            this.PARTID = PARTID;
        }

        public String getPARTNUMBER() {
            return PARTNUMBER;
        }

        public void setPARTNUMBER(String PARTNUMBER) {
            this.PARTNUMBER = PARTNUMBER;
        }

        public String getDATACHR() {
            return DATACHR;
        }

        public void setDATACHR(String DATACHR) {
            this.DATACHR = DATACHR;
        }

        public String getTHICKNESS() {
            return THICKNESS;
        }

        public void setTHICKNESS(String THICKNESS) {
            this.THICKNESS = THICKNESS;
        }

        public String getWIDTH() {
            return WIDTH;
        }

        public void setWIDTH(String WIDTH) {
            this.WIDTH = WIDTH;
        }

        public String getLENGTH() {
            return LENGTH;
        }

        public void setLENGTH(String LENGTH) {
            this.LENGTH = LENGTH;
        }

        public String getKXCODE() {
            return KXCODE;
        }

        public void setKXCODE(String KXCODE) {
            this.KXCODE = KXCODE;
        }

        public String getPARTINVEND() {
            return PARTINVEND;
        }

        public void setPARTINVEND(String PARTINVEND) {
            this.PARTINVEND = PARTINVEND;
        }

        public String getBARCODE() {
            return BARCODE;
        }

        public void setBARCODE(String BARCODE) {
            this.BARCODE = BARCODE;
        }

        public String getVIRTUALCARTNUMBER() {
            return VIRTUALCARTNUMBER;
        }

        public void setVIRTUALCARTNUMBER(String VIRTUALCARTNUMBER) {
            this.VIRTUALCARTNUMBER = VIRTUALCARTNUMBER;
        }
    }
}
