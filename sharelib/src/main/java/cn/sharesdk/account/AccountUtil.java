package cn.sharesdk.account;

import android.text.TextUtils;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by kevin on 15/11/19.
 */
public class AccountUtil {

    /**
     * 清除数据
     *
     * @param platformString
     */
    public static void removeAccount(String platformString) {
        if (TextUtils.isEmpty(platformString))
            return;

        Platform platform = ShareSDK.getPlatform(platformString);
        if (platform.isAuthValid()) {
            platform.removeAccount(true);
        }
    }

    /**
     * 清除数据
     *
     * @param platform
     */
    public static void removeAccount(Platform platform) {
        if (platform == null)
            return;

        if (platform.isAuthValid()) {
            platform.removeAccount(true);
        }
    }
}
