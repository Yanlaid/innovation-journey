package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;

@Component
public class ManagerFilter extends ZuulFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String authorization = request.getHeader("Authorization");

//        1.处理CROS的预检请求 --> 放行
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return null;
        }

//        2.判断是否是管理员登录请求 --> 放行
        String url = request.getRequestURL().toString();
        if (url.indexOf("/admin/login")>0) {
            return null;
        }
//        3.检查token 是否合法
        if (null != authorization && authorization.startsWith("Bearer ")) {
            Claims claims = null;
            String token = authorization.substring(7);
            try {
                claims = jwtUtil.parseJWT(token);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (claims != null && "admin".equals(claims.get("roles"))) {
                /*转发*/
                currentContext.addZuulRequestHeader("JwtAuthorization", authorization);
            }
        }
//        4.不是管理员，请求终止
        currentContext.setSendZuulResponse(false);
        currentContext.getResponse().setContentType("application/json;charset=utf-8");
        currentContext.setResponseBody(("{\"code\": 20003,\"flag\": false,\"message\": \"您无权访问\"}"));
        currentContext.setResponseStatusCode(401);
        return null;
    }
}
