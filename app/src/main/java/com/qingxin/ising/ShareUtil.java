package com.qingxin.ising;

import android.content.Context;

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

    /**
     * 分享
     * @param context
     * @param platformString
     * @param platformActionListener
     */
    public static void share(final Context context, String platformString, PlatformActionListener platformActionListener) {
        Platform platform = ShareSDK.getPlatform(platformString);

        /**
         * 分享的内容
         */
        ShareCommonParams shareCommonParams = new ShareCommonParams(platform);
        shareCommonParams.setText("我是text" + " " + "http://www.isingmobi.com/share/221817");
//        shareCommonParams.setTitle("我是title");
//        shareCommonParams.setUrl("http://www.baidu.com");
        shareCommonParams.setImageUrl("http://www.baidu.com/img/baidu_jgylogo3.gif?v=43167716.gif");

        ShareSDKUtil.share(context, platform, shareCommonParams, platformActionListener);
    }

    /**
     * 登陆
     * @param context
     * @param platformString
     * @param platformDbListener
     */
    public static void authorize(Context context, String platformString, PlatformDbListener platformDbListener) {
        LoginSDKUtil.login(context, platformString, platformDbListener);
    }
}
