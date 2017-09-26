package hznj.com.zhongcexiangjiao.Activity;
/**
 * 搜索结果显示界面
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import hznj.com.zhongcexiangjiao.Fragment.Fragment_examine;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_molding;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_semi_finished;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_vulcanize;
import hznj.com.zhongcexiangjiao.R;


public class Inquire2Activity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {


    private RadioButton gum;
    private RadioButton prepare;
    private RadioButton molding;
    private RadioButton vulcanize;

    private FrameLayout fl_inquire;
    private Fragment    f_1;
    private Fragment    f_2;
    private Fragment    f_3;

    private String              bbarcode;
    private FragmentTransaction fragmentTransaction;
    private RadioGroup          rg_inquire;
    private Bundle              bundle;
    private int                 mIndex;
    private ViewPager           mViewPager;
    private List<Fragment> lsitfragment = new ArrayList<>();
    private Fragment_examine       fragment_examine;
    private Fragment_vulcanize     fragment_vulcanize;
    private Fragment_molding       fragment_molding;
    private Fragment_semi_finished fragment_semi_finished;
    private Fragment[]             mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        bbarcode = bundle.getString("chengxing");
        if (bbarcode == null) {
            bbarcode = "0";
        }

        // String key = bundle.getString("key");
        //Log.i("key",key);
        initView();


    }

    private void initView() {
        gum = (RadioButton) findViewById(R.id.gum2);
        prepare = (RadioButton) findViewById(R.id.prepare2);
        molding = (RadioButton) findViewById(R.id.molding2);
        vulcanize = (RadioButton) findViewById(R.id.vulcanize2);
        rg_inquire = (RadioGroup) findViewById(R.id.rg_inquire2);
        fl_inquire = (FrameLayout) findViewById(R.id.fl2_inquire);

        rg_inquire.setOnCheckedChangeListener(this);
        gum.setChecked(true);

    }

    public void hideAllFragment(FragmentTransaction transaction) {
        if (fragment_examine != null) {
            transaction.hide(fragment_examine);
        }
        if (fragment_vulcanize != null) {
            transaction.hide(fragment_vulcanize);
        }
        if (fragment_molding != null) {
            transaction.hide(fragment_molding);
        }
        if (fragment_semi_finished != null) {
            transaction.hide(fragment_semi_finished);
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        bundle = new Bundle();
        bundle.putString("jiancha", bbarcode);
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.gum2:
                if (fragment_examine == null) {
                    fragment_examine = new Fragment_examine();
                    fragment_examine.setArguments(bundle);
                    transaction.add(R.id.fl2_inquire, fragment_examine);
                } else {
                    transaction.show(fragment_examine);
                }
                break;
            case R.id.vulcanize2:
                if (fragment_vulcanize == null) {
                    fragment_vulcanize = new Fragment_vulcanize();
                    fragment_vulcanize.setArguments(bundle);
                    transaction.add(R.id.fl2_inquire, fragment_vulcanize);
                } else {
                    transaction.show(fragment_vulcanize);
                }
                break;
            case R.id.molding2:
                if (fragment_molding == null) {
                    fragment_molding = new Fragment_molding();
                    fragment_molding.setArguments(bundle);
                    transaction.add(R.id.fl2_inquire, fragment_molding);
                } else {
                    transaction.show(fragment_molding);
                }
                break;
            case R.id.prepare2:
                if (fragment_semi_finished == null) {
                    fragment_semi_finished = new Fragment_semi_finished();
                    fragment_semi_finished.setArguments(bundle);
                    transaction.add(R.id.fl2_inquire, fragment_semi_finished);
                } else {
                    transaction.show(fragment_semi_finished);
                }
                break;
        }
        transaction.commit();
    }


}
