package hznj.com.zhongcexiangjiao.doman;


import java.util.List;

public class jiaoliaoBean {

    /**
     * list : [{"PLACENAME":"下三角胶料","DATACHR":"D087","GUMNO":"D087-C","BCORDCHECKRESULT":"属性相同","BARCODE":"170412112L09000103~5020000000864~01011~D087-C~2017-04-12~2~1~3~3~0"},{"PLACENAME":"上三角胶料","DATACHR":"D071","GUMNO":"D071","BCORDCHECKRESULT":"完全相同","BARCODE":"170415082L02200013~5020000000694~01008~D071~2017-04-15~2~13~16~2~0"},{"PLACENAME":"三角胶片胶料","DATACHR":"EA032","GUMNO":"SEA032","BCORDCHECKRESULT":"属性相同","BARCODE":"170415072L05202203~5010000004337~01007~SEA032~2017-04-15~2~22~24~4~611"}]
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
         * PLACENAME : 下三角胶料
         * DATACHR : D087
         * GUMNO : D087-C
         * BCORDCHECKRESULT : 属性相同
         * BARCODE : 170412112L09000103~5020000000864~01011~D087-C~2017-04-12~2~1~3~3~0
         */

        private String PLACENAME;
        private String DATACHR;
        private String GUMNO;
        private String BCORDCHECKRESULT;
        private String BARCODE;

        public String getPLACENAME() {
            return PLACENAME;
        }

        public void setPLACENAME(String PLACENAME) {
            this.PLACENAME = PLACENAME;
        }

        public String getDATACHR() {
            return DATACHR;
        }

        public void setDATACHR(String DATACHR) {
            this.DATACHR = DATACHR;
        }

        public String getGUMNO() {
            return GUMNO;
        }

        public void setGUMNO(String GUMNO) {
            this.GUMNO = GUMNO;
        }

        public String getBCORDCHECKRESULT() {
            return BCORDCHECKRESULT;
        }

        public void setBCORDCHECKRESULT(String BCORDCHECKRESULT) {
            this.BCORDCHECKRESULT = BCORDCHECKRESULT;
        }

        public String getBARCODE() {
            return BARCODE;
        }

        public void setBARCODE(String BARCODE) {
            this.BARCODE = BARCODE;
        }
    }
}
