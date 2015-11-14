package cn.sharesdk.share;

import android.content.Context;

import java.util.HashMap;

import cn.sharesdk.ShareSDKConfiguration;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.login.PlatformDbListener;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 分享Util
 * Created by kevin on 15/11/10.
 */
public class ShareSDKUtil {

    private static boolean isSSO = false;

    /**
     * 打开SSO授权
     */
    public static void openSSO() {
        isSSO = true;
    }

    /**
     * 关闭SSO授权
     */
    public static void closeSSO() {
        isSSO = false;
    }

    /**
     * 分享（一键分享）OneKeyShare
     *
     * @param context
     * @param platform
     * @param shareSDKInfo
     * @param platformActionListener
     */
    public static void share(Context context, Platform platform, ShareSDKInfo shareSDKInfo, PlatformActionListener platformActionListener) {
        ShareSDKConfiguration.init(context);
        OnekeyShare oks = new OnekeyShare();
        oks.setCallback(platformActionListener);

        //关闭sso授权
        if (!isSSO) {
            oks.disableSSOWhenAuthorize();
        }

        HashMap<Platform, HashMap<String, Object>> map = new HashMap<Platform, HashMap<String, Object>>();
        map.put(platform, shareSDKInfo == null ? new ShareSDKInfo(platform).getObjectHashMap() : shareSDKInfo.getObjectHashMap());

        oks.share(map);
    }

    /**
     * 指定平台分享
     *
     * @param context
     * @param platform
     * @param shareCommonParams
     * @param platformActionListener
     */
    public static void share(Context context, Platform platform, ShareCommonParams shareCommonParams, PlatformActionListener platformActionListener) {
        if (platform == null || shareCommonParams == null)
            return;

        ShareSDKConfiguration.init(context);
        platform.SSOSetting(false);
        platform.setPlatformActionListener(platformActionListener);

        platform.share(shareCommonParams);
    }

    public static void share(Context context, String platformString, ShareSDKInfo shareSDKInfo, PlatformActionListener platformActionListener) {
        Platform platform = ShareSDK.getPlatform(platformString);

        share(context, platform, shareSDKInfo, platformActionListener);
    }

    public static void share(Context context, String platformString, ShareCommonParams shareCommonParams, PlatformActionListener platformActionListener) {
        Platform platform = ShareSDK.getPlatform(platformString);

        share(context, platform, shareCommonParams, platformActionListener);
    }
}
