package ru.biosecure.wicket.core.service.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 29.06.13
 * Time: 17:09
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SecurityLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final Logger logger = Logger.getLogger(getClass());

    //    TODO
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);

        logger.warn("fdsfsfs");
    }
}
