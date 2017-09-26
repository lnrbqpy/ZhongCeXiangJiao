package hznj.com.zhongcexiangjiao.doman;


import java.util.List;

public class chengxingpeizhiBean {



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
         * BUILDINGNAME : 12.00R24 20PR CR926B 朝系
         * PROCESSNO : RTN-17-08-17-01
         * SCHEDULEID : B
         * CMACHINEALL : G20
         * CMACHINENUM : 1.0
         * CURETIME : 46.0
         * PRODUCTIONCODE : A4EH7B2A_RTN170817
         * CURECAPACITY : 57.0
         * SCHEDULEORDER : 57
         * REQUIREMENT : 57
         * INVENTORYSHIFT : 0
         * BMACHINENUM : 0.0
         * BMACHINEIDALL : null
         * ESTIMATEDNUM : null
         * NOWINVSHORTTYPE : 4
         */

        private String BUILDINGNAME;
        private String PROCESSNO;
        private String SCHEDULEID;
        private String CMACHINEALL;
        private double CMACHINENUM;
        private double CURETIME;
        private String PRODUCTIONCODE;
        private double CURECAPACITY;
        private int    SCHEDULEORDER;
        private int    REQUIREMENT;
        private int    INVENTORYSHIFT;
        private double BMACHINENUM;
        private Object BMACHINEIDALL;
        private Object ESTIMATEDNUM;
        private String NOWINVSHORTTYPE;

        public String getBUILDINGNAME() {
            return BUILDINGNAME;
        }

        public void setBUILDINGNAME(String BUILDINGNAME) {
            this.BUILDINGNAME = BUILDINGNAME;
        }

        public String getPROCESSNO() {
            return PROCESSNO;
        }

        public void setPROCESSNO(String PROCESSNO) {
            this.PROCESSNO = PROCESSNO;
        }

        public String getSCHEDULEID() {
            return SCHEDULEID;
        }

        public void setSCHEDULEID(String SCHEDULEID) {
            this.SCHEDULEID = SCHEDULEID;
        }

        public String getCMACHINEALL() {
            return CMACHINEALL;
        }

        public void setCMACHINEALL(String CMACHINEALL) {
            this.CMACHINEALL = CMACHINEALL;
        }

        public double getCMACHINENUM() {
            return CMACHINENUM;
        }

        public void setCMACHINENUM(double CMACHINENUM) {
            this.CMACHINENUM = CMACHINENUM;
        }

        public double getCURETIME() {
            return CURETIME;
        }

        public void setCURETIME(double CURETIME) {
            this.CURETIME = CURETIME;
        }

        public String getPRODUCTIONCODE() {
            return PRODUCTIONCODE;
        }

        public void setPRODUCTIONCODE(String PRODUCTIONCODE) {
            this.PRODUCTIONCODE = PRODUCTIONCODE;
        }

        public double getCURECAPACITY() {
            return CURECAPACITY;
        }

        public void setCURECAPACITY(double CURECAPACITY) {
            this.CURECAPACITY = CURECAPACITY;
        }

        public int getSCHEDULEORDER() {
            return SCHEDULEORDER;
        }

        public void setSCHEDULEORDER(int SCHEDULEORDER) {
            this.SCHEDULEORDER = SCHEDULEORDER;
        }

        public int getREQUIREMENT() {
            return REQUIREMENT;
        }

        public void setREQUIREMENT(int REQUIREMENT) {
            this.REQUIREMENT = REQUIREMENT;
        }

        public int getINVENTORYSHIFT() {
            return INVENTORYSHIFT;
        }

        public void setINVENTORYSHIFT(int INVENTORYSHIFT) {
            this.INVENTORYSHIFT = INVENTORYSHIFT;
        }

        public double getBMACHINENUM() {
            return BMACHINENUM;
        }

        public void setBMACHINENUM(double BMACHINENUM) {
            this.BMACHINENUM = BMACHINENUM;
        }

        public Object getBMACHINEIDALL() {
            return BMACHINEIDALL;
        }

        public void setBMACHINEIDALL(Object BMACHINEIDALL) {
            this.BMACHINEIDALL = BMACHINEIDALL;
        }

        public Object getESTIMATEDNUM() {
            return ESTIMATEDNUM;
        }

        public void setESTIMATEDNUM(Object ESTIMATEDNUM) {
            this.ESTIMATEDNUM = ESTIMATEDNUM;
        }

        public String getNOWINVSHORTTYPE() {
            return NOWINVSHORTTYPE;
        }

        public void setNOWINVSHORTTYPE(String NOWINVSHORTTYPE) {
            this.NOWINVSHORTTYPE = NOWINVSHORTTYPE;
        }
    }
}
