package cn.sharesdk.login;

import android.content.Context;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;

/**
 * 第三方登陆Util
 * Created by kevin on 15/11/11.
 */
public class LoginSDKUtil {

    public static void login(Context context, Platform platform, PlatformDbListener platformDbListener) {
        LoginApi loginApi = new LoginApi();
        loginApi.login(context, platform, platformDbListener);
    }

    public static void login(Context context, String platformString, PlatformDbListener platformDbListener) {
        Platform platform = ShareSDK.getPlatform(platformString);
        login(context, platform, platformDbListener);
    }
}
