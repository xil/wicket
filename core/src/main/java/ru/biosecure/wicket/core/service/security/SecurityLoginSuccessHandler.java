package ru.biosecure.wicket.core.service.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
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
public class SecurityLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final Logger logger = Logger.getLogger(getClass());

    //        TODO
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);

        logger.info("success");
    }
}
