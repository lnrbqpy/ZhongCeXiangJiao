package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

public class zhongliangBean {


    private String         msg;
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
         * TIMEPRODUCED : 235748
         * MACHINENAME : 2#称重机
         * WEIGHT : 55.72
         * WEIGHTSTD : 0
         * BBARCODE : C7F4C52196
         * CBARCODE : null
         * RESULT : 非正品
         * ERPNAME : null
         * PROCESSNO : null
         */

        private String DATEPRODUCED;
        private String TIMEPRODUCED;
        private String MACHINENAME;
        private double WEIGHT;
        private double WEIGHTSTD;
        private String BBARCODE;
        private Object CBARCODE;
        private String RESULT;
        private Object ERPNAME;
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

        public double getWEIGHT() {
            return WEIGHT;
        }

        public void setWEIGHT(double WEIGHT) {
            this.WEIGHT = WEIGHT;
        }

        public double getWEIGHTSTD() {
            return WEIGHTSTD;
        }

        public void setWEIGHTSTD(double WEIGHTSTD) {
            this.WEIGHTSTD = WEIGHTSTD;
        }

        public String getBBARCODE() {
            return BBARCODE;
        }

        public void setBBARCODE(String BBARCODE) {
            this.BBARCODE = BBARCODE;
        }

        public Object getCBARCODE() {
            return CBARCODE;
        }

        public void setCBARCODE(Object CBARCODE) {
            this.CBARCODE = CBARCODE;
        }

        public String getRESULT() {
            return RESULT;
        }

        public void setRESULT(String RESULT) {
            this.RESULT = RESULT;
        }

        public Object getERPNAME() {
            return ERPNAME;
        }

        public void setERPNAME(Object ERPNAME) {
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
