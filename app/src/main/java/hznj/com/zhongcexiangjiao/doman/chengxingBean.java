package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/6 8:53
 */

public class chengxingBean {




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
         * TIMEPRODUCED : 151618
         * MACHINEID : E01
         * CREW : 乙
         * BBARCODE : C7E1D51822
         * CBARCODE : null
         * CARTNUMBER : null
         * ERPCODE : 12.00R20-18PR-CB332--朝系
         * PROCESSNO : RTN-16-06-76-04
         */

        private String DATEPRODUCED;
        private String TIMEPRODUCED;
        private String MACHINEID;
        private String CREW;
        private String BBARCODE;
        private Object CBARCODE;
        private Object CARTNUMBER;
        private String ERPCODE;
        private String PROCESSNO;

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

        public String getMACHINEID() {
            return MACHINEID;
        }

        public void setMACHINEID(String MACHINEID) {
            this.MACHINEID = MACHINEID;
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

        public Object getCBARCODE() {
            return CBARCODE;
        }

        public void setCBARCODE(Object CBARCODE) {
            this.CBARCODE = CBARCODE;
        }

        public Object getCARTNUMBER() {
            return CARTNUMBER;
        }

        public void setCARTNUMBER(Object CARTNUMBER) {
            this.CARTNUMBER = CARTNUMBER;
        }

        public String getERPCODE() {
            return ERPCODE;
        }

        public void setERPCODE(String ERPCODE) {
            this.ERPCODE = ERPCODE;
        }

        public String getPROCESSNO() {
            return PROCESSNO;
        }

        public void setPROCESSNO(String PROCESSNO) {
            this.PROCESSNO = PROCESSNO;
        }
    }
}
