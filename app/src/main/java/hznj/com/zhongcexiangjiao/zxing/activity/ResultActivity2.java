package hznj.com.zhongcexiangjiao.zxing.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import hznj.com.zhongcexiangjiao.Activity.InquireActivity;
import hznj.com.zhongcexiangjiao.Activity.bzpChaXunActivity;
import hznj.com.zhongcexiangjiao.Activity.jlChaXunActivity;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.zxing.decode.DecodeThread;


public class ResultActivity2 extends Activity implements View.OnClickListener{

	private ImageView   mResultImage;
	private TextView    mResultText;
	private Button   btn_chaxun;
	private RadioButton rb_chengxing;
	private RadioButton rb_banzhipin;
	private RadioButton rb_jiaoliao;
	private RadioGroup  rg_tiaozhuan;
	private String      result;
	private Bundle extras;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		extras = getIntent().getExtras();

	    initView();

		initData();

	}

	private void initView() {

		mResultImage = (ImageView) findViewById(R.id.result_image);
		mResultText = (TextView) findViewById(R.id.result_text);
		btn_chaxun = (Button) findViewById(R.id.btn_chaxun);
		rb_chengxing = (RadioButton) findViewById(R.id.rb_chengxing);
		rb_banzhipin = (RadioButton) findViewById(R.id.rb_banzhipin);
		rb_jiaoliao = (RadioButton) findViewById(R.id.rb_jiaoliao);
		rg_tiaozhuan = (RadioGroup) findViewById(R.id.rg_tiaozhuan);

		btn_chaxun.setOnClickListener(this);
	}

	private void initData() {
		if (null != extras) {
			int width = extras.getInt("width");
			int height = extras.getInt("height");

			LayoutParams lps = new LayoutParams(width, height);
			lps.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
			lps.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
			lps.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());

			mResultImage.setLayoutParams(lps);

			result = extras.getString("result");
			mResultText.setText(result);

			Bitmap barcode = null;
			byte[] compressedBitmap = extras.getByteArray(DecodeThread.BARCODE_BITMAP);
			if (compressedBitmap != null) {
				barcode = BitmapFactory.decodeByteArray(compressedBitmap, 0, compressedBitmap.length, null);
				// Mutable copy:
				barcode = barcode.copy(Bitmap.Config.RGB_565, true);
			}

			mResultImage.setImageBitmap(barcode);
		}


	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.btn_chaxun:
				if (rb_chengxing.isChecked()==true) {
					Intent intent1 = new Intent();
					intent1.setClass(this, InquireActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("chengxing", result);
					intent1.putExtras(bundle);
					startActivity(intent1);
					       return;

				}else if (rb_banzhipin.isChecked()==true) {
					Intent intent1 = new Intent();
					intent1.setClass(this, bzpChaXunActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("chengxing", result);
					intent1.putExtras(bundle);
					startActivity(intent1);
					return;
				} else if (rb_jiaoliao.isChecked()==true) {
					Intent intent1 = new Intent();
					intent1.setClass(this, jlChaXunActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("chengxing", result);
					intent1.putExtras(bundle);
					startActivity(intent1);
				}



		}

	}
}
