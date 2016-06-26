// src/main/java/io/github/yo1000/sss/aspect/LoggingAdvice.java
package io.github.yo1000.sss.aspect;

import io.github.yo1000.sss.model.Memo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAdvice.class);

    @Before("io.github.yo1000.sss.aspect.RepositoryPointcut.save()")
    public void beforeSave(JoinPoint joinPoint) {
        LOGGER.info(joinPoint.getSignature().toLongString());
        if (joinPoint.getArgs().length <= 0 || !(joinPoint.getArgs()[0] instanceof Memo)) {
            LOGGER.error("Args is invalid.");
            return;
        }
        Memo arg = (Memo) joinPoint.getArgs()[0];
        LOGGER.info(String.format("arg.getMemo()   : %s", arg.getMemo()));
        LOGGER.info(String.format("arg.getAuthor() : %s", arg.getAuthor()));
    }
}
