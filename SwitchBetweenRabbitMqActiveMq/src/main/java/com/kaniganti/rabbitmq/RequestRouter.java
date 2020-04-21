/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kaniganti.rabbitmq;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and routes to RabbitMQ
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */

@Component
public class RequestRouter extends RouteBuilder {
@Autowired
Processor processor;
    @Override
    public void configure() throws Exception {
    	String brokerURL = "rabbitmq://3.22.117.30/reqExch?vhost=/&routingKey=request&username=ravi&password=ravi&queue=RequestQueue&autoDelete=false";
    	String tourl = "rabbitmq://3.22.117.30/respExch?vhost=/&routingKey=response&username=ravi&password=ravi&queue=ResponseQueue&autoDelete=false";
        from(brokerURL).process(processor);//.log("Received Message: ${body}");
      // processor.process(arg0);
       // .to(tourl).log("sent msg");
            }

}
