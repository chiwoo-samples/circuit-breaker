package org.chiwooplatform.cloud.sample.proxy;

import org.chiwooplatform.cloud.sample.client.CustomerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/customer")
@RestController
public class CustomerProxyController
{
    private static Logger logger = LoggerFactory.getLogger( CustomerProxyController.class );

    @Autowired
    private CustomerClient customerClient;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting()
    {
        logger.debug( "Reading customer using rest template " );
        return customerClient.greeting();
    }
}
