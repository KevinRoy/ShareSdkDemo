package com.qingxin.ising;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.instagram.Instagram;
import cn.sharesdk.login.PlatformDbListener;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.moments.WechatMoments;

public class MainActivity extends AppCompatActivity implements PlatformDbListener {

    @OnClick(R.id.login_google)
    void loginGoogle() {
        ShareUtil.authorize(this, GooglePlus.NAME, this);
    }

    @OnClick(R.id.share_google)
    void shareGoogle() {
        ShareUtil.share(this, GooglePlus.NAME);
    }

    @OnClick(R.id.login_weixin)
    void loginWeixin() {
//        ShareUtil.authorize(this, Wechat.NAME, this, this);
    }

    @OnClick(R.id.share_weixin)
    void shareWeixin() {
        ShareUtil.share(this, WechatMoments.NAME);
    }

    @OnClick(R.id.login_facebook)
    void loginFacebook() {
        ShareUtil.authorize(this, Facebook.NAME, this);
    }

    @OnClick(R.id.share_facebook)
    void shareFacebook() {
        ShareUtil.share(this, Facebook.NAME);
    }

    @OnClick(R.id.login_twitter)
    void loginTwitter() {
        ShareUtil.authorize(this, Twitter.NAME, this);
    }

    @OnClick(R.id.share_twitter)
    void shareTwitter() {
        ShareUtil.share(this, Twitter.NAME);
    }

    @OnClick(R.id.login_instagram)
    void loginInstagram() {
        ShareUtil.authorize(this, Instagram.NAME, this);
    }

    @OnClick(R.id.share_instagram)
    void shareInstagram() {
        ShareUtil.share(this, Instagram.NAME);
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
        Log.i("haha", "cancel");
    }

    @Override
    public void error(String errorString) {
        Log.i("haha", "error" + errorString);
    }

    @Override
    public void complete(PlatformDb platformDb) {
        Log.i("haha", platformDb.toString());
    }
}
