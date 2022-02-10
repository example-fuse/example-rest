package org.mycompany.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.mycompany.model.User;
import org.mycompany.model.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class TransformationRoute extends RouteBuilder {


    JacksonDataFormat formatRequestOSF = new JacksonDataFormat(User.class);

    JacksonDataFormat formatResposeOSF = new JacksonDataFormat(UserResponse.class);


    @Override
    public void configure() throws Exception {
        from("direct:getUser")
                .routeId("get-user")
                .setBody(simple("Wilmer"))
                .log("retornando usuario");

        from("direct:createUser")
                .streamCaching()
                .routeId("create-user")
                //.setBody(simple("Creando usuario"))
                .log("user: ${body}")
                .unmarshal(formatRequestOSF)
                .log("log despues de conversion  ${body}")
                .log("Name: ${body.name}")
                .process("generarResp")
                .marshal(formatResposeOSF);
    }
}
