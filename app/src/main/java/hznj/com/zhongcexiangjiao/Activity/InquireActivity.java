package hznj.com.zhongcexiangjiao.Activity;
/**
 * 搜索结果显示界面
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import hznj.com.zhongcexiangjiao.Fragment.Fragment_examine;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_molding;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_semi_finished;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_vulcanize;
import hznj.com.zhongcexiangjiao.R;


public class InquireActivity extends FragmentActivity implements View.OnClickListener {


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire);
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
        gum = (RadioButton) findViewById(R.id.gum);
        prepare = (RadioButton) findViewById(R.id.prepare);
        molding = (RadioButton) findViewById(R.id.molding);
        vulcanize = (RadioButton) findViewById(R.id.vulcanize);
        rg_inquire = (RadioGroup) findViewById(R.id.rg_inquire);
        fl_inquire = (FrameLayout) findViewById(R.id.fl_inquire);

        gum.setOnClickListener(this);
        prepare.setOnClickListener(this);
        molding.setOnClickListener(this);
        vulcanize.setOnClickListener(this);

        // vp_inquire.setAdapter(mfpa);


    }

    @Override
    public void onClick(View v) {
        FragmentManager fm_inquire = getSupportFragmentManager();
        fragmentTransaction = fm_inquire.beginTransaction();
        bundle = new Bundle();
        bundle.putString("jiancha", bbarcode);
       /* if (gum.isChecked()==true) {
            Fragment_examine fragment_examine = new Fragment_examine();
            fragment_examine.setArguments(bundle);
            fragmentTransaction.replace(R.id.fl_inquire, fragment_examine);
            fragmentTransaction.commit();
            return;
        }else if (prepare.isChecked()==true) {
            Fragment_vulcanize fragment_vulcanize = new Fragment_vulcanize();
            fragment_vulcanize.setArguments(bundle);
            fragmentTransaction.replace(R.id.fl_inquire,fragment_vulcanize);
            fragmentTransaction.commit();
        } else if (molding.isChecked()==true) {
            Fragment_molding fragment_molding = new Fragment_molding();
            fragment_molding.setArguments(bundle);
            fragmentTransaction.replace(R.id.fl_inquire, fragment_molding);
            fragmentTransaction.commit();
        } else if (vulcanize.isChecked()==true) {
            Fragment_semi_finished fragment_semi_finished = new Fragment_semi_finished();
            fragment_semi_finished.setArguments(bundle);
            fragmentTransaction.replace(R.id.fl_inquire, fragment_semi_finished);
            fragmentTransaction.commit();
        }*/
        switch (v.getId()) {
            //这是重点  需要时可以从新使用 上面的全部作废
            case R.id.gum:
                Fragment_examine fragment_examine = new Fragment_examine();
                fragment_examine.setArguments(bundle);
                fragmentTransaction.replace(R.id.fl_inquire, fragment_examine);
                fragmentTransaction.commit();

                break;
            case R.id.prepare:
                Fragment_vulcanize fragment_vulcanize = new Fragment_vulcanize();
                fragment_vulcanize.setArguments(bundle);
                fragmentTransaction.replace(R.id.fl_inquire, fragment_vulcanize);
                fragmentTransaction.commit();

                break;
            case R.id.molding:
                Fragment_molding fragment_molding = new Fragment_molding();
                fragment_molding.setArguments(bundle);
                fragmentTransaction.replace(R.id.fl_inquire, fragment_molding);
                fragmentTransaction.commit();

                break;
            case R.id.vulcanize:
                Fragment_semi_finished fragment_semi_finished = new Fragment_semi_finished();
                fragment_semi_finished.setArguments(bundle);
                fragmentTransaction.replace(R.id.fl_inquire, fragment_semi_finished);
                fragmentTransaction.commit();

                break;


        }

    }




 /*   public class  myFragmentPagerAdapter extends FragmentPagerAdapter{

       private List<Fragment> listfragment; //创建一个List<Fragment>
        public myFragmentPagerAdapter(FragmentManager fm,List<Fragment> list) {
            super(fm);

            this.listfragment=list;
        }

        @Override
        public Fragment getItem(int position) {
            return listfragment.get(position);
        }

        @Override
        public int getCount() {
            return listfragment.size();
        }
    }*/

}
