package com.wwq.genesislaw.mvp.model.activity;

import android.support.v4.app.Fragment;

import com.wwq.genesislaw.mvp.contract.activity.VesselContract;

/**
 * Created by wwq on 2017/6/8.
 */

public class VesselModel implements VesselContract.Model {
    @Override
    public Fragment FragmentFactory(String str) {
        Fragment fragment = null;
//        switch (str) {
//            case "SetWalletFragment"://我的钱包
//                fragment = new SetWalletFragment();
//                break;
//            case "SetAlterPhoneFragment"://修改手机号
//                fragment = new SetAlterPhoneFragment();
//                break;
//            case "SetCommentFragment"://评论
//                fragment = new SetCommentFragment();
//                break;
//            case "SetSettingFragment"://设置
//                fragment = new SetSettingFragment();
//                break;
//            case "SetDealDetailsFragment"://交易明细
//                fragment = new SetDealDetailsFragment();
//                break;
//            case "FeedbackIdeaFragment"://反馈意见
//                fragment = new FeedbackIdeaFragment();
//                break;
//            case "TextPlainFragment"://纯文本
//                fragment = new TextPlainFragment();
//                break;
//            case "OrderDetaillsFragment"://订单详情
//                fragment = new OrderDetaillsFragment();
//                break;
//            case "WithdrawFragment"://提现
//                fragment = new WithdrawFragment();
//                break;
//            case "BankCardFragment"://银行卡
//                fragment = new BankCardFragment();
//                break;
//            case "BankCardAddFragment"://添加银行卡
//                fragment = new BankCardAddFragment();
//                break;
//            case "ChangePasswordOldFragment"://旧密码修改密码
//                fragment = new ChangePasswordOldFragment();
//                break;
//            case "ChangePasswordPhoneFragment"://手机号修改密码
//                fragment = new ChangePasswordPhoneFragment();
//                break;
//        }
        return fragment;
    }

    @Override
    public String getFragmentTitle(String str) {
        String title = "";
        switch (str) {
            case "SetWalletFragment":
                title = "我的钱包";
                break;
            case "SetAlterPhoneFragment":
                title = "修改手机号";
                break;
            case "SetCommentFragment":
                title = "评论";
                break;
            case "SetSettingFragment":
                title = "设置";
                break;
            case "SetDealDetailsFragment":
                title = "交易明细";
                break;
            case "FeedbackIdeaFragment":
                title = "反馈意见";
                break;
            case "TextPlainFragment":
                title = "纯文本";
                break;
            case "OrderDetaillsFragment":
                title = "订单详情";
                break;
            case "WithdrawFragment":
                title = "提现";
                break;
            case "BankCardFragment":
                title = "银行卡";
                break;
            case "BankCardAddFragment":
                title = "添加银行卡";
                break;
            case "ChangePasswordOldFragment":
                title = "修改密码";
                break;
            case "ChangePasswordPhoneFragment":
                title = "修改密码";
                break;
        }
        return title;
    }
}