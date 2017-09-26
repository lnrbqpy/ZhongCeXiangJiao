package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/11 13:32
 */

public class moldingBean {

    /**
     * list : [{"YYYYMMDD":"20170411","SHIFT":"晚","CREW":"甲","MACHINEID":"E01","DATETIMEPRODUCED":"20170412071102","PROCESSNO":"RTN-17-33-66-01","VERIFYRESULT":"合格","OPERATOR1":"4433505","PRODUCTNUMBER":"12R22.5-18PR-CM187--金系"}]
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
         * YYYYMMDD : 20170411
         * SHIFT : 晚
         * CREW : 甲
         * MACHINEID : E01
         * DATETIMEPRODUCED : 20170412071102
         * PROCESSNO : RTN-17-33-66-01
         * VERIFYRESULT : 合格
         * OPERATOR1 : 4433505
         * PRODUCTNUMBER : 12R22.5-18PR-CM187--金系
         */

        private String YYYYMMDD;
        private String SHIFT;
        private String CREW;
        private String MACHINEID;
        private String DATETIMEPRODUCED;
        private String PROCESSNO;
        private String VERIFYRESULT;
        private String OPERATOR1;
        private String PRODUCTNUMBER;

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

        public String getPRODUCTNUMBER() {
            return PRODUCTNUMBER;
        }

        public void setPRODUCTNUMBER(String PRODUCTNUMBER) {
            this.PRODUCTNUMBER = PRODUCTNUMBER;
        }
    }
}
