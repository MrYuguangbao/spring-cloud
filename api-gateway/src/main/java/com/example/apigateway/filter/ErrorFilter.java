package com.example.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @date 2020/3/2 15:36
 */
//@Component
public class ErrorFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Throwable throwable = currentContext.getThrowable();
        logger.error("this is errorFilter{}", throwable.getCause().getMessage());
        currentContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        currentContext.set("error.exception", throwable.getCause());
        return null;
    }
}
