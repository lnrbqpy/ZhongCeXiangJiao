package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/10 19:34
 */

public class jianchaBean {

    /**
     * list : [{"BBARCODE":"D7E3D50002","SMDATE":"2017-04-01 07:38:14","BZ":"硫化扫描(新标签)","DJNAME":"正品","BLPNAME":null},{"BBARCODE":"D7E3D50002","SMDATE":"2017-04-01 10:45:08","BZ":"外观检测","DJNAME":"正品","BLPNAME":null},{"BBARCODE":"D7E3D50002","SMDATE":"2017-04-01 10:50:24","BZ":"仓检扫描","DJNAME":"正品","BLPNAME":null},{"BBARCODE":"D7E3D50002","SMDATE":"2017-04-01 13:07:08","BZ":"入笼扫描","DJNAME":"正品","BLPNAME":null},{"BBARCODE":"D7E3D50002","SMDATE":"2017-04-01 13:07:10","BZ":"出厂装车","DJNAME":"正品","BLPNAME":null}]
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
         * BBARCODE : D7E3D50002
         * SMDATE : 2017-04-01 07:38:14
         * BZ : 硫化扫描(新标签)
         * DJNAME : 正品
         * BLPNAME : null
         */

        private String BBARCODE;
        private String SMDATE;
        private String BZ;
        private String DJNAME;
        private Object BLPNAME;

        public String getBBARCODE() {
            return BBARCODE;
        }

        public void setBBARCODE(String BBARCODE) {
            this.BBARCODE = BBARCODE;
        }

        public String getSMDATE() {
            return SMDATE;
        }

        public void setSMDATE(String SMDATE) {
            this.SMDATE = SMDATE;
        }

        public String getBZ() {
            return BZ;
        }

        public void setBZ(String BZ) {
            this.BZ = BZ;
        }

        public String getDJNAME() {
            return DJNAME;
        }

        public void setDJNAME(String DJNAME) {
            this.DJNAME = DJNAME;
        }

        public Object getBLPNAME() {
            return BLPNAME;
        }

        public void setBLPNAME(Object BLPNAME) {
            this.BLPNAME = BLPNAME;
        }
    }
}
