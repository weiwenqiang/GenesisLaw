package com.wwq.genesislaw.mvp.model.activity;

import android.support.v4.app.Fragment;

import com.wwq.genesislaw.mvp.contract.activity.LoginContract;

/**
 * Created by wwq on 2017/6/6.
 */

public class LoginModel implements LoginContract.Model {
    public static final String TAG_SIGN_IN = "sign_in";
    public static final String TAG_FORGOT_PASSWORD = "forgot_password";
    public static final String TAG_ALTER_PASSWORD = "alter_password";
//    public static final String TAG_APPLY_ENTER = "apply_enter";
//    public static final String TAG_FILL_PHONE = "fill_phone";
//    public static final String TAG_COMMISSION_SERVER = "commission_server";
//    public static final String TAG_UPLOAD_IDENTITY = "upload_identity";
//    public static final String TAG_EXAMPLE_IDENTITY = "example_identity";
//    public static final String TAG_PROOFREAD_IDENTITY = "proofread_identity";
//    public static final String TAG_FURTHER_INFORMATION = "further_information";
//    public static final String TAG_UPLOAD_LICENSE = "upload_license";
//    public static final String TAG_UPLOAD_FOOD_LICENSE = "upload_food_license";
//    public static final String TAG_SELECT_BANK = "select_bank";
//    public static final String TAG_BINDING_BANK = "binding_bank";
//    public static final String TAG_DATA_AUTHENTICATION = "data_authentication";
//    public static final String TAG_SET_DEAL_PASSWORD = "set_deal_password";
//    public static final String TAG_AGREEMENT_SIGNING = "agreement_signing";
//    public static final String TAG_PROTOCOL_STRING = "protocol_string";
//    public static final String TAG_QUESTIONNAIRE = "questionnaire";
//    public static final String TAG_ENTER_PROGRESS = "enter_progress";
//    public static final String TAG_PERSONAL_DATA = "personal_data";
//    public static final String TAG_SET_LOGIN_PASSWORD = "set_login_password";
//    public static final String TAG_REGISTER_WAY = "register_way";

    @Override
    public Fragment createFragmentFactory(String fragmentStr) {
        Fragment fragment = null;
        switch (fragmentStr) {
//            case TAG_SIGN_IN://登录首页-闪递人
//                fragment = new SignInFragment();
//                break;
//            case TAG_FORGOT_PASSWORD://忘记密码-身份验证
//                fragment = new ForgotPasswordFragment();
//                break;
//            case TAG_ALTER_PASSWORD://忘记密码-修改密码
//                fragment = new AlterPasswordFragment();
//                break;
//            case TAG_APPLY_ENTER://申请入驻
//                fragment = new ApplyEnterFragment();
//                break;
//            case TAG_FILL_PHONE://填写手机号
//                fragment = new FillPhoneFragment();
//                break;
//            case TAG_COMMISSION_SERVER://佣金服务
//                fragment = new CommissionServerFragment();
//                break;
//            case TAG_UPLOAD_IDENTITY://上传身份证
//                fragment = new UploadIdentityFragment();
//                break;
//            case TAG_EXAMPLE_IDENTITY://二代身份证
//                fragment = new ExampleIdentityFragment();
//                break;
//            case TAG_PROOFREAD_IDENTITY://身份证信息校对
//                fragment = new ProofreadIdentityFragment();
//                break;
//            case TAG_FURTHER_INFORMATION://身份信息补充资料
//                fragment = new FurtherInformationFragment();
//                break;
//            case TAG_UPLOAD_LICENSE://上传营业执照
//                fragment = new UploadLicenseFragment();
//                break;
//            case TAG_UPLOAD_FOOD_LICENSE://上传餐饮许可证
//                fragment = new UploadFoodLicenseFragment();
//                break;
//            case TAG_BINDING_BANK://绑定银行卡
//                fragment = new BindingBankFragment();
//                break;
//            case TAG_SELECT_BANK://选择银行
//                fragment = new SelectBankFragment();
//                break;
//            case TAG_DATA_AUTHENTICATION://资料认证
//                fragment = new DataAuthenticationFragment();
//                break;
//            case TAG_SET_DEAL_PASSWORD://设置交易密码
//                fragment = new SetDealPasswordFragment();
//                break;
//            case TAG_AGREEMENT_SIGNING://相关协议签署
//                fragment = new AgreementSigningFragment();
//                break;
//            case TAG_PROTOCOL_STRING://协议文本
//                fragment = new ProtocolStringFragment();
//                break;
//            case TAG_QUESTIONNAIRE://填写问卷
//                fragment = new QuestionnaireFragment();
//                break;
//            case TAG_ENTER_PROGRESS://入驻进度
//                fragment = new EnterProgressFragment();
//                break;
//            case TAG_PERSONAL_DATA://个人资料编辑
//                fragment = new PersonalDataFragment();
//                break;
//            case TAG_SET_LOGIN_PASSWORD://登陆密码设置
//                fragment = new SetLoginPasswordFragment();
//                break;
//            case TAG_REGISTER_WAY://如何注册方式
//                fragment = new HowRegisterWayFragment();
//                break;
        }
        return fragment;
    }
}