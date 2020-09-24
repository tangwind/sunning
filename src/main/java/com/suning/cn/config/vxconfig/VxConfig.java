package com.suning.cn.config.vxconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by  lzy  on 2020/9/23 8:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "vx.login")
public class VxConfig {
    // 1
    private String codeUri;
    private String appId;
    private String redirectUri;
    // 2
    private String accessToken;
    private String secret;
    // 3
    private String refreshToken;
    // 4
    private String userInfoUri;

    //1、引导用户进入授权页面同意授权，获取code
    public String getCode(){
        StringBuffer stringBuffer = new StringBuffer(getCodeUri());
        stringBuffer.append("appid=").append(getAppId());
        stringBuffer.append("&").append("redirect_uri=").append(getRedirectUri());
        stringBuffer.append("&").append("response_type=code");
        stringBuffer.append("&").append("scope=").append("snsapi_userinfo");
        stringBuffer.append("&").append("state=STATE#wechat_redirect");
        return stringBuffer.toString();
    }
    //2、通过code换取网页授权access_token（与基础支持中的access_token不同）
    public String getAccessToken(String code){
        StringBuffer stringBuffer = new StringBuffer(getAccessToken());
        stringBuffer.append("appid=").append(getAppId());
        stringBuffer.append("&").append("secret=").append(getSecret());
        stringBuffer.append("&").append("code=").append(code);
        stringBuffer.append("&").append("grant_type=authorization_code");
        return stringBuffer.toString();
    }
    //3、如果需要，开发者可以刷新网页授权access_token，避免过期
    public String refreshTokenInfo(String refreshToken){
        StringBuffer stringBuffer = new StringBuffer(getRefreshToken());
        stringBuffer.append("appid=").append(getAppId());
        stringBuffer.append("&").append("grant_type=refresh_token");
        stringBuffer.append("&").append("refresh_token=").append(refreshToken);
        return stringBuffer.toString();
    }
    //4、通过网页授权access_token和openid获取用户基本信息（支持UnionID机制）
    public String getUserInfo(String accessToken, String openId){
        StringBuffer stringBuffer = new StringBuffer(getUserInfoUri());
        stringBuffer.append("access_token=").append(accessToken);
        stringBuffer.append("&").append("openid=").append(openId);
        stringBuffer.append("&").append("lang=zh_CN");
        return stringBuffer.toString();
    }
}
