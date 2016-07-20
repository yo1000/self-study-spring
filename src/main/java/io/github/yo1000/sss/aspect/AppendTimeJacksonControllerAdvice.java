// src/main/java/io/github/yo1000/sss/aspect/AppendTimeJacksonControllerAdvice.java
package io.github.yo1000.sss.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppendTimeJacksonControllerAdvice extends AbstractMappingJacksonResponseBodyAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppendTimeJacksonControllerAdvice.class);

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue mappingJacksonValue, MediaType mediaType,
            MethodParameter methodParameter, ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {}

    @Override
    protected MappingJacksonValue getOrCreateContainer(Object body) {
        MappingJacksonValue jacksonValue = super.getOrCreateContainer(body);
        Object bodyValue = jacksonValue.getValue();
        LOGGER.info("{}", bodyValue);

        Map<String, Object> wrappedMap = new HashMap<>();
        wrappedMap.put("body", bodyValue);
        wrappedMap.put("time", System.currentTimeMillis());

        jacksonValue.setValue(wrappedMap);
        return jacksonValue;
    }
}
