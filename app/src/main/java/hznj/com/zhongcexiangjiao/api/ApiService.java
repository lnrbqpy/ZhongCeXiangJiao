package hznj.com.zhongcexiangjiao.api;


import hznj.com.zhongcexiangjiao.doman.XguangBean;
import hznj.com.zhongcexiangjiao.doman.banzhipinBean1;
import hznj.com.zhongcexiangjiao.doman.banzhipinBean2;
import hznj.com.zhongcexiangjiao.doman.bzpChaXunBean;
import hznj.com.zhongcexiangjiao.doman.checkShiGongbiaoBean;
import hznj.com.zhongcexiangjiao.doman.checkphotoBean;
import hznj.com.zhongcexiangjiao.doman.chengxingBean;
import hznj.com.zhongcexiangjiao.doman.chengxingjihuaBean;
import hznj.com.zhongcexiangjiao.doman.chengxingpeizhiBean;
import hznj.com.zhongcexiangjiao.doman.jh_chanliangBean;
import hznj.com.zhongcexiangjiao.doman.jh_zongshuBean;
import hznj.com.zhongcexiangjiao.doman.jianchaBean;
import hznj.com.zhongcexiangjiao.doman.jiaoliaoBean;
import hznj.com.zhongcexiangjiao.doman.jlChaXunBean;
import hznj.com.zhongcexiangjiao.doman.lhTuPianBean;
import hznj.com.zhongcexiangjiao.doman.liuhuaBean;
import hznj.com.zhongcexiangjiao.doman.loginBean;
import hznj.com.zhongcexiangjiao.doman.loginYuanGongBean;
import hznj.com.zhongcexiangjiao.doman.moldingBean;
import hznj.com.zhongcexiangjiao.doman.pancun1Bean;
import hznj.com.zhongcexiangjiao.doman.ptkbBean;
import hznj.com.zhongcexiangjiao.doman.ptkbBean2;
import hznj.com.zhongcexiangjiao.doman.qualityUserBean;
import hznj.com.zhongcexiangjiao.doman.querenhuawenBean;
import hznj.com.zhongcexiangjiao.doman.semiFinishedBean;
import hznj.com.zhongcexiangjiao.doman.shujukaBean;
import hznj.com.zhongcexiangjiao.doman.sqjcBean;
import hznj.com.zhongcexiangjiao.doman.sqlhBean;
import hznj.com.zhongcexiangjiao.doman.sqmxBean;
import hznj.com.zhongcexiangjiao.doman.sqzbBean;
import hznj.com.zhongcexiangjiao.doman.tijiaoBean;
import hznj.com.zhongcexiangjiao.doman.updataBean;
import hznj.com.zhongcexiangjiao.doman.vulcanizeBean;
import hznj.com.zhongcexiangjiao.doman.waiguanBean;
import hznj.com.zhongcexiangjiao.doman.zhaopianBean;
import hznj.com.zhongcexiangjiao.doman.zhongliangBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HP on 2016/12/9.
 */

public interface ApiService {

  /*  @FormUrlEncoded
    @POST(ApiConstants.COMMODITY_LIST)
    Call<ProductlListInfo> getProductListInfo(
            @Field("name") String name,
            @Field("categoryid") int categoryid,
            @Field("childid") int childid,
            @Field("pageIndex") int pageIndex,
            @Field("pageSize") int pageSize,
            @Field("ishot") int ishot,
            @Field("threecategory") int threecategory,
            @Field("dealertype") int dealertype,
            @Field("sign") String sign);


    @GET(ApiConstants.PLATFORM_SON)
    Call<ChildCategory> getChildCategory(
            @Query("id") int id);

  */
 /*@GET("api/data/福利/6/1")
  Call<jh_chanliangBean> getJihuachanliangBean(
 );*/

    @GET("app/API/ForwardTrace/GetProcessTableData")
    Call<chengxingBean> getChengxingBean(
            @Query("s") String kaishi,
            @Query("p") String jieshu,
            @Query("ProcessName") String jitai,
            @Query("ProcessValue") String select
    );

    @GET("app/API/ForwardTrace/GetProcessTableData")
    Call<liuhuaBean> getLiuhuaBean(
            @Query("s") String kaishi,
            @Query("p") String jieshu,
            @Query("ProcessName") String jitai,
            @Query("ProcessValue") String select
    );

    @GET("app/API/ForwardTrace/GetProcessTableData")
    Call<zhongliangBean> getZhongliangBean(
            @Query("s") String kaishi,
            @Query("p") String jieshu,
            @Query("ProcessName") String jitai,
            @Query("ProcessValue") String select
    );

    @GET("app/API/ForwardTrace/GetProcessTableData")
    Call<XguangBean> getXguangBean(
            @Query("s") String kaishi,
            @Query("p") String jieshu,
            @Query("ProcessName") String jitai,
            @Query("ProcessValue") String select
    );

    @GET("app/API/ForwardTrace/GetProcessTableData")
    Call<waiguanBean> getWaiguanBean(
            @Query("s") String kaishi,
            @Query("p") String jieshu,
            @Query("ProcessName") String jitai,
            @Query("ProcessValue") String select
    );

    /**
     * jiancha
     */
    @GET("app/API/ForwardTrace/GetCheckDetailData")
    Call<jianchaBean> getJianchaBean(
            @Query("CheckBarcode") String chengxing
    );

    @GET("app/API/ForwardTrace/GetCureDetailData")
    Call<vulcanizeBean> getVulcanizeBean(
            @Query("CureBarcode") String chengxing
    );

    @GET("app/API/ForwardTrace/GetCureDetailData")
    Call<moldingBean> getMoldingBean(
            @Query("BuildingBarcode") String chengxing
    );

    @GET("app/API/ForwardTrace/GetCureDetailData")
    Call<semiFinishedBean> getSemiFinishedBean(
            @Query("PartInvendBarcode") String chengxing
    );

    @GET("app/API/ForwardTrace/GetCureDetailData1")
    Call<banzhipinBean1> getBanzhipinBean1(
            @Query("PartInvendReferCode1") String chengxing
    );

    @GET("app/API/ForwardTrace/GetCureDetailData2")
    Call<banzhipinBean2> getBanzhipinBean2(
            @Query("PartInvendReferCode2") String chengxing
    );

    @GET("app/API/ForwardTrace/GetXrayPic")
    Call<zhaopianBean> getzhapianBean(
            @Query("XrayPicBarcode") String chengxing
    );

    @GET("app/API/ForwardTrace/GetGumReferData1")
    Call<jiaoliaoBean> getJiaoliaoBean(
            @Query("GumReferCode1") String chengxing
    );

    @GET("app/API/ForwardTrace/GetGumReferData2")
    Call<shujukaBean> getShujukaBean(
            @Query("GumReferCode2") String chengxing
    );

    @GET("app/API/ForwardTrace/GetBuildingInfoByPartInvendCode")
    Call<bzpChaXunBean> getBzpChaXunBean(
            @Query("PartInvendCode") String chengxing
    );

    @GET("app/API/ForwardTrace/GetBuildingInfoByGumCode")
    Call<jlChaXunBean> getJlChaXunBean(
            @Query("GumCode") String chengxing
    );

    @GET("app/API/ForwardTrace/GetCureGraphData2")
    Call<lhTuPianBean> getLhTuPianBean(
            @Query("CureGrapBarcode2") String chengxing
    );

    /**
     * 安全部分网络请求
     * 1是登陆  其他都是数据加载
     */
    @GET("app/API/RoutingInspection/GetUserInfo")
    Call<loginBean> getLoginBean(
            @Query("userid") String userid,
            @Query("password") String password
    );

    /*---------------------*/

    @GET("app/API/RoutingInspection/GetRouting")
    Call<sqlhBean> getSqLhBean(
            @Query("roleid") String userid,
            @Query("department") String department
    );


    @GET("app/API/RoutingInspection/GetRouting")
    Call<sqzbBean> getSqZbBean(
            @Query("roleid") String userid,
            @Query("department") String department
    );



    @GET("app/API/RoutingInspection/GetRouting")
    Call<sqjcBean> getSqJcBean(
            @Query("roleid") String userid,
            @Query("department") String department
    );



    @GET("app/API/RoutingInspection/GetRouting")
    Call<sqmxBean> getSqMxBean(
            @Query("roleid") String userid,
            @Query("department") String department
    );

    /*---------------*/

    @GET("app/API/RoutingInspection/GetRoutingInfoUpdate")
    Call<String> getANQUAN(
            @Query("userid") String userid,
            @Query("roleid") String roleid,
            @Query("stcode") String stcode,
            @Query("typeid") String typeid,
            @Query("dataid") String dataid,
            @Query("cmt") String cmt,
            @Query("yesno") String yesno
    );

    @GET("app/API/RoutingInspection/GetRoutingInfoUpdate")
    Call<String> getWENTI(
            @Query("userid") String userid,
            @Query("roleid") String roleid,
            @Query("stcode") String stcode,
            @Query("typeid") String typeid,
            @Query("dataid") String dataid,
            @Query("cmt") String cmt,
            @Query("yesno") String yesno
    );

    @GET("app/API/WorkManage/GetMonthPlanSummaryInfo1")
    Call<jh_chanliangBean> getJihuachanliangBean(
            @Query("mpsi1ym") String s,
            @Query("mpsi1sizeid") String p
    );

    /**
     * 月计划y
      */

    @GET("app/API/WorkManage/GetMonthPlanSummaryInfo2")
    Call<jh_zongshuBean> getPlanzongshuBean(
            @Query("mpsi2ym") String mpsi2ym,
            @Query("mpsi2sizeid") String mpsi2sizeid
    );


    @GET("app/API/WorkManage/GetMonthPlanSummaryInfo2")
    Call<jh_zongshuBean> getzongshu(
            @Query("mpsi2ym") String mpsi2ym,
            @Query("mpsi2sizeid") String mpsi2sizeid
    );

    /**
     * peitai kanban
     */

    @GET("app/API/WorkManage/GetPlanManageGreenTireShow1")
    Call<ptkbBean> getPTKBBean(
            @Query("mpgts1ym") String s,
            @Query("mpgts1sizeid") String p
    );

    @GET("app/API/WorkManage/GetPlanManageGreenTireShow2")
    Call<ptkbBean2> getPTKBBean2(
            @Query("mpgts2ym") String s,
            @Query("mpgts2sizeid") String p
    );

    /**
     * kucun1
     */
    @GET("app/API/WorkManage/getFname")
    Call<pancun1Bean> getPanCun1Bean(
            @Query("st") String st
    );

    /**
     * 上传图片
     */
    /*@Multipart
    ]
    @POST("app/Images")
    Call<Result<String>>uploadMemberIcon(@Part List<MultipartBody.Part>partList);*/
    //上传图片
   /* @Multipart
    @POST("app/Images")
    Call<BaseRespose<List<String>>> uploadFiles(
            @PartMap() Map<String, RequestBody> maps);*/
    @GET("/app/API/WorkManage/GetPlanManageConfig")
    Call<chengxingpeizhiBean> getChengXingPeiZhi(
            @Query("pmcym") String s,
            @Query("pmcshift") String p
    );

    @GET("app/API/WorkManage/GetBuildingSchedule")
    Call<chengxingjihuaBean> getChengXingJiHua(
            @Query("bsym") String st,
            @Query("bsshift") String st1
    );

    // app/API/RoutingInspection/GetRoutingSendMessage?rsmfromuser=姚岚&rsmtousertel=18591912751&rsmstcode=FRH-250&rsmtypename=灭火器&rsmdataname=过期

    @GET("app/API/RoutingInspection/GetRoutingSendMessage")
    Call<String> getDuanXin(
            @Query("rsmfromuser") String st,
            @Query("rsmtousertel") String st1,
            @Query("rsmstcode") String st2,
            @Query("rsmtypename") String st3,
            @Query("rsmdataname") String st4

    );

    @GET("app/API/RoutingInspection/GetUpdateEquipmentState")
    Call<String> getYouXiaoQi(
            @Query("uesstcode") String st,
            @Query("uesyyyymmdd") String st1,
            @Query("uestypeid") String st2
    );

    @GET("app/API/RoutingInspection/GetShowRoutingPicture")
    Call<checkphotoBean> CheckPhoto(
            @Query("srpyyyymmdd1") String st,
            @Query("srpyyyymmdd2") String st1,
            @Query("srpstcode") String st2
    );


    @GET("app/API/WorkManage/GetQualityUserInfo")
    Call<loginYuanGongBean> getloginYuangong(
            @Query("qualityuserinfoid") String qualityuserinfoid


    );

    //http://171.188.42.56:8081/app/API/WorkManage/GetQualityCheckPattern?qualitycp=CB995A
    @GET("app/API/WorkManage/GetQualityCheckPattern")
    Call<querenhuawenBean> getQuerenhuawen(
            @Query("qualitycp") String qualitycp

    );

    //qdiymd
    // qdishift
    // qdicrew=1&
    // qdimachineid=F02&
    // qdisizeid=12R22.5&
    // qdipr=16PR&
    // qdipattern=AZ565&
    // qdibrand=朝阳&
    // qdisale=朝系&
    // qditypeid=1&
    // qdidataid=1&
    // qdip1=10&
    // qdip2=20&
    // qdip3=30&
    // qdip4=50
    @GET("app/API/WorkManage/GetQualityDataInfo")
    Call<tijiaoBean> getTijiaoshuju(
            @Query("qdiymd") String qdiymd,

            @Query("qdishift") String qdishift,
            @Query("qdicrew") String qdicrew,
            @Query("qdimachineid") String qdimachineid,
            @Query("qdisizeid") String qdisizeid,
            @Query("qdipr") String qdipr,
            @Query("qdipattern") String qdipattern,
            @Query("qdibrand") String qdibrand,
            @Query("qdisale") String qdisale,
            @Query("qditypeid") String qditypeid,
            @Query("qdidataid") String qdidataid,
            @Query("qdip1") String qdip1,
            @Query("qdip2") String qdip2,
            @Query("qdip3") String qdip3,
            @Query("qdip4") String qdip4
    );
    //确定施工表
//qcpsizeid=13R22.5&qcppr=18+PR&qcppattern=CB995A&qcpsale=%E6%9C%9D%E7%B3%BB
    @GET("app/API/WorkManage/GetQualityCheckProcessNo")
    Call<checkShiGongbiaoBean> getCheckShigongbiao(
            @Query("qcpsizeid") String qcpsizeid,
            @Query("qcppr") String qcppr,
            @Query("qcppattern") String qcppattern,
            @Query("qcpsale") String qcpsale

    );

    //http://171.188.42.56:8081/?quymd=20170914&qushift=2&qucrew=1&qumachineid=F01&quoperatorcode=J0161

    @GET("app/API/WorkManage/GetQualityUser")
    Call<qualityUserBean> getQualityUser(
            @Query("quymd") String quymd,
            @Query("qushift") String qushift,
            @Query("qucrew") String qucrew,
            @Query("qumachineid") String qumachineid,
            @Query("quoperatorcode") String quoperatorcode
    );
   //http://171.188.42.56:8081/app/API/WorkManage/GetQualityUpdateDataInof?quprocessno=RTN-17-06-139-03&qudtypeid=1&quddatacd=3&qudp1=10&qudp2=20&qudp3=30&qudp4=120
    @GET("app/API/WorkManage/GetQualityUpdateDataInof")
    Call<updataBean> getUpDataBean(
            @Query("quprocessno") String quprocessno,
            @Query("qudtypeid") String qudtypeid,
            @Query("quddatacd") String quddatacd,
            @Query("qudp1") String qudp1,
            @Query("qudp2") String qudp2,
            @Query("qudp3") String qudp3,
            @Query("qudp4") String qudp4
    );
}
