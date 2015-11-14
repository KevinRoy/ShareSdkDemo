package cn.sharesdk.share;

import cn.sharesdk.framework.Platform;

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
}
