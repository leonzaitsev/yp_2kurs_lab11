import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@WebServlet("Unnamed")
public class Calculate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter writer = resp.getWriter();
        writer.println("Method GET from AddServlet");*/
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("Angle");


        Double angle = Double.parseDouble(req.getParameter("Angle"));
        Integer eps = Integer.parseInt(req.getParameter("Epsilon"));
        //angle *= Math.PI/180;
        //Float eps = Float.parseFloat(req.getParameter("Epsilon"));
        String func = req.getParameter("Function");
        double res = 0.0;

        try  {
            if(func.equals("sin(x)"))
                res = Math.sin(angle);
            //res = Math.round(eps);
            else if(func.equals("cos(x)"))
                res = Math.cos(angle);
            else if(func.equals("tg(x)"))
                res = Math.tan(angle);
            else if(func.equals("ctg(x)"))
                res = 1.0/Math.tan(angle);
            String form = "%." + eps + "g%n";
            String write = String.format(form, res);
            req.setAttribute("answer", write);

            /*if (found) {
                req.setAttribute("answer", word);
                req.setAttribute("count", count);
            } else {
                req.setAttribute("answer", "No such word in file!");
            }*/
        } catch (Exception e) {
            req.setAttribute("answer", "Smth wrong");
        }

        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
