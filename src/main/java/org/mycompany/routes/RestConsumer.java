package org.mycompany.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestConsumer extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		restConfiguration().apiContextRouteId("route-api")
        .component("servlet")
        .bindingMode(RestBindingMode.off)
        .apiContextPath("/api-doc")
        .enableCORS(true)
        .apiProperty("base.path", "")
        .apiProperty("api.path", "api")
        .apiProperty("api.title", "Example Title")
        .apiProperty("api.version", "1.0.0")
        .apiProperty("cors", "true")
        .clientRequestValidation(true);
		
		rest("user")
		.get()
		.to("direct:getUser");
		
		from("direct:getUser")
			.setBody(simple("Wilmer"))
			.log("retornando usuario");
		
		
	}

}
