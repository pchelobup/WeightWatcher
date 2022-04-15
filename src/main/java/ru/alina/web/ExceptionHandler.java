package ru.alina.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.alina.security.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler({NoHandlerFoundException.class})
    public ModelAndView handle404(Exception ex, HttpServletRequest request) {
        log.error("Exception at request " + request.getRequestURL(), ex);
        return new ModelAndView("exception", Map.of("ex", ex.getMessage(), "status", "404", "auth", SecurityUtil.isUserAuth()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView handle(Exception ex, HttpServletRequest request) {
        log.error("Exception at request " + request.getRequestURL(), ex);
        return new ModelAndView("exception", Map.of("ex", ex.getMessage(), "auth", SecurityUtil.isUserAuth()));
    }


}
