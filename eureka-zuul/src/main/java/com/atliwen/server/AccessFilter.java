package com.atliwen.server;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter
{

	@Override
	public Object run()
	{
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		Object accessToken = request.getParameter("a");
		if (accessToken == null)
		{
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		return null;

	}

	@Override
	/**
	 * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。
	 * 在上例中，我们直接返回true，所以该过滤器总是生效。
	 */
	public boolean shouldFilter()
	{
		return true;
	}

	@Override
	/**
	 * 通过int值来定义过滤器的执行顺序
	 */
	public int filterOrder()
	{
		return 0;
	}

	@Override
	/**
	 * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
			pre：可以在请求被路由之前调用
			routing：在路由请求时候被调用
			post：在routing和error过滤器之后被调用
			error：处理请求时发生错误时被调用
	 */
	public String filterType()
	{
		return "pre";
	}

}
