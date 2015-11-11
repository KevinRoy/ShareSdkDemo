package cn.sharesdk;

import android.content.Context;

import java.util.HashMap;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * about ShareSdk Configuration
 * Created by kevin on 15/11/10.
 */
public class ShareSDKConfiguration {
    public static void init(Context context) {
        init(context, "c27877835ca9");
    }

    public static void init(Context context, String appKey) {
        ShareSDK.initSDK(context, appKey);
        initPlatform();
    }

    private static void initPlatform() {
        initWechat();
        initWechatMoments();
        initGooglePlus();
    }

    /**
     * 初始化微信好友
     */
    private static void initWechat() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Id", "1");
        hashMap.put("SortId", "1");
        hashMap.put("AppId", "wx26e5e191eb9b8d5c");
        hashMap.put("AppSecret", "d4624c36b6795d1d99dcf0547af5443d");
        hashMap.put("BypassApproval", "true");
        hashMap.put("Enable", "true");

        ShareSDK.setPlatformDevInfo(Wechat.NAME, hashMap);
    }

    /**
     * 初始化微信朋友圈
     */
    private static void initWechatMoments() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Id", "2");
        hashMap.put("SortId", "2");
        hashMap.put("AppId", "wx26e5e191eb9b8d5c");
        hashMap.put("AppSecret", "d4624c36b6795d1d99dcf0547af5443d");
        hashMap.put("BypassApproval", "true");
        hashMap.put("Enable", "true");

        ShareSDK.setPlatformDevInfo(WechatMoments.NAME, hashMap);
    }

    /**
     * 初始化google+
     */
    private static void initGooglePlus() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Id", "3");
        hashMap.put("SortId", "3");
        hashMap.put("Enable", "true");

        ShareSDK.setPlatformDevInfo(GooglePlus.NAME, hashMap);
    }
}
