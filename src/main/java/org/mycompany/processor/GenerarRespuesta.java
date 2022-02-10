package org.mycompany.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.model.User;
import org.mycompany.model.UserResponse;
import org.springframework.stereotype.Component;

@Component("generarResp")
public class GenerarRespuesta  implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        User user = (User) exchange.getIn().getBody();

        UserResponse userResponse = new UserResponse();
        userResponse.setCode("0");
        userResponse.setMesssage("Todo ok "+user.getName());

        exchange.getIn().setBody(userResponse);
    }
}
