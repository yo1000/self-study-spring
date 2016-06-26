// src/main/java/io/github/yo1000/sss/aspect/RepositoryPointcut.java
package io.github.yo1000.sss.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RepositoryPointcut {
    @Pointcut("execution(* io.github.yo1000.sss.repository..MemoRepository+.save(..))")
    public void save() {}
}
