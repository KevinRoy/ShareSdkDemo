package com.qingxin.ising;

import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.login.LoginSDKUtil;
import cn.sharesdk.login.PlatformDbListener;
import cn.sharesdk.share.ShareSDKInfo;
import cn.sharesdk.share.ShareSDKUtil;

/**
 * Created by kevin on 15/11/11.
 */
public class ShareUtil {

    public static void share(final Context context, String platformString) {
        Platform platform = ShareSDK.getPlatform(platformString);

        ShareSDKInfo shareSDKInfo = new ShareSDKInfo(platform);
        shareSDKInfo.setText("我是text");
        shareSDKInfo.setTitle("我是title");
        shareSDKInfo.setImgUrl("http://www.baidu.com/img/baidu_jgylogo3.gif?v=43167716.gif");

        ShareSDKUtil.share(context, platform, shareSDKInfo, new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Toast.makeText(context, "onComplete", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Toast.makeText(context, "onError", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Toast.makeText(context, "onCancel", Toast.LENGTH_LONG).show();
            }
        });
    }

    public static void authorize(Context context, String platformString, PlatformDbListener platformDbListener) {
        LoginSDKUtil.login(context, platformString, platformDbListener);
    }
}
