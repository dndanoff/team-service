package com.danoff.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class LoggingRestInterceptor implements ClientHttpRequestInterceptor {

	private final Logger logger;
	private final String newLine = System.lineSeparator();
	
	public LoggingRestInterceptor(){
		logger = createLogger();
	}
	
	protected Logger createLogger(){
		return LoggerFactory.getLogger(LoggingRestInterceptor.class);
	}
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		traceRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		traceResponse(response);
		return response;
	}

	private void traceRequest(HttpRequest request, byte[] body) {
		StringBuilder sb = new StringBuilder();
		sb.append(newLine)
		.append("===========================request begin==========================================").append(newLine)
		.append("URI         : ").append(request.getURI()).append(newLine)
		.append("Method      : ").append(request.getMethod()).append(newLine)
		.append("Headers     : ").append(request.getHeaders()).append(newLine)
		.append("Request body: ").append(new String(body, StandardCharsets.UTF_8)).append(newLine)
		.append("===========================request end============================================");
		String message = sb.toString();
		logger.info(message);
	}

	private void traceResponse(ClientHttpResponse response) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append(newLine)
		.append("===========================response begin==========================================").append(newLine)
		.append("Status code  : ").append(response.getStatusCode()).append(newLine)
		.append("Status text  : ").append(response.getStatusText()).append(newLine)
		.append("Headers      : ").append(response.getHeaders()).append(newLine)
		.append("Response body: ").append(getBodyText(response)).append(newLine)
		.append("===========================response end============================================");
		String message = sb.toString();
		logger.info(message);
	}
	
	private String getBodyText(ClientHttpResponse response) {
		StringBuilder bodyText = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(response.getBody(), StandardCharsets.UTF_8))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				bodyText.append(line);
				bodyText.append(newLine);
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return bodyText.toString();
	}

}
