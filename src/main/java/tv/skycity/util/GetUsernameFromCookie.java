package tv.skycity.util;

import org.thymeleaf.util.StringUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/***
 * Return the value of Cookie {username, the value}
 */
public class GetUsernameFromCookie {
    public static String getUsernameFromCookie(HttpServletRequest httpServletRequest){
        String username = "";
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                if (StringUtils.equalsIgnoreCase(cookie.getName(),"username")){
                    username = cookie.getValue();
                }
            }
        }
        return username;
    }

    public static Boolean isLoggedIn(String username){
        if (username.equals("")){
            return false;
        }else{
            return true;
        }
    }
}
