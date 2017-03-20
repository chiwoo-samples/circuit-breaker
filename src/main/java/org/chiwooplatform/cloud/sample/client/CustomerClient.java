package org.chiwooplatform.cloud.sample.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class CustomerClient
{
    private static Logger logger = LoggerFactory.getLogger( CustomerClient.class );

    private final RestTemplate restTemplate;

    public CustomerClient( RestTemplate restTemplate )
    {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallbackGreeting")
    public String greeting()
    {
        try
        {
            return restTemplate.exchange( "http://customer-service/greeting", HttpMethod.GET, null, String.class )
                               .getBody();
        }
        catch ( Exception e )
        {
            logger.error( e.getMessage() );
            throw e;
        }
    }

    public String fallbackGreeting()
    {
        return "Hello!, This is customer's fallback message.";
    }
}
