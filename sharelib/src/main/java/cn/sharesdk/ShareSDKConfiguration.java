package cn.sharesdk;

import android.content.Context;

import java.util.HashMap;

import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.instagram.Instagram;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * about ShareSdk Configuration
 * Created by kevin on 15/11/10.
 */
public class ShareSDKConfiguration {
    public static void init(Context context) {
        init(context, "key_id");
    }

    public static void init(Context context, String appKey) {
        ShareSDK.initSDK(context, appKey);
        initPlatform();
    }

    private static void initPlatform() {
        initWechat();
        initWechatMoments();
        initGooglePlus();
        initFacebook();
        initInstagram();
        initTwtter();
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

    /**
     * 初始化facebook
     */
    private static void initFacebook() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Id", "4");
        hashMap.put("SortId", "4");
        hashMap.put("ConsumerKey", "770782199638566");
        hashMap.put("ConsumerSecret", "1c911fceede705edb3e167bc00f93f26");
        hashMap.put("RedirectUrl", "http://182.92.158.40:9090/public/oauth/sucess.html");
        hashMap.put("Enable", "true");

        ShareSDK.setPlatformDevInfo(Facebook.NAME, hashMap);
    }

    /**
     * 初始化Twitter
     */
    private static void initTwtter() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Id", "5");
        hashMap.put("SortId", "5");

        hashMap.put("ConsumerKey", "AEKGO6DT4PhAaUQ8b7LEcDEQ8");
        hashMap.put("ConsumerSecret", "MqkYeB72dr49T5ix2X7VgkTmAQ9sxeObvY61LgZPzYp2R8hvQj");
        hashMap.put("CallbackUrl", "http://182.92.158.40:9090/public/oauth/sucess.html");
        hashMap.put("Enable", "true");

        ShareSDK.setPlatformDevInfo(Twitter.NAME, hashMap);
    }

    /**
     * 初始化Instagram
     */
    private static void initInstagram() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Id", "6");
        hashMap.put("SortId", "6");
        hashMap.put("ClientId", "802ab823a4d14d7ab8312efef682ea8b");
        hashMap.put("ClientSecret", "93be5563e25748bca354e7d0cb0d187e");
        hashMap.put("RedirectUri", "http://182.92.158.40:9090/public/oauth/sucess.html");
        hashMap.put("Enable", "true");

        ShareSDK.setPlatformDevInfo(Instagram.NAME, hashMap);
    }
}
