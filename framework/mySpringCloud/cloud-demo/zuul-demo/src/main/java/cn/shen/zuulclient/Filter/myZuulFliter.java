package cn.shen.zuulclient.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class myZuulFliter extends ZuulFilter {
    @Override
    /*过滤类型有四种 pre routing post error*/
    public String filterType() {
        return "pre";
    }

    @Override
    /*拦截器优先级，数值越小，优先拦截*/
    public int filterOrder() {
        return 1;
    }

    @Override
    /*是否拦截*/
    public boolean shouldFilter() {
        return true;
    }

    @Override
    /*若拦截了，做什么*/
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String filter = request.getParameter("filter");
        if (null == filter || "".equals(filter)) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
        }
        return null;
    }
}
