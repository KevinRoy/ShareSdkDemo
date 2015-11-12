package cn.sharesdk.login;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.HashMap;

import cn.sharesdk.ShareSDKConfiguration;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;

/**
 * Created by kevin on 15/11/12.
 */
public class LoginApi implements Handler.Callback {
    private static final String TAG = "shareSdk";

    private static final int MSG_AUTH_CANCEL = 1;
    private static final int MSG_AUTH_ERROR = 2;
    private static final int MSG_AUTH_COMPLETE = 3;

    private Handler handler;
    private Context context;
    private Message msg;
    private PlatformDbListener platformDbListener;

    public LoginApi() {
        handler = new Handler(Looper.getMainLooper(), this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            default:
            case MSG_AUTH_CANCEL:
                // 取消
                Log.d(TAG, "cancel");
                platformDbListener.cancel();
                break;
            case MSG_AUTH_ERROR:
                // 失败
                Throwable t = (Throwable) msg.obj;
                Log.d(TAG, "error" + t.getMessage());
                platformDbListener.error(t.getMessage());
                t.printStackTrace();
                break;
            case MSG_AUTH_COMPLETE:
                // 成功
                Log.d(TAG, "complete");
                Object[] objs = (Object[]) msg.obj;
                Platform platform = (Platform) objs[0];
                PlatformDb platformDb = platform.getDb();
                platformDbListener.complete(platformDb);
                break;
        }
        return false;
    }

    /**
     * 登陆
     *
     * @param context
     * @param platform
     */
    public void login(Context context, Platform platform, PlatformDbListener platformDbListener) {
        this.context = context;
        this.platformDbListener = platformDbListener;

        if (platform == null || platformDbListener == null) {
            return;
        }

        //初始化SDK
        ShareSDKConfiguration.init(context);

        if (platform == null) {
            return;
        }

        if (platform.isAuthValid()) {
            platform.removeAccount(true);
            return;
        }

        //使用SSO授权，通过客户单授权
        platform.SSOSetting(false);
        platform.setPlatformActionListener(new PlatformActionListener() {
            public void onComplete(Platform plat, int action, HashMap<String, Object> res) {
                if (action == Platform.ACTION_USER_INFOR) {
                    msg = new Message();
                    msg.what = MSG_AUTH_COMPLETE;
                    msg.arg2 = action;
                    msg.obj = new Object[]{plat.getName(), res};
                    handler.sendMessage(msg);
                }
            }

            public void onError(Platform plat, int action, Throwable t) {
                if (action == Platform.ACTION_USER_INFOR) {
                    msg = new Message();
                    msg.what = MSG_AUTH_ERROR;
                    msg.arg2 = action;
                    msg.obj = t;
                    handler.sendMessage(msg);
                }
                t.printStackTrace();
            }

            public void onCancel(Platform plat, int action) {
                if (action == Platform.ACTION_USER_INFOR) {
                    msg = new Message();
                    msg.what = MSG_AUTH_CANCEL;
                    msg.arg2 = action;
                    msg.obj = plat;
                    handler.sendMessage(msg);
                }
            }
        });
        platform.showUser(null);
    }
}
