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

    private String codeUri;

    private String appId;

    private String secret;

    private String grant_type;

    public String getOpenid(String code){
        StringBuffer stringBuffer = new StringBuffer(getCodeUri());
        stringBuffer.append("appid=").append(getAppId());
        stringBuffer.append("&").append("secret=").append(getSecret());
        stringBuffer.append("&").append("js_code=").append(code);
        stringBuffer.append("&").append("grant_type=").append(getGrant_type());
        return stringBuffer.toString();

    }




}
