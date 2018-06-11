import modele.Inscription;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/seeList")
public class seeList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LinkedList<Inscription> myList = (LinkedList<Inscription>) getServletContext().getAttribute("customerList");
        if (myList != null) {
            req.setAttribute("myList", myList);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/see_list.jsp");
            rd.forward(req, resp);
        }
        else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/error_see_list.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}
