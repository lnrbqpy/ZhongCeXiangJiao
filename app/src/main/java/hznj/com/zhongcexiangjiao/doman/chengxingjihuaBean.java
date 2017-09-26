package hznj.com.zhongcexiangjiao.doman;


import java.util.List;

public class chengxingjihuaBean {


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
         * YYYYMMDD : 20170615
         * SHIFT : 早班
         * MACHINEID : E04
         * PRODUCTIONCODE : A5DP3B2A_RTN173375
         * LOTNUMBER : 1
         * GTCODE : RTN-17-33-75-02
         * ERPCODE : 12R22.5-18PR-AZ375--朝系
         * SCHEDULEDATETIME : 20170615152846
         * AMOUNTCARTSHIFT : 25
         * BUILDINGLOT : 4
         * BUILDINGORDERSHIFT : 100
         * STATUSFLAG : 完成
         * BUILDINGACTUAL : 59
         * STARTDATE : 20170615152120
         * ENDDATE : 20170615152121
         */

        private String YYYYMMDD;
        private String SHIFT;
        private String MACHINEID;
        private String PRODUCTIONCODE;
        private int    LOTNUMBER;
        private String GTCODE;
        private String ERPCODE;
        private String SCHEDULEDATETIME;
        private int    AMOUNTCARTSHIFT;
        private int    BUILDINGLOT;
        private int    BUILDINGORDERSHIFT;
        private String STATUSFLAG;
        private int    BUILDINGACTUAL;
        private String STARTDATE;
        private String ENDDATE;

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

        public String getMACHINEID() {
            return MACHINEID;
        }

        public void setMACHINEID(String MACHINEID) {
            this.MACHINEID = MACHINEID;
        }

        public String getPRODUCTIONCODE() {
            return PRODUCTIONCODE;
        }

        public void setPRODUCTIONCODE(String PRODUCTIONCODE) {
            this.PRODUCTIONCODE = PRODUCTIONCODE;
        }

        public int getLOTNUMBER() {
            return LOTNUMBER;
        }

        public void setLOTNUMBER(int LOTNUMBER) {
            this.LOTNUMBER = LOTNUMBER;
        }

        public String getGTCODE() {
            return GTCODE;
        }

        public void setGTCODE(String GTCODE) {
            this.GTCODE = GTCODE;
        }

        public String getERPCODE() {
            return ERPCODE;
        }

        public void setERPCODE(String ERPCODE) {
            this.ERPCODE = ERPCODE;
        }

        public String getSCHEDULEDATETIME() {
            return SCHEDULEDATETIME;
        }

        public void setSCHEDULEDATETIME(String SCHEDULEDATETIME) {
            this.SCHEDULEDATETIME = SCHEDULEDATETIME;
        }

        public int getAMOUNTCARTSHIFT() {
            return AMOUNTCARTSHIFT;
        }

        public void setAMOUNTCARTSHIFT(int AMOUNTCARTSHIFT) {
            this.AMOUNTCARTSHIFT = AMOUNTCARTSHIFT;
        }

        public int getBUILDINGLOT() {
            return BUILDINGLOT;
        }

        public void setBUILDINGLOT(int BUILDINGLOT) {
            this.BUILDINGLOT = BUILDINGLOT;
        }

        public int getBUILDINGORDERSHIFT() {
            return BUILDINGORDERSHIFT;
        }

        public void setBUILDINGORDERSHIFT(int BUILDINGORDERSHIFT) {
            this.BUILDINGORDERSHIFT = BUILDINGORDERSHIFT;
        }

        public String getSTATUSFLAG() {
            return STATUSFLAG;
        }

        public void setSTATUSFLAG(String STATUSFLAG) {
            this.STATUSFLAG = STATUSFLAG;
        }

        public int getBUILDINGACTUAL() {
            return BUILDINGACTUAL;
        }

        public void setBUILDINGACTUAL(int BUILDINGACTUAL) {
            this.BUILDINGACTUAL = BUILDINGACTUAL;
        }

        public String getSTARTDATE() {
            return STARTDATE;
        }

        public void setSTARTDATE(String STARTDATE) {
            this.STARTDATE = STARTDATE;
        }

        public String getENDDATE() {
            return ENDDATE;
        }

        public void setENDDATE(String ENDDATE) {
            this.ENDDATE = ENDDATE;
        }
    }
}
