package com.alexb.zuulgateway.filters;

import com.alexb.zuulgateway.utils.FilterUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

@Component
@RequiredArgsConstructor
public class ResponseFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    private final FilterUtils filterUtils;

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().addHeader(FilterUtils.CORRELATION_ID, filterUtils.getCorrelationId());

        return null;
    }
}
