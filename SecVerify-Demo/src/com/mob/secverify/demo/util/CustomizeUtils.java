package com.mob.secverify.demo.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mob.secverify.datatype.UiSettings;
import com.mob.secverify.demo.R;
import com.mob.tools.utils.ResHelper;

import java.util.ArrayList;
import java.util.List;

public class CustomizeUtils {
	public static UiSettings customizeUi(){
		return new UiSettings.Builder()
				/** 标题栏 */
				// 标题栏背景色资源ID
				.setNavColorId(R.color.sec_verify_demo_text_color_blue)
				//标题栏是否透明
				.setNavTransparent(true)
				//标题栏是否隐藏
				.setNavHidden(false)
				//设置背景图片
//				.setBackgroundImgId(R.drawable.sec_verify_background_demo)
				//设置背景是否点击关闭页面
//				.setBackgroundClickClose(false)
				// 标题栏标题文字资源ID
//				.setNavTextId(R.string.sec_verify_demo_verify)
				// 标题栏文字颜色资源ID
//				.setNavTextColorId(R.color.sec_verify_demo_text_color_common_black)
				// 标题栏左侧关闭按钮图片资源ID
				.setNavCloseImgId(R.drawable.sec_verify_demo_close)
				//标题栏返回按钮是否隐藏
				.setNavCloseImgHidden(false)
				/** Logo */
				// Logo图片资源ID，默认使用应用图标
				.setLogoImgId(R.drawable.ic_launcher)
				//logo是否隐藏
				.setLogoHidden(false)
//				//logo宽度
				.setLogoWidth(R.dimen.sec_verify_demo_logo_width)
				//logo高度
				.setLogoHeight(R.dimen.sec_verify_demo_logo_height)
				//logo x轴偏移量
//				.setLogoOffsetX(R.dimen.sec_verify_demo_logo_offset_x)
				//logo y轴偏移量
//				.setLogoOffsetY(R.dimen.sec_verify_demo_logo_offset_y)
				/** 手机号 */
				// 脱敏手机号字体颜色资源ID
				.setNumberColorId(R.color.sec_verify_demo_text_color_common_black)
				// 脱敏手机号字体大小资源ID
				.setNumberSizeId(R.dimen.sec_verify_demo_text_size_m)
				//脱敏手机号 x轴偏移量
//				.setNumberOffsetX(R.dimen.sec_verify_demo_number_field_offset_x)
				//脱敏手机号 y轴偏移量
//				.setNumberOffsetY(R.dimen.sec_verify_demo_number_field_offset_y)
				/** 切换帐号 */
				// 切换账号字体颜色资源ID
				.setSwitchAccColorId(R.color.sec_verify_demo_text_color_blue)
				//切换账号 字体大小
				.setSwitchAccTextSize(R.dimen.sec_verify_demo_text_size_s)
				// 切换账号是否显示，默认显示
				.setSwitchAccHidden(false)
				//切换账号 x轴偏移量
//				.setSwitchAccOffsetX(R.dimen.sec_verify_demo_switch_acc_offset_x)
				//切换账号 y轴偏移量
//				.setSwitchAccOffsetY(R.dimen.sec_verify_demo_switch_acc_offset_y)

				/** 登录按钮 */
				// 登录按钮背景图资源ID，建议使用shape
				.setLoginBtnImgId(R.drawable.sec_verify_demo_shape_rectangle)
				// 登录按钮文字资源ID
				.setLoginBtnTextId(R.string.sec_verify_demo_login)
				// 登录按钮字体颜色资源ID
				.setLoginBtnTextColorId(R.color.sec_verify_demo_text_color_common_white)
				//登录按钮字体大小
				.setLoginBtnTextSize(R.dimen.sec_verify_demo_text_size_s)
				//登录按钮 width
//				.setLoginBtnWidth(R.dimen.sec_verify_demo_login_btn_width)
				//登录按钮 height
//				.setLoginBtnHeight(R.dimen.sec_verify_demo_login_btn_height)
				//登录按钮 x轴偏移
//				.setLoginBtnOffsetX(R.dimen.sec_verify_demo_login_btn_offset_x)
				//登录按钮 y轴偏移
//				.setLoginBtnOffsetY(R.dimen.sec_verify_demo_login_btn_offset_y)
				/** 隐私协议 */
				//是否隐藏复选框(设置此属性true时setCheckboxDefaultState不会生效)
				.setCheckboxHidden(false)
				// 隐私协议复选框背景图资源ID，建议使用selector
				.setCheckboxImgId(R.drawable.sec_verify_demo_customized_checkbox_selector)
				// 隐私协议复选框默认状态，默认为“选中”
				.setCheckboxDefaultState(true)
				// 隐私协议字体颜色资源ID（自定义隐私协议的字体颜色也受该值影响）
				.setAgreementColorId(R.color.sec_verify_demo_main_color)
				// 自定义隐私协议一文字资源ID
//				.setCusAgreementNameId1(R.string.sec_verify_demo_customize_agreement_name_1)
//				// 自定义隐私协议一URL
//				.setCusAgreementUrl1("http://www.baidu.com")
////				自定义隐私协议一颜色
//                .setCusAgreementColor1(R.color.sec_verify_demo_main_color)
//				// 自定义隐私协议二文字资源ID
//				.setCusAgreementNameId2(R.string.sec_verify_demo_customize_agreement_name_2)
//				// 自定义隐私协议二URL
//				.setCusAgreementUrl2("https://www.jianshu.com")
				//自定义隐私协议二颜色
//                .setCusAgreementColor2(R.color.sec_verify_demo_main_color)
				//隐私协议是否左对齐，默认居中
				.setAgreementGravityLeft(false)
				//隐私协议其他文字颜色
				.setAgreementBaseTextColorId(R.color.sec_verify_demo_text_color_common_black)
				//隐私协议 x轴偏移量，默认30dp
				.setAgreementOffsetX(R.dimen.sec_verify_demo_agreement_offset_x)
				//隐私协议 rightMargin右偏移量，默认30dp
				.setAgreementOffsetRightX(R.dimen.sec_verify_demo_agreement_offset_x)
				//隐私协议 y轴偏移量
//				.setAgreementOffsetY(R.dimen.sec_verify_demo_agreement_offset_y)
				//隐私协议 底部y轴偏移量
//				.setAgreementOffsetBottomY(R.dimen.sec_verify_demo_agreement_offset_bottom_y)
				/** slogan */
				//slogan文字大小
				.setSloganTextSize(R.dimen.sec_verify_demo_text_size_xs)
				//slogan文字颜色
				.setSloganTextColor(R.color.sec_verify_demo_text_color_common_gray)
				//slogan x轴偏移量
//				.setSloganOffsetX(R.dimen.sec_verify_demo_slogan_offset_x)
				//slogan y轴偏移量
//				.setSloganOffsetY(R.dimen.sec_verify_demo_slogan_offset_y)
				//slogan 底部y轴偏移量(设置此属性时，setSloganOffsetY不生效)
//				.setSloganOffsetBottomY(R.dimen.sec_verify_demo_slogan_offset_bottom_y)
				//设置状态栏为透明状态栏，5.0以上生效
				.setImmersiveTheme(false)
				//设置状态栏文字颜色为黑色，只在6.0以上生效
				.setImmersiveStatusTextColorBlack(false)
				//使用平移动画
				.setTranslateAnim(true)
				//设置隐私协议文字起始
				.setAgreementTextStart(R.string.sec_verify_demo_agreement_text_start)
				//设置隐私协议文字连接
				.setAgreementTextAnd1(R.string.sec_verify_demo_agreement_text_and1)
				//设置隐私协议文字连接
				.setAgreementTextAnd2(R.string.sec_verify_demo_agreement_text_and2)
				//设置隐私协议文字结束
				.setAgreementTextEnd(R.string.sec_verify_demo_agreement_text_end)
				//设置移动隐私协议文字
				.setAgreementCmccText(R.string.sec_verify_demo_agreement_text_cmcc)
				//设置联通隐私协议文字
				.setAgreementCuccText(R.string.sec_verify_demo_agreement_text_cucc)
				//设置电信隐私协议文字
				.setAgreementCtccText(R.string.sec_verify_demo_agreement_text_ctcc)
				.build();
	}


	public static UiSettings customizeUi1(){
		return new UiSettings.Builder()
				/** 标题栏 */
				// 标题栏背景色资源ID
				.setNavColorId(R.color.sec_verify_demo_text_color_blue)
				//标题栏是否透明
				.setNavTransparent(true)
				//标题栏是否隐藏
				.setNavHidden(false)
				//设置背景图片
//				.setBackgroundImgId(R.drawable.sec_verify_background_demo)
				//设置背景是否点击关闭页面
				.setBackgroundClickClose(false)
				// 标题栏标题文字资源ID
				.setNavTextId(R.string.sec_verify_demo_verify)
				//标题栏文字大小
				.setNavTextSize(R.dimen.sec_verify_demo_text_size_s)
				// 标题栏文字颜色资源ID
				.setNavTextColorId(R.color.sec_verify_demo_text_color_common_black)
				// 标题栏左侧关闭按钮图片资源ID
				.setNavCloseImgId(R.drawable.sec_verify_demo_close)
				//标题栏返回按钮是否隐藏
				.setNavCloseImgHidden(false)
				/** Logo */
				// Logo图片资源ID，默认使用应用图标
				.setLogoImgId(R.drawable.ic_launcher)
				//logo是否隐藏
				.setLogoHidden(false)
//				//logo宽度
				.setLogoWidth(R.dimen.sec_verify_demo_logo_width_customize)
				//logo高度
				.setLogoHeight(R.dimen.sec_verify_demo_logo_height_customize)
				//logo x轴偏移量
				.setLogoOffsetX(R.dimen.sec_verify_demo_logo_offset_x_customize)
				//logo y轴偏移量
				.setLogoOffsetY(R.dimen.sec_verify_demo_logo_offset_y_customize)
				//logo x轴右偏移量
				.setLogoOffsetRightX(R.dimen.sec_verify_demo_logo_offset_right_x_customize)
				//logo 是否靠屏幕右边
				.setLogoAlignParentRight(false)
				/** 手机号 */
				// 脱敏手机号字体颜色资源ID
				.setNumberColorId(R.color.sec_verify_demo_text_color_common_black)
				// 脱敏手机号字体大小资源ID
				.setNumberSizeId(R.dimen.sec_verify_demo_text_size_m)
				//脱敏手机号 x轴偏移量
				.setNumberOffsetX(R.dimen.sec_verify_demo_number_field_offset_x_customize)
				//脱敏手机号 y轴偏移量
				.setNumberOffsetY(R.dimen.sec_verify_demo_number_field_offset_y_customize)
				//脱敏手机号 x轴右偏移量
				.setNumberOffsetRightX(R.dimen.sec_verify_demo_number_field_offset_right_x_customize)
				//脱敏手机号 是否靠屏幕右边
				.setNumberAlignParentRight(true)
				/** 切换帐号 */
				// 切换账号字体颜色资源ID
				.setSwitchAccColorId(R.color.sec_verify_demo_text_color_blue)
				//切换账号 字体大小
				.setSwitchAccTextSize(R.dimen.sec_verify_demo_text_size_s)
				// 切换账号是否显示，默认显示
				.setSwitchAccHidden(false)
				//切换账号 x轴偏移量
				.setSwitchAccOffsetX(R.dimen.sec_verify_demo_switch_acc_offset_x_customize)
				//切换账号 y轴偏移量
				.setSwitchAccOffsetY(R.dimen.sec_verify_demo_switch_acc_offset_y_customize)
				////切换账号 文本内容
				.setSwitchAccText(R.string.sec_verify_demo_other_login)
				//脱敏手机号 x轴右偏移量
				.setSwitchAccOffsetRightX(R.dimen.sec_verify_demo_switch_acc_offset_right_x_customize)
				//脱敏手机号 是否靠屏幕右边
				.setSwitchAccAlignParentRight(true)
				/** 登录按钮 */
				// 登录按钮背景图资源ID，建议使用shape
				.setLoginBtnImgId(R.drawable.sec_verify_demo_shape_rectangle)
				// 登录按钮文字资源ID
				.setLoginBtnTextId(R.string.sec_verify_demo_login)
				// 登录按钮字体颜色资源ID
				.setLoginBtnTextColorId(R.color.sec_verify_demo_text_color_common_white)
				//登录按钮字体大小
				.setLoginBtnTextSize(R.dimen.sec_verify_demo_text_size_s)
				//登录按钮 width
				.setLoginBtnWidth(R.dimen.sec_verify_demo_login_btn_width_customize)
				//登录按钮 height
				.setLoginBtnHeight(R.dimen.sec_verify_demo_login_btn_height_customize)
				//登录按钮 x轴偏移
				.setLoginBtnOffsetX(R.dimen.sec_verify_demo_login_btn_offset_x_customize)
				//登录按钮 y轴偏移
				.setLoginBtnOffsetY(R.dimen.sec_verify_demo_login_btn_offset_y_customize)
				//登录按钮 x轴右偏移
				.setLoginBtnOffsetRightX(R.dimen.sec_verify_demo_login_btn_offset_right_x_customize)
				//登录按钮 靠屏幕右边
				.setLoginBtnAlignParentRight(true)
				/** 隐私协议 */
				//是否隐藏复选框(设置此属性true时setCheckboxDefaultState不会生效)
				.setCheckboxHidden(false)
				// 隐私协议复选框背景图资源ID，建议使用selector
				.setCheckboxImgId(R.drawable.sec_verify_demo_customized_checkbox_selector)
				// 隐私协议复选框默认状态，默认为“选中”
				.setCheckboxDefaultState(true)
				// 隐私协议字体颜色资源ID（自定义隐私协议的字体颜色也受该值影响）
				.setAgreementColorId(R.color.sec_verify_demo_main_color)
				// 自定义隐私协议一文字资源ID
				.setCusAgreementNameId1(R.string.sec_verify_demo_customize_agreement_name_1)
				// 自定义隐私协议一URL
				.setCusAgreementUrl1("http://www.baidu.com")
//				自定义隐私协议一颜色
				.setCusAgreementColor1(R.color.sec_verify_demo_main_color)
				// 自定义隐私协议二文字资源ID
				.setCusAgreementNameId2(R.string.sec_verify_demo_customize_agreement_name_2)
				// 自定义隐私协议二URL
				.setCusAgreementUrl2("https://www.jianshu.com")
				//自定义隐私协议二颜色
				.setCusAgreementColor2(R.color.sec_verify_demo_main_color)
				//隐私协议是否左对齐，默认居中
				.setAgreementGravityLeft(true)
				//隐私协议其他文字颜色
				.setAgreementBaseTextColorId(R.color.sec_verify_demo_text_color_common_black)
				//隐私协议 x轴偏移量，默认30
				.setAgreementOffsetX(R.dimen.sec_verify_demo_agreement_offset_x_customize)
				//隐私协议 x轴rightMargin右偏移量，默认30
				.setAgreementOffsetRightX(R.dimen.sec_verify_demo_agreement_offset_x_customize)
				//隐私协议 y轴偏移量
				.setAgreementOffsetY(R.dimen.sec_verify_demo_agreement_offset_y_customize)
				//隐私协议 底部y轴偏移量
//				.setAgreementOffsetBottomY(R.dimen.sec_verify_demo_agreement_offset_bottom_y_customize)
				//隐私协议 靠屏幕右边
				.setAgreementAlignParentRight(true)
				//隐私协议 文字大小
				.setAgreementTextSize(R.dimen.sec_verify_demo_text_size_s)
				/** slogan */
				//slogan文字大小
				.setSloganTextSize(R.dimen.sec_verify_demo_text_size_s)
				//slogan文字颜色
				.setSloganTextColor(R.color.sec_verify_demo_main_color)
				//slogan x轴偏移量
//				.setSloganOffsetX(R.dimen.sec_verify_demo_slogan_offset_x_customize)
				//slogan y轴偏移量
				.setSloganOffsetY(R.dimen.sec_verify_demo_slogan_offset_y_customize)
				//slogan 底部y轴偏移量(设置此属性时，setSloganOffsetY不生效)
//				.setSloganOffsetBottomY(R.dimen.sec_verify_demo_slogan_offset_bottom_y_customize)
				//slogan x轴右偏移量
//				.setSloganOffsetRightX(R.dimen.sec_verify_demo_slogan_offset_right_x_customize)
				//slogan 靠屏幕右边
//				.setSloganAlignParentRight(true)
				//设置状态栏为透明状态栏，5.0以上生效
				.setImmersiveTheme(true)
				//设置状态栏文字颜色为黑色，只在6.0以上生效
				.setImmersiveStatusTextColorBlack(true)
				.setZoomAnim(true)
				.setBackgroundClickClose(true)
				.build();
	}

	public static UiSettings customizeUi2(){
		return new UiSettings.Builder()
				.setLogoOffsetBottomY(R.dimen.sec_verify_demo_logo_offset_bottom_y_customize)
				.setNumberOffsetBottomY(R.dimen.sec_verify_demo_number_offset_bottom_y_customize)
				.setSwitchAccOffsetBottomY(R.dimen.sec_verify_demo_switch_acc_offset_bottom_y_customize)
				.setLoginBtnOffsetBottomY(R.dimen.sec_verify_demo_login_btn_offset_bottom_y_customize)
				.setNumberOffsetRightX(R.dimen.sec_verify_demo_number_field_offset_right_x_customize)
				.setSwitchAccOffsetRightX(R.dimen.sec_verify_demo_switch_acc_offset_right_x_customize)
				.setLoginBtnOffsetRightX(R.dimen.sec_verify_demo_login_btn_offset_right_x_customize)
				.setLoginBtnOffsetX(R.dimen.sec_verify_demo_login_btn_offset_right_x_customize)
				.setSloganOffsetRightX(R.dimen.sec_verify_demo_slogan_offset_right_x_customize)
				.setNumberAlignParentRight(true)
				.setSwitchAccAlignParentRight(true)
				.setAgreementAlignParentRight(false)
				.setLoginBtnAlignParentRight(true)
				.setSloganAlignParentRight(true)
				.setBackgroundClickClose(true)
				.setImmersiveTheme(false)
				//设置状态栏文字颜色为黑色，只在6.0以上生效
				.setImmersiveStatusTextColorBlack(false)
				.setDialogMaskBackgroundClickClose(true)
				.setStartActivityTransitionAnim(R.anim.translate_bottom_in, R.anim.translate_bottom_out)
				.setFinishActivityTransitionAnim(R.anim.translate_bottom_in, R.anim.translate_bottom_out)
				.setDialogTheme(true)
				.setDialogAlignBottom(true)
				.build();
	}

	public static UiSettings customizeUi3(){
		return new UiSettings.Builder()
				.setNavHidden(true)
				.setLogoHidden(true)
				.setNumberHidden(true)
				.setSwitchAccHidden(true)
				.setLoginBtnHidden(true)
				.setAgreementHidden(true)
				.setSloganHidden(true)
				.build();
	}

	public static UiSettings customizeUi4(){
		return new UiSettings.Builder()
				.setNavCloseImgOffsetRightX(R.dimen.sec_verify_demo_nav_close_img_offset_right_x_customize)
				.setDialogMaskBackgroundClickClose(true)
				.setFadeAnim(true)
				.setBackgroundImgId(R.drawable.sec_verify_background_demo_dialog)
				.setDialogTheme(true)
				.setDialogAlignBottom(false)
				.setDialogWidth(R.dimen.sec_verify_demo_dialog_width)
				.setDialogHeight(R.dimen.sec_verify_demo_dialog_height)
				.setDialogOffsetX(R.dimen.sec_verify_demo_dialog_offset_x)
				.setDialogOffsetY(R.dimen.sec_verify_demo_dialog_offset_y)
				.build();
	}

	public static List<View> buildCustomView(Context context){
		TextView view = new TextView(context);
		view.setId(R.id.customized_view_id);
		view.setText("其他方式登录");
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.bottomMargin = ResHelper.dipToPx(context,120);
		view.setLayoutParams(params);

		ImageView iv1 = new ImageView(context);
		iv1.setId(R.id.customized_btn_id_1);
		iv1.setImageDrawable(context.getResources().getDrawable(R.drawable.sec_verify_demo_wechat));
		RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params1.addRule(RelativeLayout.CENTER_HORIZONTAL);
		params1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params1.bottomMargin = ResHelper.dipToPx(context,80);
		iv1.setLayoutParams(params1);

		List<View> views = new ArrayList<View>();
		views.add(view);
		views.add(iv1);
		return views;
	}
	public static List<View> buildCustomView2(Context context){
		View view = new View(context);
		view.setId(R.id.customized_view_id);
		view.setBackground(context.getResources().getDrawable(R.drawable.sec_verify_background));
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);
		params.topMargin = ResHelper.dipToPx(context,260);
		view.setLayoutParams(params);


		// 自定义按钮1
		ImageView btn1 = new ImageView(context);
		btn1.setId(R.id.customized_btn_id_1);
		btn1.setImageDrawable(context.getResources().getDrawable(R.drawable.sec_verify_demo_close));
		RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params1.topMargin = ResHelper.dipToPx(context,280);
		params1.leftMargin = ResHelper.dipToPx(context,15);
		btn1.setLayoutParams(params1);

		List<View> views = new ArrayList<View>();
		views.add(view);
		views.add(btn1);
		return views;
	}
	public static List<View> buildCustomView3(Context context){


		ImageView iv0 = new ImageView(context);
		iv0.setId(R.id.customized_btn_id_0);
		iv0.setImageDrawable(context.getResources().getDrawable(R.drawable.sec_verify_demo_close));
		RelativeLayout.LayoutParams params0 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params0.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		params0.topMargin = ResHelper.dipToPx(context,15);
		params0.leftMargin = ResHelper.dipToPx(context,15);
		iv0.setLayoutParams(params0);


		EditText et1 = new EditText(context);
		et1.setId(R.id.customized_et_id_0);
		et1.setBackground(null);
		et1.setHint("请输入账号");
		RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params2.addRule(RelativeLayout.BELOW,iv0.getId());
		params2.topMargin = ResHelper.dipToPx(context,30);
		params2.leftMargin = ResHelper.dipToPx(context,15);
		et1.setLayoutParams(params2);

		View view0 = new View(context);
		view0.setId(R.id.customized_view_id_div);
		view0.setBackgroundColor(context.getResources().getColor(R.color.sec_verify_demo_text_color_common_gray));
		RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 1);
		params4.addRule(RelativeLayout.BELOW,et1.getId());
		params4.leftMargin = ResHelper.dipToPx(context,15);
		params4.rightMargin = ResHelper.dipToPx(context,15);
		view0.setLayoutParams(params4);

		EditText et2 = new EditText(context);
		et2.setId(R.id.customized_et_id_1);
		et2.setInputType(EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
		et2.setHint("请输入密码");
		et2.setBackground(null);
		RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params3.addRule(RelativeLayout.BELOW,view0.getId());
		params3.topMargin = ResHelper.dipToPx(context,30);
		params3.leftMargin = ResHelper.dipToPx(context,15);
		et2.setLayoutParams(params3);

		View view1 = new View(context);
		view1.setId(R.id.customized_view_id_div1);
		view1.setBackgroundColor(context.getResources().getColor(R.color.sec_verify_demo_text_color_common_gray));
		RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 1);
		params5.addRule(RelativeLayout.BELOW,et2.getId());
		params5.leftMargin = ResHelper.dipToPx(context,15);
		params5.rightMargin = ResHelper.dipToPx(context,15);
		view1.setLayoutParams(params5);

		Button button = new Button(context);
		button.setId(R.id.customized_btn_id_3);
		button.setText("登录");
		button.setBackground(context.getResources().getDrawable(R.drawable.sec_verify_demo_shape_rectangle));
		RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params6.leftMargin = ResHelper.dipToPx(context,30);
		params6.rightMargin = ResHelper.dipToPx(context,30);
		params6.topMargin = ResHelper.dipToPx(context,30);
		params6.addRule(RelativeLayout.BELOW,view1.getId());
		button.setLayoutParams(params6);

		TextView view = new TextView(context);
		view.setId(R.id.customized_view_id);
		view.setText("其他方式登录");
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.bottomMargin = ResHelper.dipToPx(context,150);
		view.setLayoutParams(params);

		ImageView iv1 = new ImageView(context);
		iv1.setId(R.id.customized_btn_id_1);
		iv1.setImageDrawable(context.getResources().getDrawable(R.drawable.sec_verify_demo_wechat));
		RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params1.addRule(RelativeLayout.CENTER_HORIZONTAL);
		params1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params1.bottomMargin = ResHelper.dipToPx(context,120);
		iv1.setLayoutParams(params1);


		List<View> views = new ArrayList<View>();

		views.add(iv0);
		views.add(view);
		views.add(iv1);
		views.add(et1);
		views.add(view0);
		views.add(et2);
		views.add(view1);
		views.add(button);
		return views;
	}

	public static List<View> buildCustomView4(Context context){
		return null;
	}


}
