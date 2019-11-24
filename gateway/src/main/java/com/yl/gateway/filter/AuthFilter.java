package com.yl.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.*;

/**
 * @author yangjie
 * 2019/11/24 12:21
 */
public class AuthFilter extends ZuulFilter {

    /*请求之前拦截*/
    @Override
    public String filterType() {
        return "pre";
    }

    /*优先级， 越小越优先*/
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        //获取当前用户的身份信息
        RequestContext currentContext = RequestContext.getCurrentContext();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof OAuth2Authentication)) {
            return "";
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
        String name = userAuthentication.getName();

        //获取当前用户的权限信息
        List<String> authorities = new ArrayList<>();
        userAuthentication.getAuthorities().forEach(s -> authorities.add(((GrantedAuthority)s).getAuthority()));

        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
        Map<String, String> requestParameters = oAuth2Request.getRequestParameters();
        HashMap<String, Object> jsonToken = new HashMap<>(requestParameters);
        if (jsonToken != null) {
            jsonToken.put("principal", name);
            jsonToken.put("authorities", authorities);
        }

        //将身份信息和权限信息放在json中，加入到httpHeader中， 一般存为base64
        currentContext.addZuulRequestHeader("json-token", JSONObject.toJSONString(jsonToken));

        return "";
    }
}
