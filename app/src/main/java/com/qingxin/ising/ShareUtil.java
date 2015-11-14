package com.qingxin.ising;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.login.LoginSDKUtil;
import cn.sharesdk.login.PlatformDbListener;
import cn.sharesdk.share.ShareCommonParams;
import cn.sharesdk.share.ShareSDKUtil;

/**
 * Created by kevin on 15/11/11.
 */
public class ShareUtil {

    public static void share(final Context context, String platformString) {
        Platform platform = ShareSDK.getPlatform(platformString);

        ShareCommonParams shareCommonParams = new ShareCommonParams(platform);
        shareCommonParams.setText("我是text" + " " + "http://www.isingmobi.com/share/221817");
//        shareCommonParams.setTitle("我是title");
//        shareCommonParams.setUrl("http://www.baidu.com");
        shareCommonParams.setImageUrl("http://www.baidu.com/img/baidu_jgylogo3.gif?v=43167716.gif");

        ShareSDKUtil.share(context, platform, shareCommonParams, new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.d("haha", "onComplete");
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.d("haha", "onError: " + throwable.getMessage());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d("haha", "onCancel");
            }
        });
    }

    public static void authorize(Context context, String platformString, PlatformDbListener platformDbListener) {
        LoginSDKUtil.login(context, platformString, platformDbListener);
    }
}
