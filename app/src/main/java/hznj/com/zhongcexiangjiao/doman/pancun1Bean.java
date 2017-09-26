package hznj.com.zhongcexiangjiao.doman;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/6/29 16:46
 */

public class pancun1Bean {



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
        @SerializedName("MAX(PRODUCTIONCODE)")
        private String _$MAXPRODUCTIONCODE134; // FIXME check this code
        private String FNAME;

        public String get_$MAXPRODUCTIONCODE134() {
            return _$MAXPRODUCTIONCODE134;
        }

        public void set_$MAXPRODUCTIONCODE134(String _$MAXPRODUCTIONCODE134) {
            this._$MAXPRODUCTIONCODE134 = _$MAXPRODUCTIONCODE134;
        }

        public String getFNAME() {
            return FNAME;
        }

        public void setFNAME(String FNAME) {
            this.FNAME = FNAME;
        }
    }
}
