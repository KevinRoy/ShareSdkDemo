package cn.sharesdk.account;

import android.text.TextUtils;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by kevin on 15/11/19.
 */
public class AccountUtil {

    public static void removeAccount(String platformString) {
        if (TextUtils.isEmpty(platformString))
            return;

        Platform platform = ShareSDK.getPlatform(platformString);
        platform.removeAccount(true);
    }

    public static void removeAccount(Platform platform) {
        if (platform == null)
            return;

        platform.removeAccount(true);
    }
}
