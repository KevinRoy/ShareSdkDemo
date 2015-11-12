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
     * 分享
     *
     * @param context
     * @param platform
     * @param shareSDKInfo
     * @param callback
     */
    public static void share(Context context, Platform platform, ShareSDKInfo shareSDKInfo, PlatformActionListener callback) {
        ShareSDKConfiguration.init(context);
        OnekeyShare oks = new OnekeyShare();
        oks.setCallback(callback);

        //关闭sso授权
        if (!isSSO) {
            oks.disableSSOWhenAuthorize();
        }

        HashMap<Platform, HashMap<String, Object>> map = new HashMap<Platform, HashMap<String, Object>>();
        map.put(platform, shareSDKInfo == null ? new ShareSDKInfo(platform).getObjectHashMap() : shareSDKInfo.getObjectHashMap());

        oks.share(map);
    }

    public static void share(Context context, String platformString, ShareSDKInfo shareSDKInfo, PlatformActionListener callback) {
        Platform platform = ShareSDK.getPlatform(platformString);

        share(context, platform, shareSDKInfo, callback);
    }
}
