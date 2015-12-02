# 欢迎使用 ShareSdkDemo


这是一个ShareSdk相关的demo，由于工作上的需要，目前可以满足的功能有以下几点：

> * 第三方分享
> * 第三方登录
> * 第三方登出

首先看下`sharelib`工程里面
### 1. 配置
因为shareSdk官方是可以让你在assets里面配置ShareSDK.xml，但笔者在最开始的时候遇到过Android Studio读不出这个坑,不知道现在修复没有，但是为了保险，还是自己写代码配置吧。

在`ShareSDKConfiguration`里面
```
public static void init(Context context，String appKey)
```

配置你在ShareSdk申请的appKey
然后在
```
private static void initPlatform()
```
手动配置你需要的平台，需要怎么做可以查询官网

### 2. 分享
具体在`ShareSDKUtil`
```
public static void share(Context context, Platform platform, ShareCommonParams shareCommonParams, PlatformActionListener platformActionListener)
```
目前只做了分享到指定平台和一键分享，上面这是分享到指定平台，具体用法里面写了注释

这里要说明一下ShareCommonParams这个参数
就是继承的ShareParams，因为这是为了统一传入的参数，可以把一些不同统一写到里面，初衷是好的，虽然暂时没用到
### 3. 登录
具体在`LoginSDKUtil`
```
 public static void login(Context context, Platform platform, PlatformDbListener platformDbListener)
```
也没啥可说的，到时候看一下就一目了然了

### 4. 登出
具体在`AccountUtil`
```
public static void removeAccount(String platformString)
```
当然感觉主要是清除绑定和授权，但是测了下，有时候如果你手机安装了某个客户端（比如facebook的），好像还是一下子就进去了，后话

目前只支持Facebook，Google+，Twitter，Instagram，微信
以后会把其他国内出名的都加上，然后一键分享也做出来，有问题可以提，谢谢大家

# License
```
The MIT License (MIT)

Copyright (c) 2015 KevinRoy

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```