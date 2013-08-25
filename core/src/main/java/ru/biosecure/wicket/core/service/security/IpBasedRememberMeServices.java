package ru.biosecure.wicket.core.service.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 30.06.13
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */
public class IpBasedRememberMeServices extends TokenBasedRememberMeServices {

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    private HttpServletRequest getContext() {
        return requestHolder.get();
    }

    private void setContext(HttpServletRequest context) {
        requestHolder.set(context);
    }

    @Override
    public void onLoginSuccess(HttpServletRequest request, HttpServletResponse response,
                               Authentication successfulAuthentication) {
        try {
            setContext(request);
            super.onLoginSuccess(request, response, successfulAuthentication);
        } finally {
            setContext(null);
        }
    }

    private String getUserIpAddress(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    @Override
    protected String makeTokenSignature(long tokenExpiryTime, String username, String password) {
        String resString = username + ":" + tokenExpiryTime + ":" +
                password + ":" + getKey() + ":" + getUserIpAddress(getContext());
        return DigestUtils.md5DigestAsHex(resString.getBytes());
    }

    @Override
    protected void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
        String[] tokensWithIpAddress = Arrays.copyOf(tokens, tokens.length + 1);
        tokensWithIpAddress[tokensWithIpAddress.length - 1] = getUserIpAddress(request);

        super.setCookie(tokensWithIpAddress, maxAge, request, response);
    }

    @Override
    protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request,
                                                 HttpServletResponse response) {
        try {
            setContext(request);
            String ipAddressToken = cookieTokens[cookieTokens.length - 1];
            if (!getUserIpAddress(request).equals(ipAddressToken)) {
                throw new InvalidCookieException("Cookie IP Address did not contain a matching IP (contained '" + ipAddressToken + "')");
            }
            return super.processAutoLoginCookie(Arrays.copyOf(cookieTokens, cookieTokens.length - 1), request, response);
        } finally {
            setContext(null);
        }

    }
}
