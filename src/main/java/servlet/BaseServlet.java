package servlet;

import lombok.SneakyThrows;
import utils.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 12:36 PM
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        doPost(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String requestMethod=request.getParameter(R.REQUEST.REQUEST_METHOD);

        try {
            Method method = this.getClass().getDeclaredMethod(requestMethod, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
