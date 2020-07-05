package filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 4:57 PM
 */
@WebFilter(urlPatterns = "/*")
public class EncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            servletRequest.setCharacterEncoding("UTF-8");
            servletResponse.setCharacterEncoding("UTF-8");
            servletResponse.setContentType("text/html;charset=utf-8");
            filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
