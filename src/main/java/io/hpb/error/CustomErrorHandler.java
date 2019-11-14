package io.hpb.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class CustomErrorHandler extends DefaultResponseErrorHandler {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        logger.info("调用handleError");
    }

}  