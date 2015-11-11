package cn.sharesdk.login;

import cn.sharesdk.framework.PlatformDb;

/**
 * Created by kevin on 15/9/20.
 */
public interface PlatformDbListener {
    public void cancel();

    public void error(String errorString);

    public void complete(PlatformDb platformDb);
}
