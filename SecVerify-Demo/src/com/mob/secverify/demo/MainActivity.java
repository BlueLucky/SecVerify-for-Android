package com.mob.secverify.demo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.secverify.SecVerify;
import com.mob.secverify.OperationCallback;
import com.mob.secverify.VerifyCallback;
import com.mob.secverify.datatype.UiSettings;
import com.mob.secverify.datatype.VerifyResult;
import com.mob.secverify.demo.entity.LoginResult;
import com.mob.secverify.demo.exception.DemoException;
import com.mob.secverify.demo.login.LoginTask;
import com.mob.secverify.demo.ui.component.CommonProgressDialog;
import com.mob.secverify.demo.util.Const;
import com.mob.secverify.exception.VerifyException;
import com.mob.secverify.ui.component.VerifyCommonButton;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends BaseActivity {
	private static final String TAG = "MainActivity";
	private static final int REQUEST_CODE = 1001;
	private GifImageView logoIv;
	private VerifyCommonButton oneKeyLoginBtn;
	private VerifyCommonButton verifyBtn;
	private TextView versionTv;

	@Override
	protected int getContentViewId() {
		return R.layout.activity_main;
	}

	@Override
	protected void getTitleStyle(TitleStyle titleStyle) {
		titleStyle.showLeft = false;
	}

	@Override
	protected void onViewCreated() {

		initView();
		checkPermissions();
		// 建议提早调用该接口进行预登录，这将极大地加快验证流程
		preVerify(true);
	}

	@Override
	protected void onViewClicked(View v) {
		int id = v.getId();
		switch (id) {
			case R.id.sec_verify_demo_main_verify: {
				verify();
				break;
			}
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_CODE) {
			// Demo为了演示效果，从验证成功页面返回时可以重复验证，因此在onActivityResult中再次做预登录
			preVerify(false);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	private void initView() {
		logoIv = findViewById(R.id.sec_verify_demo_main_logo);
		oneKeyLoginBtn = findViewById(R.id.sec_verify_demo_main_one_key_login);
		verifyBtn = findViewById(R.id.sec_verify_demo_main_verify);
		versionTv = findViewById(R.id.sec_verify_demo_main_version);
		versionTv.setText(SecVerify.getVersion());

		logoIv.setImageResource(R.drawable.sec_verify_demo_tradition);
		oneKeyLoginBtn.setOnClickListener(this);
		verifyBtn.setOnClickListener(this);
	}

	/* 检查使用权限 */
	private void checkPermissions() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			try {
				PackageManager pm = getPackageManager();
				PackageInfo pi = pm.getPackageInfo(getPackageName(), PackageManager.GET_PERMISSIONS);
				ArrayList<String> list = new ArrayList<String>();
				for (String p : pi.requestedPermissions) {
					if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
						list.add(p);
					}
				}
				if (list.size() > 0) {
					String[] permissions = list.toArray(new String[list.size()]);
					if (permissions != null) {
						requestPermissions(permissions, 1);
					}
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}


	/**
	 * 预登录
	 *
	 * 建议提前调用预登录接口，可以加快免密登录过程，提高用户体验
	 */
	private void preVerify(final boolean init) {
		SecVerify.preVerify(new OperationCallback() {
			@Override
			public void onComplete(Object data) {
				// Nothing to do
				Toast.makeText(MainActivity.this, "预登录成功", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onFailure(VerifyException e) {
				// Nothing to do
				if (!init) {
					Toast.makeText(MainActivity.this, "预登录失败", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	/**
	 * 免密登录
	 */
	private void verify() {
		customizeUi();

		SecVerify.verify(new VerifyCallback() {
			@Override
			public void onOtherLogin() {
				// 用户点击“其他登录方式”，处理自己的逻辑
				Toast.makeText(MainActivity.this, "其他账号登录", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onComplete(VerifyResult data) {
				if (data != null) {
					Log.d(TAG, data.toJSONString());
					// 获取授权码成功，将token信息传给应用服务端，再由应用服务端进行登录验证，此功能需由开发者自行实现
					CommonProgressDialog.showProgressDialog(MainActivity.this);
					LoginTask.getInstance().login(data, new ResultListener<com.mob.secverify.demo.entity.LoginResult>() {
						@Override
						public void onComplete(com.mob.secverify.demo.entity.LoginResult data) {
							CommonProgressDialog.dismissProgressDialog();
							Log.d(TAG, "Login success. data: " + data.toJSONString());
							vibrate();
							// 服务端登录成功，跳转成功页
							gotoSuccessActivity(data);
						}

						@Override
						public void onFailure(DemoException e) {
							// 登录失败
							Log.e(TAG, "login failed", e);
							CommonProgressDialog.dismissProgressDialog();
							// 错误码
							int errCode = e.getCode();
							// 错误信息
							String errMsg = e.getMessage();
							// 更详细的网络错误信息可以通过t查看，请注意：t有可能为null
							Throwable t = e.getCause();
							String errDetail = null;
							if (t != null) {
								errDetail = t.getMessage();
							}

							String msg = "获取授权码成功，应用服务器登录失败" + "\n错误信息: " + errMsg;
							if (!TextUtils.isEmpty(errDetail)) {
								msg += "\n详细信息: " + errDetail;
							}
							Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
						}
					});
				}
			}

			@Override
			public void onFailure(VerifyException e) {
				// 登录失败
				Log.e(TAG, "verify failed", e);
				// 错误码
				int errCode = e.getCode();
				// 错误信息
				String errMsg = e.getMessage();
				// 更详细的网络错误信息可以通过t查看，请注意：t有可能为null
				Throwable t = e.getCause();
				String errDetail = null;
				if (t != null) {
					errDetail = t.getMessage();
				}

				String msg = "错误信息: " + errMsg;
				if (!TextUtils.isEmpty(errDetail)) {
					msg += "\n详细信息: " + errDetail;
				}
				Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
			}
		});
	}

	/**
	 * 自定义授权页面UI样式
	 */
	private void customizeUi() {
		UiSettings uiSettings = new UiSettings.Builder()
				/** 标题栏 */
				// 标题栏背景色资源ID
				.setNavColorId(R.color.sec_verify_demo_common_bg)
				// 标题栏标题文字资源ID
//				.setNavTextId(R.string.sec_verify_demo_verify)
				// 标题栏文字颜色资源ID
//				.setNavTextColorId(R.color.sec_verify_demo_text_color_common_black)
				// 标题栏左侧关闭按钮图片资源ID
				.setNavCloseImgId(R.drawable.sec_verify_demo_close)
				/** Logo */
				// Logo图片资源ID，默认使用应用图标
				.setLogoImgId(R.drawable.ic_launcher)
				/** 手机号 */
				// 脱敏手机号字体颜色资源ID
				.setNumberColorId(R.color.sec_verify_demo_text_color_common_black)
				// 脱敏手机号字体大小资源ID
				.setNumberSizeId(R.dimen.sec_verify_demo_text_size_m)
				/** 切换帐号 */
				// 切换账号字体颜色资源ID
				.setSwitchAccColorId(R.color.sec_verify_demo_text_color_blue)
				// 切换账号是否显示，默认显示
				.setSwitchAccHidden(false)
				/** 登录按钮 */
				// 登录按钮背景图资源ID，建议使用shape
				.setLoginBtnImgId(R.drawable.sec_verify_demo_shape_rectangle)
				// 登录按钮文字资源ID
				.setLoginBtnTextId(R.string.sec_verify_demo_login)
				// 登录按钮字体颜色资源ID
				.setLoginBtnTextColorId(R.color.sec_verify_demo_text_color_common_white)
				/** 隐私协议 */
				// 隐私协议复选框背景图资源ID，建议使用selector
				.setCheckboxImgId(R.drawable.sec_verify_demo_customized_checkbox_selector)
				// 隐私协议复选框默认状态，默认为“选中”
				.setCheckboxDefaultState(true)
				// 隐私协议字体颜色资源ID（自定义隐私协议的字体颜色也受该值影响）
				.setAgreementColorId(R.color.sec_verify_demo_main_color)
//				// 自定义隐私协议一文字资源ID（移动&电信）
//				.setCusAgreementNameId1(R.string.sec_verify_demo_customize_agreement_name_1)
//				// 自定义隐私协议一控件ID（联通）
//				.setCuccAgreementComponentId1(R.id.customize_agreement_1)
//				// 自定义隐私协议一URL
//				.setCusAgreementUrl1("http://www.baidu.com")
//				// 自定义隐私协议二文字资源ID（移动&电信）
//				.setCusAgreementNameId2(R.string.sec_verify_demo_customize_agreement_name_2)
//				// 自定义隐私协议二控件ID（联通）
//				.setCuccAgreementComponentId2(R.id.customize_agreement_2)
//				// 自定义隐私协议二URL
//				.setCusAgreementUrl2("https://www.jianshu.com")
				.build();
		SecVerify.setUiSettings(uiSettings);
	}

	private void gotoSuccessActivity(LoginResult data) {
		Intent i = new Intent(this, SuccessActivity.class);
		i.putExtra(Const.EXTRAS_DEMO_LOGIN_RESULT, data);
		startActivityForResult(i, REQUEST_CODE);
	}

	private void vibrate() {
		Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
		if (vibrator != null) {
			if (android.os.Build.VERSION.SDK_INT >= 26) {
				VibrationEffect vibrationEffect = VibrationEffect.createOneShot(500, 20);
				vibrator.vibrate(vibrationEffect);
			} else {
				vibrator.vibrate(500);
			}
		}
	}
}
