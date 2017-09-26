package hznj.com.zhongcexiangjiao.api;


public class ApiConstants {
    //正式接口
    public static final String OUTER_URL = "http://171.188.42.56:8081/";
    //测试接口
    //public static final String OUTER_URL = "http://16s58692f6.iask.in:22044/";
    // public static final String OUTER_URL = "http://gank.io/";

    /**
     * 获取对应的host
     * @param hostType
     *         host类     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.BLG_INNER:
                host = OUTER_URL;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }

}
