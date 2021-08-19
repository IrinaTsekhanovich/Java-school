package com.db.classwork.enums.lab;


/**
 * @author Evgeny Borisov
 */

public enum HttpCode {
	REDIRECTION(300,399,new RedirectHandler()), CLIENT_ERROR(400, 499, new ClientHandler()),
	SERVER_ERROR(500, 599, new ServerHandler());

	HttpCode(int minValue, int maxValue, Handler handler) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.handler = handler;
	}

	private final int minValue;
	private final int maxValue;
	private final Handler handler;


	public void handle(){
		handler.handle();
	}

	public static HttpCode getByCode(int code) {
		for (HttpCode httpCode: values()){
			if (httpCode.getMinValue()<=code && httpCode.getMaxValue()>=code){
				return httpCode;
			}
		}
		throw new IllegalArgumentException("Нет такого кода");
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public Handler getHandler() {
		return handler;
	}
}
