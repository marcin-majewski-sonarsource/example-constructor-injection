package com.example;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.context.env.Environment;
import io.micronaut.function.aws.MicronautRequestHandler;
import io.micronaut.http.annotation.Get;
import java.util.Collections;
import java.util.Map;

public class SampleHandler extends MicronautRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

  private Environment environment;

  public SampleHandler(Environment environment) {
    this.environment = environment;
  }

  @Get
  public Map<String, Object> index() {
    return Collections.singletonMap("message", "Hello World");
  }

  @Override
  public APIGatewayProxyResponseEvent execute(APIGatewayProxyRequestEvent input) {
    return new APIGatewayProxyResponseEvent()
      .withStatusCode(200)
      .withBody("Hello World");
  }
}
