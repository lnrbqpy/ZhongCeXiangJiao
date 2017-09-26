package hznj.com.zhongcexiangjiao.doman;

import java.util.List;


public class ptkbBean {


    private String msg;
    private String         result;
    private List<ListBean1> list;

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

    public List<ListBean1> getList() {
        return list;
    }

    public void setList(List<ListBean1> list) {
        this.list = list;
    }

    public static class ListBean1 {
        /**
         * YYYYMMDD : 20170615
         * SIZEID : 11R24.5
         * BUILDINGCAPACITY : 93
         * SCHEDULEORDER : 1212
         * BUILDINGACTUAL : 398
         * BUILDINGRATIO : 32.8
         * CM1 : F06(1:3)
         * CM2 : F07(1:3)
         * CM3 : F08(1:6)
         * CM4 : null
         * CM5 : null
         * CM6 : null
         */

        private String YYYYMMDD;
        private String SIZEID;
        private int    BUILDINGCAPACITY;
        private int    SCHEDULEORDER;
        private int    BUILDINGACTUAL;
        private double BUILDINGRATIO;
        private String CM1;
        private String CM2;
        private String CM3;
        private Object CM4;
        private Object CM5;
        private Object CM6;

        public String getYYYYMMDD() {
            return YYYYMMDD;
        }

        public void setYYYYMMDD(String YYYYMMDD) {
            this.YYYYMMDD = YYYYMMDD;
        }

        public String getSIZEID() {
            return SIZEID;
        }

        public void setSIZEID(String SIZEID) {
            this.SIZEID = SIZEID;
        }

        public int getBUILDINGCAPACITY() {
            return BUILDINGCAPACITY;
        }

        public void setBUILDINGCAPACITY(int BUILDINGCAPACITY) {
            this.BUILDINGCAPACITY = BUILDINGCAPACITY;
        }

        public int getSCHEDULEORDER() {
            return SCHEDULEORDER;
        }

        public void setSCHEDULEORDER(int SCHEDULEORDER) {
            this.SCHEDULEORDER = SCHEDULEORDER;
        }

        public int getBUILDINGACTUAL() {
            return BUILDINGACTUAL;
        }

        public void setBUILDINGACTUAL(int BUILDINGACTUAL) {
            this.BUILDINGACTUAL = BUILDINGACTUAL;
        }

        public double getBUILDINGRATIO() {
            return BUILDINGRATIO;
        }

        public void setBUILDINGRATIO(double BUILDINGRATIO) {
            this.BUILDINGRATIO = BUILDINGRATIO;
        }

        public String getCM1() {
            return CM1;
        }

        public void setCM1(String CM1) {
            this.CM1 = CM1;
        }

        public String getCM2() {
            return CM2;
        }

        public void setCM2(String CM2) {
            this.CM2 = CM2;
        }

        public String getCM3() {
            return CM3;
        }

        public void setCM3(String CM3) {
            this.CM3 = CM3;
        }

        public Object getCM4() {
            return CM4;
        }

        public void setCM4(Object CM4) {
            this.CM4 = CM4;
        }

        public Object getCM5() {
            return CM5;
        }

        public void setCM5(Object CM5) {
            this.CM5 = CM5;
        }

        public Object getCM6() {
            return CM6;
        }

        public void setCM6(Object CM6) {
            this.CM6 = CM6;
        }
    }
}
