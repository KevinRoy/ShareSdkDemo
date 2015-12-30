package com.qingxin.ising;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.instagram.Instagram;
import cn.sharesdk.login.PlatformDbListener;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.sharesdk.whatsapp.WhatsApp;

public class MainActivity extends AppCompatActivity implements PlatformDbListener, PlatformActionListener {

    @OnClick(R.id.login_google)
    void loginGoogle() {
        ShareUtil.authorize(this, GooglePlus.NAME, this);
    }

    @OnClick(R.id.share_google)
    void shareGoogle() {
        ShareUtil.share(this, GooglePlus.NAME, this);
    }

    @OnClick(R.id.login_weixin)
    void loginWeixin() {
//        ShareUtil.authorize(this, Wechat.NAME, this, this);
    }

    @OnClick(R.id.share_weixin)
    void shareWeixin() {
        ShareUtil.share(this, WechatMoments.NAME, this);
    }

    @OnClick(R.id.login_facebook)
    void loginFacebook() {
        ShareUtil.authorize(this, Facebook.NAME, this);
    }

    @OnClick(R.id.share_facebook)
    void shareFacebook() {
        ShareUtil.share(this, Facebook.NAME, this);
    }

    @OnClick(R.id.login_twitter)
    void loginTwitter() {
        ShareUtil.authorize(this, Twitter.NAME, this);
    }

    @OnClick(R.id.share_twitter)
    void shareTwitter() {
        ShareUtil.share(this, Twitter.NAME, this);
    }

    @OnClick(R.id.login_instagram)
    void loginInstagram() {
        ShareUtil.authorize(this, Instagram.NAME, this);
    }

    @OnClick(R.id.share_instagram)
    void shareInstagram() {
        ShareUtil.share(this, Instagram.NAME, this);
    }

    @OnClick(R.id.share_whatsapp)
    void shareWhatsapp() {
        ShareUtil.share(this, WhatsApp.NAME, this);
    }

    @OnClick(R.id.share_mobile)
    void shareMobile() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        // 分享的数据类型
        intent.setType("text/plain");
        // 分享的主题
        intent.putExtra(Intent.EXTRA_SUBJECT, "好友分享");
        // 分享的内容
        intent.putExtra(Intent.EXTRA_TEXT, "我正在使用iSing，你也加入吧！！");
        // 允许启动新的Activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // 目标应用寻找对话框的标题
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ShareSDK.initSDK(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void cancel() {
        Log.i("haha", "login:cancel");
    }

    @Override
    public void error(String errorString) {
        Log.i("haha", "error login:" + errorString);
    }

    @Override
    public void complete(PlatformDb platformDb) {
        Log.i("haha", "login:" + platformDb.toString());
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Log.d("haha", "share onComplete");
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Log.d("haha", "share onError: " + throwable.getMessage());
    }

    @Override
    public void onCancel(Platform platform, int i) {
        Log.d("haha", "share onCancel");
    }
}
