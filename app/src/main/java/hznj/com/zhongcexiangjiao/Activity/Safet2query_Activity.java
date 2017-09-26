package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import hznj.com.zhongcexiangjiao.Fragment.Sq_jc_Fragment;
import hznj.com.zhongcexiangjiao.Fragment.Sq_lh_Fragment;
import hznj.com.zhongcexiangjiao.Fragment.Sq_mx_Fragment;
import hznj.com.zhongcexiangjiao.Fragment.Sq_zb_Fragment;
import hznj.com.zhongcexiangjiao.R;

/**
 * Description:
 * Copyright  : Copyright (c) 2017/9/23
 * Company    : 杭州能匠
 * Author     : 张新伟
 * Date       : 2017/9/23 14:37
 */
public class Safet2query_Activity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton         sq_gum;
    private RadioButton         sq_prepare;
    private RadioButton         sq_molding;
    private RadioButton         sq_vulcanize;
    private RadioGroup          sq_xuanze;
    private FrameLayout         sq_inquire;
    private FragmentTransaction ft_safet;
    private String              roleid;
    private Bundle              bundle1_sq;
    private String              userid;
    private FragmentManager     manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safetquery);
        roleid = getIntent().getExtras().getString("roleid1");
        userid = getIntent().getExtras().getString("userid1");
         //Toast.makeText(getApplicationContext(),roleid+"----"+userid , Toast.LENGTH_SHORT).show();
        initView();


    }

    private void initView() {
        sq_gum = (RadioButton) findViewById(R.id.sq_gum);
        sq_prepare = (RadioButton) findViewById(R.id.sq_prepare);
        sq_molding = (RadioButton) findViewById(R.id.sq_molding);
        sq_vulcanize = (RadioButton) findViewById(R.id.sq_vulcanize);
        //sq_xuanze = (RadioGroup) findViewById(R.id.sq_xuanze);
        sq_inquire = (FrameLayout) findViewById(R.id.sq_inquire);

        sq_gum.setOnClickListener(this);
        sq_prepare.setOnClickListener(this);
        sq_molding.setOnClickListener(this);
        sq_vulcanize.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        getSupportFragmentManager();
        bundle1_sq = new Bundle();
        ft_safet = manager.beginTransaction();
        bundle1_sq.putString("roleid", roleid);
        bundle1_sq.putString("userid", userid);
        switch (view.getId()) {
            case R.id.sq_molding:
                Sq_mx_Fragment Sq_mx_fragment = new Sq_mx_Fragment();
                Sq_mx_fragment.setArguments(bundle1_sq);
                ft_safet.replace(R.id.sq_inquire, Sq_mx_fragment);
                ft_safet.commit();
                break;

            case R.id.sq_vulcanize:
                Sq_lh_Fragment Sq_lh_fragment = new Sq_lh_Fragment();
                Sq_lh_fragment.setArguments(bundle1_sq);
                ft_safet.replace(R.id.sq_inquire, Sq_lh_fragment);
                ft_safet.commit();
                break;


            case R.id.sq_prepare:
                Sq_zb_Fragment Sq_zb_fragment = new Sq_zb_Fragment();
                Sq_zb_fragment.setArguments(bundle1_sq);
                ft_safet.replace(R.id.sq_inquire, Sq_zb_fragment);
                ft_safet.commit();
                break;

            case R.id.sq_gum:
                Sq_jc_Fragment Sq_jc_fragment = new Sq_jc_Fragment();
                Sq_jc_fragment.setArguments(bundle1_sq);
                ft_safet.replace(R.id.sq_inquire, Sq_jc_fragment);
                ft_safet.commit();
                break;
        }

    }


}