import modele.Inscription;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/deleteAppoitment")
public class DeleteAppoitment extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LinkedList<Inscription> myList = (LinkedList<Inscription>) getServletContext().getAttribute("customerList");
        for (int i = 0; i < myList.size(); i++){
            if (myList.get(i).getFname().equals(req.getParameter("fname")) && myList.get(i).getLname().equals(req.getParameter("lname"))) {
                myList.remove(i);
            }
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/seeList");
        rd.forward(req, resp);
    }
}
