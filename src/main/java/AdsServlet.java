import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//</this is the name of the url that is declared in @webServlet>
@WebServlet("/ads")
public class AdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        List<Ad> ads= DaoFactory.getAdsDao().all();

        request.setAttribute("ads",ads);
        request.getRequestDispatcher("/ads/index.jsp").forward(request,response);
//must putcorrect path plus file extension in this .getRequestDispatcher()
    }
}

////ex for session cookies
//@WebServlet("/apply")
//public class SessionServlet extends HttpServlet{
//    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
//        HttpSession session=req.getSession();
//        session.setAttribute("program","ds");
//        req.getRequestDispatcher("/apply.jsp").forward(req,res);
//    }
//
//}
