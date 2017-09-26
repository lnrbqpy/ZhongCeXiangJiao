package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import hznj.com.zhongcexiangjiao.Fragment.Sq_jc_Fragment;
import hznj.com.zhongcexiangjiao.Fragment.Sq_lh_Fragment;
import hznj.com.zhongcexiangjiao.Fragment.Sq_mx_Fragment;
import hznj.com.zhongcexiangjiao.Fragment.Sq_zb_Fragment;
import hznj.com.zhongcexiangjiao.R;


public class SafetQuery_Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioButton         sq_gum;
    private RadioButton         sq_prepare;
    private RadioButton         sq_molding;
    private RadioButton         sq_vulcanize;
    private RadioGroup          sq_xuanze;
    private FrameLayout         sq_inquire;
    private FragmentTransaction transaction;
    private String              roleid;
    private Bundle              bundle1_sq;
    private String              userid;
    private FragmentManager     manager;
    private Sq_mx_Fragment      sq_mx_fragment;
    private Sq_lh_Fragment      sq_lh_fragment;
    private Sq_zb_Fragment      sq_zb_fragment;
    private Sq_jc_Fragment      sq_jc_fragment;

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
        sq_xuanze = (RadioGroup) findViewById(R.id.sq_xuanze);
        sq_inquire = (FrameLayout) findViewById(R.id.sq_inquire);

        sq_xuanze.setOnCheckedChangeListener(this);

        sq_molding.setChecked(true);

    }

    public void hideAllFragment(FragmentTransaction transaction) {
        if (sq_mx_fragment != null) {
            transaction.hide(sq_mx_fragment);
        }
        if (sq_lh_fragment != null) {
            transaction.hide(sq_lh_fragment);
        }
        if (sq_zb_fragment != null) {
            transaction.hide(sq_zb_fragment);
        }
        if (sq_jc_fragment != null) {
            transaction.hide(sq_jc_fragment);
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        transaction = getSupportFragmentManager().beginTransaction();
        bundle1_sq = new Bundle();
        bundle1_sq.putString("roleid", roleid);
        bundle1_sq.putString("userid", userid);
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.sq_molding:
                if (sq_mx_fragment == null) {
                    sq_mx_fragment = new Sq_mx_Fragment();
                    sq_mx_fragment.setArguments(bundle1_sq);
                    transaction.add(R.id.sq_inquire, sq_mx_fragment);
                } else {
                    transaction.show(sq_mx_fragment);
                }
                break;

            case R.id.sq_vulcanize:
                if (sq_lh_fragment == null) {
                    sq_lh_fragment = new Sq_lh_Fragment();
                    sq_lh_fragment.setArguments(bundle1_sq);
                    transaction.add(R.id.sq_inquire, sq_lh_fragment);
                } else {
                    transaction.show(sq_lh_fragment);
                }
                break;


            case R.id.sq_prepare:
                if (sq_zb_fragment == null) {
                    sq_zb_fragment = new Sq_zb_Fragment();
                    sq_zb_fragment.setArguments(bundle1_sq);
                    transaction.add(R.id.sq_inquire, sq_zb_fragment);
                } else {
                    transaction.show(sq_zb_fragment);
                }
                break;

            case R.id.sq_gum:
                if (sq_jc_fragment == null) {
                    sq_jc_fragment = new Sq_jc_Fragment();
                    sq_jc_fragment.setArguments(bundle1_sq);
                    transaction.add(R.id.sq_inquire, sq_jc_fragment);
                } else {
                    transaction.show(sq_jc_fragment);
                }
                break;
        }

        transaction.commit();
    }
}
