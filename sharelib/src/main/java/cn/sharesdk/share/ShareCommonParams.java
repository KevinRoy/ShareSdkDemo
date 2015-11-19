package cn.sharesdk.share;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;

/**
 * 单独分享到各个平台需要的公用ShareParams
 * Created by kevin on 15/11/13.
 */
public class ShareCommonParams extends Platform.ShareParams {

    private Platform platform;

    public ShareCommonParams(Platform platform) {
        super();
        this.platform = platform;
    }

    public ShareCommonParams(String platformString) {
        super();
        Platform platform = ShareSDK.getPlatform(platformString);
        this.platform = platform;
    }
}
