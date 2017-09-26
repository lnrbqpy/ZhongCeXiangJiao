package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/10 13:30
 */

public class liuhuaBean {

    /**
     * 8
     *
     * list : [{"DATEPRODUCED":"20170328","TIMEPRODUCED":"033124","MACHINEID":"F01","CREW":"丁","BBARCODE":"C7G2C51893","CBARCODE":"C751327659","FROCK":null,"GTCODE":"12.00R20-20PR[CM998]威狮+S","PROCESSNO":"RTN-16-06-254-04"},{"DATEPRODUCED":"20170328","TIMEPRODUCED":"033124","MACHINEID":"F01","CREW":"丁","BBARCODE":"C7G2C51894","CBARCODE":"C751327658","FROCK":null,"GTCODE":"12.00R20-20PR[CM998]GOODRIDE(好运)+S","PROCESSNO":"RTN-16-06-254-04"},{"DATEPRODUCED":"20170328","TIMEPRODUCED":"004951","MACHINEID":"F01","CREW":"丁","BBARCODE":"C7G2C51886","CBARCODE":"C751327654","FROCK":null,"GTCODE":"12.00R20-20PR[CM998]GOODRIDE(好运)+S","PROCESSNO":"RTN-16-06-254-04"},{"DATEPRODUCED":"20170328","TIMEPRODUCED":"004951","MACHINEID":"F01","CREW":"丁","BBARCODE":"C7G2C51885","CBARCODE":"C751327655","FROCK":null,"GTCODE":"12.00R20-20PR[CM998]威狮+S","PROCESSNO":"RTN-16-06-254-04"},{"DATEPRODUCED":"20170328","TIMEPRODUCED":"034138","MACHINEID":"F01","CREW":"丁","BBARCODE":"C7G2C51870","CBARCODE":"C751327660","FROCK":null,"GTCODE":"12.00R20-20PR[CM998]GOODRIDE(好运)+S","PROCESSNO":"RTN-16-06-254-04"},{"DATEPRODUCED":"20170328","TIMEPRODUCED":"034138","MACHINEID":"F01","CREW":"丁","BBARCODE":"C7G2C51868","CBARCODE":"C751327661","FROCK":null,"GTCODE":"12.00R20-20PR[CM998]威狮+S","PROCESSNO":"RTN-16-06-254-04"},{"DATEPRODUCED":"20170328","TIMEPRODUCED":"015033","MACHINEID":"F01","CREW":"丁","BBARCODE":"C7G2C51892","CBARCODE":"C751327657","FROCK":null,"GTCODE":"12.00R20-20PR[CM998]威狮+S","PROCESSNO":"RTN-16-06-254-04"},{"DATEPRODUCED":"20170328","TIMEPRODUCED":"015033","MACHINEID":"F01","CREW":"丁","BBARCODE":"C7G2C51895","CBARCODE":"C751327656","FROCK":null,"GTCODE":"12.00R20-20PR[CM998]GOODRIDE(好运)+S","PROCESSNO":"RTN-16-06-254-04"}]
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
         * DATEPRODUCED : 20170328  riqi
         * TIMEPRODUCED : 033124     shijian
         * MACHINEID : F01            jitai
         * CREW : 丁                  banzu
         * BBARCODE : C7G2C51893       chengxing
         * CBARCODE : C751327659       liuhua
         * FROCK : null
         * GTCODE : 12.00R20-20PR[CM998]威狮+S    luntai gui ge
         * PROCESSNO : RTN-16-06-254-04     shigong
         */

        private String DATEPRODUCED;
        private String TIMEPRODUCED;
        private String MACHINEID;
        private String CREW;
        private String BBARCODE;
        private String CBARCODE;
        private Object FROCK;
        private String GTCODE;
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

        public String getCBARCODE() {
            return CBARCODE;
        }

        public void setCBARCODE(String CBARCODE) {
            this.CBARCODE = CBARCODE;
        }

        public Object getFROCK() {
            return FROCK;
        }

        public void setFROCK(Object FROCK) {
            this.FROCK = FROCK;
        }

        public String getGTCODE() {
            return GTCODE;
        }

        public void setGTCODE(String GTCODE) {
            this.GTCODE = GTCODE;
        }

        public String getPROCESSNO() {
            return PROCESSNO;
        }

        public void setPROCESSNO(String PROCESSNO) {
            this.PROCESSNO = PROCESSNO;
        }
    }
}
