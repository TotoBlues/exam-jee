import modele.Inscription;
import modele.InscriptionExecption;
import modele.InscriptionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/addAppoitment")
public class AddAppoitment extends HttpServlet {

    private LinkedList<Inscription> myCustomerList = new LinkedList<>();

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("customerList", myCustomerList);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/form.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                   throws ServletException, IOException {
      req.setCharacterEncoding("utf-8");
      String fname = req.getParameter("fname");
      String lname = req.getParameter("lname");
      String civility = req.getParameter("civility");
      String urgent = req.getParameter("urgent");
      int i = 0;

        try {
            InscriptionService inscriptionService = new InscriptionService();
            Inscription inscription = inscriptionService.inscrire(fname, lname, civility, urgent);
            req.setAttribute("inscription", inscription);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/validation.jsp");
            myCustomerList = (LinkedList<Inscription>) getServletContext().getAttribute("customerList");
            if (urgent != null) {
                if (myCustomerList.size() != 0) {
                    while (myCustomerList.get(i).getUrgent() != null) {
                        i++;
                    }
                    myCustomerList.add(i, inscription);
                }
                else { myCustomerList.add(inscription); }
            }
            else {
                myCustomerList.add(inscription);
            }
            rd.forward(req, resp);
        } catch (InscriptionExecption e) {
            req.setAttribute("errors", e.getMessages());
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/form.jsp");
            rd.forward(req, resp);
        }

    }
}
