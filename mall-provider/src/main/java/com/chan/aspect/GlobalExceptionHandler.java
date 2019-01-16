package com.chan.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 所有异常报错
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public String allExceptionHandler(HttpServletRequest request, Exception exception) {
        try {
            LOGGER.error("{},{}", exception.getMessage(), exception);
            return "500";
        } catch (Exception e) {
            LOGGER.error("{},{}", exception.getMessage(), exception);
            return "500";
        }
    }

}