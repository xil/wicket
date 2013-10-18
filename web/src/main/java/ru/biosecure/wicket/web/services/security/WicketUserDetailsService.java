package ru.biosecure.wicket.core.service.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.biosecure.wicket.core.repo.UserRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 29.06.13
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class WicketUserDetailsService implements UserDetailsService {

    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    protected UserRepository userRepository;

    //    TODO
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.warn("!!!!!");

        User user = new User("1", "6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b", getGrantedAuthorities(getRoles(1)));
        return user;

//        return userRepository.findByUsername(s);
    }

    /**
     * Retrieves a collection of {@link org.springframework.security.core.GrantedAuthority} based on a numerical
     * role
     *
     * @param role the numerical role
     * @return a collection of {@link org.springframework.security.core.GrantedAuthority
     */
    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    /**
     * Converts a numerical role to an equivalent list of roles
     *
     * @param role the numerical role
     * @return list of roles as as a list of {@link String}
     */
    public List<String> getRoles(Integer role) {
        List<String> roles = new ArrayList<String>();

        if (role.intValue() == 1) {
            roles.add("ROLE_USER");
            roles.add("ROLE_ADMIN");

        } else if (role.intValue() == 2) {
            roles.add("ROLE_USER");
        }

        return roles;
    }

    /**
     * Wraps {@link String} roles to {@link org.springframework.security.core.authority.SimpleGrantedAuthority} objects
     *
     * @param roles {@link String} of roles
     * @return list of granted authorities
     */
    public static List<GrantedAuthority> getGrantedAuthorities(
            List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
