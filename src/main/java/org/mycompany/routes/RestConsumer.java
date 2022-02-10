package org.mycompany.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.mycompany.model.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;

@Component
public class RestConsumer extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		/*onException(Exception.class)
				.handled(true)
				.setBody(simple("Algo salio mal"))
				.setHeader(Exchange.HTTP_RESPONSE_CODE, simple("500"));*/


		
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
			.to("direct:getUser")
		.get("/prueba")
			.to("direct:getUser")
		.post()
			.consumes(MediaType.APPLICATION_JSON)
			.produces(MediaType.APPLICATION_JSON)
			.param()
				.name("nombre")
			.endParam()
			.responseMessage()
				.code(200)
				.message("Proceso OK")
			.endResponseMessage()
				.responseMessage()
				.code(500)
				.message("Error de sistema")
			.endResponseMessage()
			.type(User.class)
			.to("direct:createUser");
		

		
		
	}

}
