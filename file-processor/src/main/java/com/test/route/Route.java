package com.test.route;

import org.apache.camel.builder.RouteBuilder;

public class Route extends RouteBuilder {
    @Override
    public void configure() throws Exception {
/*        from("sftp://foo@localhost:8022/upload?password=pass&localWorkDirectory=/tmp&delete=true")
        .log("Uploaded a file with name ${header.CamelFileName}")
        .to("jms:queue:input-queue"); // Invia il contenuto alla coda JMS*/

        from("jms:queue:input-queue")
                .log("Received file with content  ${body}")
                .to("file://inbox");
    }
}
