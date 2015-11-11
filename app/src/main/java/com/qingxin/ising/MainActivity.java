package com.qingxin.ising;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.login.PlatformDbListener;
import cn.sharesdk.wechat.moments.WechatMoments;

public class MainActivity extends AppCompatActivity implements PlatformActionListener, PlatformDbListener, Handler.Callback {

    private static final int MSG_AUTH_CANCEL = 1;
    private static final int MSG_AUTH_ERROR = 2;
    private static final int MSG_AUTH_COMPLETE = 3;

    private Handler handler = new Handler();

    @OnClick(R.id.login_google)
    void loginGoogle() {
        ShareUtil.authorize(this, GooglePlus.NAME, this, this);
    }

    @OnClick(R.id.login_weixin)
    void loginWeixin() {
//        ShareUtil.authorize(this, Wechat.NAME, this, this);
    }

    @OnClick(R.id.share_google)
    void shareGoogle() {
        ShareUtil.share(this, GooglePlus.NAME);
    }

    @OnClick(R.id.share_weixin)
    void shareWeixin() {
        ShareUtil.share(this, WechatMoments.NAME);
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
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_AUTH_CANCEL: {
                //取消授权
                Toast.makeText(this, "MSG_AUTH_CANCEL", Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_AUTH_ERROR: {
                //授权失败
                Toast.makeText(this, "MSG_AUTH_ERROR", Toast.LENGTH_SHORT).show();
            }
            break;
            case MSG_AUTH_COMPLETE: {
                //授权成功
                Toast.makeText(this, "MSG_AUTH_COMPLETE", Toast.LENGTH_SHORT).show();
                Object[] objs = (Object[]) msg.obj;
                Platform platform = (Platform) objs[0];
//                loginOAuth(platform.getDb());
//                HashMap<String, Object> res = (HashMap<String, Object>) objs[1];
            }
            break;
        }
        return false;
    }

    @Override
    public void onComplete(Platform platform, int action, HashMap<String, Object> hashMap) {
        if (action == Platform.ACTION_USER_INFOR) {
            Message msg = new Message();
            msg.what = MSG_AUTH_COMPLETE;
            msg.obj = new Object[]{platform, hashMap};
            handler.sendMessage(msg);
        }
    }

    @Override
    public void onError(Platform platform, int action, Throwable throwable) {
        if (action == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_ERROR);
        }
        throwable.printStackTrace();
    }

    @Override
    public void onCancel(Platform platform, int action) {
        if (action == Platform.ACTION_USER_INFOR) {
            handler.sendEmptyMessage(MSG_AUTH_CANCEL);
        }
    }

    @Override
    public void getPlatformDb(PlatformDb platformDb) {
        if (platformDb == null)
            return;

        String userId = platformDb.getUserId();
        String userGender = platformDb.getUserGender();
    }
}
