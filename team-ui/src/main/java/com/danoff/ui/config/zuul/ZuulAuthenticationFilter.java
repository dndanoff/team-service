package com.danoff.ui.config.zuul;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import com.danoff.ui.config.ApplicationProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulAuthenticationFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ZuulAuthenticationFilter.class);

	private static final String API_CONTEXT = "/api";
	private static final String AUTHORIZATION_HEADER = "Authorization";

	private final ApplicationProperties appProps;

	@Autowired
	public ZuulAuthenticationFilter(ApplicationProperties appProps) {
		this.appProps = appProps;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		return request.getRequestURI().startsWith(API_CONTEXT);
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String header = request.getHeader(AUTHORIZATION_HEADER);
		if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
			ctx.addZuulRequestHeader(AUTHORIZATION_HEADER, createAuthenticationHeaderValue());
		}
		return null;
	}
	
	private String createAuthenticationHeaderValue() {
		String auth = appProps.getMembersResourceUsername() + ":" + appProps.getMembersResourcePassword();
		byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(encodedAuth);
	}

}
