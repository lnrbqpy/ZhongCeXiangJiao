package hznj.com.zhongcexiangjiao.doman;

import java.util.List;

public class ptkbBean2 {


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
         * MACHINEID : F05
         * BUILDINGNAME : RT-11R24.5 16PR AD757/AD185/TRACKPLUS 出口
         * BUILDINGCODE : A1CN4D_RTW174020
         * NOWINVSHORTTYPE : 1
         * PROCESSNO : RTW-17-40-20-01
         * INVENTORYSHIFT : 0
         * BUILDINGACTUAL : 0
         * MAXINVENTORY : 88
         * MININVENTORY : 51
         * ESTIMATEDNUM : 0
         * ESTIMATEDDATE : 2017/06/16 07:00:38
         */

        private String MACHINEID;
        private String BUILDINGNAME;
        private String BUILDINGCODE;
        private String NOWINVSHORTTYPE;
        private String PROCESSNO;
        private int    INVENTORYSHIFT;
        private int    BUILDINGACTUAL;
        private int    MAXINVENTORY;
        private int    MININVENTORY;
        private int    ESTIMATEDNUM;
        private String ESTIMATEDDATE;

        public String getMACHINEID() {
            return MACHINEID;
        }

        public void setMACHINEID(String MACHINEID) {
            this.MACHINEID = MACHINEID;
        }

        public String getBUILDINGNAME() {
            return BUILDINGNAME;
        }

        public void setBUILDINGNAME(String BUILDINGNAME) {
            this.BUILDINGNAME = BUILDINGNAME;
        }

        public String getBUILDINGCODE() {
            return BUILDINGCODE;
        }

        public void setBUILDINGCODE(String BUILDINGCODE) {
            this.BUILDINGCODE = BUILDINGCODE;
        }

        public String getNOWINVSHORTTYPE() {
            return NOWINVSHORTTYPE;
        }

        public void setNOWINVSHORTTYPE(String NOWINVSHORTTYPE) {
            this.NOWINVSHORTTYPE = NOWINVSHORTTYPE;
        }

        public String getPROCESSNO() {
            return PROCESSNO;
        }

        public void setPROCESSNO(String PROCESSNO) {
            this.PROCESSNO = PROCESSNO;
        }

        public int getINVENTORYSHIFT() {
            return INVENTORYSHIFT;
        }

        public void setINVENTORYSHIFT(int INVENTORYSHIFT) {
            this.INVENTORYSHIFT = INVENTORYSHIFT;
        }

        public int getBUILDINGACTUAL() {
            return BUILDINGACTUAL;
        }

        public void setBUILDINGACTUAL(int BUILDINGACTUAL) {
            this.BUILDINGACTUAL = BUILDINGACTUAL;
        }

        public int getMAXINVENTORY() {
            return MAXINVENTORY;
        }

        public void setMAXINVENTORY(int MAXINVENTORY) {
            this.MAXINVENTORY = MAXINVENTORY;
        }

        public int getMININVENTORY() {
            return MININVENTORY;
        }

        public void setMININVENTORY(int MININVENTORY) {
            this.MININVENTORY = MININVENTORY;
        }

        public int getESTIMATEDNUM() {
            return ESTIMATEDNUM;
        }

        public void setESTIMATEDNUM(int ESTIMATEDNUM) {
            this.ESTIMATEDNUM = ESTIMATEDNUM;
        }

        public String getESTIMATEDDATE() {
            return ESTIMATEDDATE;
        }

        public void setESTIMATEDDATE(String ESTIMATEDDATE) {
            this.ESTIMATEDDATE = ESTIMATEDDATE;
        }
    }
}
