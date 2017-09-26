package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/6/7 16:27
 */

public class jh_chanliangBean {


    /**
     * list : [{"YEARMONTH":"201706","SIZEID":"11R24.5","REQUIREMENT":16050,"SCHEDULEORDER":7222,"CUREACTUAL":9956,"CURERATIO":62,"CURETIME":41.9,"CURECAPACITY":61.8,"SMACHINENUM":8.9,"AMACHINENUM":8.5,"DIFFMACHIE":-0.4,"CURECAPACITYALL":29}]
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
         * YEARMONTH : 201706
         * SIZEID : 11R24.5
         * REQUIREMENT : 16050
         * SCHEDULEORDER : 7222
         * CUREACTUAL : 9956
         * CURERATIO : 62.0
         * CURETIME : 41.9
         * CURECAPACITY : 61.8
         * SMACHINENUM : 8.9
         * AMACHINENUM : 8.5
         * DIFFMACHIE : -0.4
         * CURECAPACITYALL : 29.0
         */

        private String YEARMONTH;
        private String SIZEID;
        private int    REQUIREMENT;
        private int    SCHEDULEORDER;
        private int    CUREACTUAL;
        private double CURERATIO;
        private double CURETIME;
        private double CURECAPACITY;
        private double SMACHINENUM;
        private double AMACHINENUM;
        private double DIFFMACHIE;
        private double CURECAPACITYALL;

        public String getYEARMONTH() {
            return YEARMONTH;
        }

        public void setYEARMONTH(String YEARMONTH) {
            this.YEARMONTH = YEARMONTH;
        }

        public String getSIZEID() {
            return SIZEID;
        }

        public void setSIZEID(String SIZEID) {
            this.SIZEID = SIZEID;
        }

        public int getREQUIREMENT() {
            return REQUIREMENT;
        }

        public void setREQUIREMENT(int REQUIREMENT) {
            this.REQUIREMENT = REQUIREMENT;
        }

        public int getSCHEDULEORDER() {
            return SCHEDULEORDER;
        }

        public void setSCHEDULEORDER(int SCHEDULEORDER) {
            this.SCHEDULEORDER = SCHEDULEORDER;
        }

        public int getCUREACTUAL() {
            return CUREACTUAL;
        }

        public void setCUREACTUAL(int CUREACTUAL) {
            this.CUREACTUAL = CUREACTUAL;
        }

        public double getCURERATIO() {
            return CURERATIO;
        }

        public void setCURERATIO(double CURERATIO) {
            this.CURERATIO = CURERATIO;
        }

        public double getCURETIME() {
            return CURETIME;
        }

        public void setCURETIME(double CURETIME) {
            this.CURETIME = CURETIME;
        }

        public double getCURECAPACITY() {
            return CURECAPACITY;
        }

        public void setCURECAPACITY(double CURECAPACITY) {
            this.CURECAPACITY = CURECAPACITY;
        }

        public double getSMACHINENUM() {
            return SMACHINENUM;
        }

        public void setSMACHINENUM(double SMACHINENUM) {
            this.SMACHINENUM = SMACHINENUM;
        }

        public double getAMACHINENUM() {
            return AMACHINENUM;
        }

        public void setAMACHINENUM(double AMACHINENUM) {
            this.AMACHINENUM = AMACHINENUM;
        }

        public double getDIFFMACHIE() {
            return DIFFMACHIE;
        }

        public void setDIFFMACHIE(double DIFFMACHIE) {
            this.DIFFMACHIE = DIFFMACHIE;
        }

        public double getCURECAPACITYALL() {
            return CURECAPACITYALL;
        }

        public void setCURECAPACITYALL(double CURECAPACITYALL) {
            this.CURECAPACITYALL = CURECAPACITYALL;
        }
    }
}
