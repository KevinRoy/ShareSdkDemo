package cn.sharesdk.share;

import android.text.TextUtils;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;

/**
 * 配置mode
 * Created by kevin on 15/11/10.
 */
public class ShareSDKInfo {

    private final static String TEXT = "text";          //文本
    private final static String TITLE = "title";        //标题
    private final static String IMGURL = "imageUrl";    //线上图片url

    private Platform platform; //平台

    private String text;
    private String title;
    private String imgUrl;

    public ShareSDKInfo() {
    }

    public ShareSDKInfo(Platform platform) {
        this.platform = platform;
    }

    private HashMap<String, Object> objectHashMap = new HashMap<String, Object>();

    /**
     * 获得hashmap
     *
     * @return
     */
    public HashMap<String, Object> getObjectHashMap() {
        return objectHashMap == null ? new HashMap<String, Object>() : objectHashMap;
    }

    /**
     * 设置文本
     *
     * @param text
     */
    public void setText(String text) {
        if (TextUtils.isEmpty(text) || objectHashMap == null)
            return;

        objectHashMap.put(TEXT, text);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        if (TextUtils.isEmpty(title) || objectHashMap == null)
            return;

        objectHashMap.put(TITLE, title);
    }

    /**
     * 设置图片url
     *
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        if (TextUtils.isEmpty(imgUrl) || objectHashMap == null)
            return;

        objectHashMap.put(IMGURL, imgUrl);
    }
}
