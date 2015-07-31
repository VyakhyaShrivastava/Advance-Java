/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

/**
 *
 * @author home
 */
public class smsservlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
Date mydate = new Date(System.currentTimeMillis());

String mobilenum =request.getParameter("mobile");
String bookkey =request.getParameter("bookkey");
String message= "Your Booking Id is "+bookkey;
out.println("number is" + mobilenum);
out.println("Book ID is" + bookkey);
//URL url = new URL("http://yourmsg.in/sendhttp.php?user=surabhi.dubey&password=516305&mobiles=8109417150&message=message&sender=903");

URL url = new URL("http://yourmsg.in/sendhttp.php?user=surabhi.dubey&password=516305&mobiles="+mobilenum+"&message=Booked&sender=903");
HttpURLConnection conn = (HttpURLConnection)url.openConnection();
conn.setRequestMethod("GET");
conn.setDoOutput(true);
conn.setDoInput(true);
conn.setUseCaches(false);
conn.connect();
BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line;
StringBuffer buffer = new StringBuffer();
while ((line = rd.readLine()) != null)
{
buffer.append(line).append("\n");
}
System.out.println(buffer.toString());
rd.close();
conn.disconnect();
}catch(Exception e)
{e.printStackTrace();
}
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */








