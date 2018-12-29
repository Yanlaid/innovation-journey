package com.tensquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        /*前置过滤器*/
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        /*优先级*/
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        /*是否拦截*/
        return true;
    }

    @Override
    public Object run() throws ZuulException {
//        解决Zuul的Token转发问题
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("Authorization");
        if (token != null) {
            requestContext.addZuulRequestHeader("JwtAuthorization", token);
        }
        return null;
    }
}
