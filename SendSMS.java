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

/**
 *
 * @author home
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class SendSMS {
public static void main(String[] args)
{ try {
Date mydate = new Date(System.currentTimeMillis());

///////String mobilenum =request.getParameter("txtmobile");
/////System.out.println("number is" + mobilenum);
URL url = new URL("http://yourmsg.in/sendhttp.php?user=surabhi.dubey&password=516305&mobiles=8109417150&message=message&sender=903");

//URL url = new URL("http://yourmsg.in/sendhttp.php?user=surabhi.dubey&password=516305&mobiles="+mobilenum+"&message=message&sender=903");
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
}}







