package com.dynatrace.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

public class MainVerticle extends AbstractVerticle {
	
	public static void main(String[] args) {
		Vertx.factory.vertx().deployVerticle(new MainVerticle());
	}
	
	@Override
	public void start(Future<Void> fut) {
		HttpServer httpServer = vertx.createHttpServer();
		httpServer.requestHandler(r -> {
			r.response().end("<h1>Request Received</h1>");
		}).listen(58080, result -> {
			if (result.succeeded()) {
				fut.complete();
			} else {
				fut.fail(result.cause());
			}
		});
	}
	
}