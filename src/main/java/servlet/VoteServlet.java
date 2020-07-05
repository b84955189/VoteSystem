package servlet;

import service.VoteService;
import utils.R;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @author Jason
 * @version 1.0
 * @date 6/2/2020 12:36 PM
 */
@WebServlet("/VoteServlet.action")
public class VoteServlet extends BaseServlet{
    VoteService service=new VoteService();
    protected void toGetListData(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, SQLException, InvocationTargetException, IOException {
        String result=service.getList();
        //跨域请求
        //response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
        response.getWriter().write(result);
    }
    protected void toUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //跨域请求
        //response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
        try {
            service.vote(Integer.parseInt(request.getParameter(R.REQUEST.REQUEST_VOTE_ID)));
            response.getWriter().write(R.RESPONSE.RESPONSE_SIGN_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            response.getWriter().write(R.RESPONSE.RESPONSE_SIGN_FAIL);
        }

    }


}
