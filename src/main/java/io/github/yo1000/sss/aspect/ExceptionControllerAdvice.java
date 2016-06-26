// src/main/java/io/github/yo1000/sss/aspect/ExceptionControllerAdvice.java
package io.github.yo1000.sss.aspect;

import io.github.yo1000.sss.model.Memo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler({MemoException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public String handleException(MemoException e) {
        LOGGER.error("MemoException", e);
        return "error!!";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        LOGGER.info("InitBinder");
    }

    @ModelAttribute
    public void modelAttribute(Memo model) {
        LOGGER.info("ModelAttribute");
    }

    public static class MemoException extends RuntimeException {}
}
