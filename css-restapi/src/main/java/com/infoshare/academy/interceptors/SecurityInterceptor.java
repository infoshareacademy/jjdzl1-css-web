package com.infoshare.academy.interceptors;

import com.infoshare.academy.dao.UsersRepositoryDao;
import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.PasswordHashAlgorithm;
import com.infoshare.academy.utils.UserPasswordUtils;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.jboss.resteasy.util.Base64;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * This interceptor verify the access permissions for an user
 * based on username and password provided in request.
 * User roles: "1"=ADMIN, "0"=USER
 */
@Provider
@ServerInterceptor
public class SecurityInterceptor implements PreProcessInterceptor {

    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401, new Headers<>());
    private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource", 403, new Headers<>());
    private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR", 500, new Headers<>());

    @EJB
    private UsersRepositoryDao usersDao;

    @Override
    public ServerResponse preProcess(HttpRequest request, ResourceMethodInvoker methodInvoked) throws Failure, WebApplicationException {
        {
            Method method = methodInvoked.getMethod();

            //Access allowed for all
            if (method.isAnnotationPresent(PermitAll.class)) {
                return null;
            }
            //Access denied for all
            if (method.isAnnotationPresent(DenyAll.class)) {
                return ACCESS_FORBIDDEN;
            }

            final HttpHeaders headers = request.getHttpHeaders();
            final List<String> authorization = headers.getRequestHeader(AUTHORIZATION_PROPERTY);

            //If no authorization information present: block access
            if (authorization == null || authorization.isEmpty()) {
                return ACCESS_DENIED;
            }

            //Get and decode username and password
            final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
            String usernameAndPassword;
            try {
                usernameAndPassword = new String(Base64.decode(encodedUserPassword));
            } catch (IOException e) {
                return SERVER_ERROR;
            }

            //Split username and password tokens
            final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
            final String username = tokenizer.nextToken();
            final String password = tokenizer.nextToken();

            //Verify user access
            if (method.isAnnotationPresent(RolesAllowed.class)) {
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));

                //Is user valid?
                if (!isUserAllowed(username, password, rolesSet)) {
                    return ACCESS_DENIED;
                }
            }

            //Return null to continue request processing
            return null;
        }
    }

    private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {
        boolean isAllowed = false;

        User tempUser = getUserBasedOnLogin(username);
        if (tempUser == null) {
            return false;
        }

        boolean isPasswordCorrect = checkPassword(tempUser, password);

        if (isPasswordCorrect) {
            String userRole = tempUser.getUserType().toString();
            if (rolesSet.contains(userRole)) {
                isAllowed = true;
            }
        }
        return isAllowed;
    }

    private User getUserBasedOnLogin(String username) {
        return usersDao.getUserByLogin(username);
    }

    private boolean checkPassword(User tempUser, String password) {
        return UserPasswordUtils.check(password, tempUser.getPassword(), PasswordHashAlgorithm.PBKDF2);
    }
}
