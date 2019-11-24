package com.yl.oauth2resource.filter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yl.common.pojo.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangjie
 * 2019/11/24 13:33
 *
 * 资源服务器解析token放在springSecurity容器中
 */
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //解析出头信息中的token
        String token = httpServletRequest.getHeader("json-token");
        if (token != null) {
            JSONObject jsonObject = JSONObject.parseObject(token);

            User user = new User();
            String principal = jsonObject.getString("principal");
            user.setUsername(principal);

            JSONArray authorities = jsonObject.getJSONArray("authorities");
            String[] authorityArray = (String[]) authorities.toArray();

            //将解析出来的token放在springSecurity上下文中
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    AuthorityUtils.createAuthorityList(authorityArray));
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
