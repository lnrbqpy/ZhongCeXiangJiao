package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/5/10 16:29
 */

public class sqmxBean {


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
         * YYYYMMDD : NEWYMMDD
         * ROLEID : 7001
         * ROLENAME : 厂警
         * DEPARTMENT : 20
         * DEPARTMENTNAME : 成型车间
         * TYPEID : C
         * STCODE : FRH-105
         * DECODE1 : 20170509
         * DECODE2 : 1
         */

        private String YYYYMMDD;
        private String ROLEID;
        private String ROLENAME;
        private String DEPARTMENT;
        private String DEPARTMENTNAME;
        private String TYPEID;
        private String STCODE;
        private String DECODE1;
        private String DECODE2;

        public String getYYYYMMDD() {
            return YYYYMMDD;
        }

        public void setYYYYMMDD(String YYYYMMDD) {
            this.YYYYMMDD = YYYYMMDD;
        }

        public String getROLEID() {
            return ROLEID;
        }

        public void setROLEID(String ROLEID) {
            this.ROLEID = ROLEID;
        }

        public String getROLENAME() {
            return ROLENAME;
        }

        public void setROLENAME(String ROLENAME) {
            this.ROLENAME = ROLENAME;
        }

        public String getDEPARTMENT() {
            return DEPARTMENT;
        }

        public void setDEPARTMENT(String DEPARTMENT) {
            this.DEPARTMENT = DEPARTMENT;
        }

        public String getDEPARTMENTNAME() {
            return DEPARTMENTNAME;
        }

        public void setDEPARTMENTNAME(String DEPARTMENTNAME) {
            this.DEPARTMENTNAME = DEPARTMENTNAME;
        }

        public String getTYPEID() {
            return TYPEID;
        }

        public void setTYPEID(String TYPEID) {
            this.TYPEID = TYPEID;
        }

        public String getSTCODE() {
            return STCODE;
        }

        public void setSTCODE(String STCODE) {
            this.STCODE = STCODE;
        }

        public String getDECODE1() {
            return DECODE1;
        }

        public void setDECODE1(String DECODE1) {
            this.DECODE1 = DECODE1;
        }

        public String getDECODE2() {
            return DECODE2;
        }

        public void setDECODE2(String DECODE2) {
            this.DECODE2 = DECODE2;
        }
    }
}
