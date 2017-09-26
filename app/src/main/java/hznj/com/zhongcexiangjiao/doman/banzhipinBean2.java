package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/13 13:18
 */

public class banzhipinBean2 {


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
         * TCPARTNAME : 胎侧
         * TCPARTNUMBERS : TC160019
         * TCPARTNUMBERA : TC160019
         * TCVERIFYRESULT : 合格
         * TCBARCODE : A00TC1703221822551703271822552TC160019
         */

        private String TCPARTNAME;
        private String TCPARTNUMBERS;
        private String TCPARTNUMBERA;
        private String TCVERIFYRESULT;
        private String TCBARCODE;

        public String getTCPARTNAME() {
            return TCPARTNAME;
        }

        public void setTCPARTNAME(String TCPARTNAME) {
            this.TCPARTNAME = TCPARTNAME;
        }

        public String getTCPARTNUMBERS() {
            return TCPARTNUMBERS;
        }

        public void setTCPARTNUMBERS(String TCPARTNUMBERS) {
            this.TCPARTNUMBERS = TCPARTNUMBERS;
        }

        public String getTCPARTNUMBERA() {
            return TCPARTNUMBERA;
        }

        public void setTCPARTNUMBERA(String TCPARTNUMBERA) {
            this.TCPARTNUMBERA = TCPARTNUMBERA;
        }

        public String getTCVERIFYRESULT() {
            return TCVERIFYRESULT;
        }

        public void setTCVERIFYRESULT(String TCVERIFYRESULT) {
            this.TCVERIFYRESULT = TCVERIFYRESULT;
        }

        public String getTCBARCODE() {
            return TCBARCODE;
        }

        public void setTCBARCODE(String TCBARCODE) {
            this.TCBARCODE = TCBARCODE;
        }
    }
}
