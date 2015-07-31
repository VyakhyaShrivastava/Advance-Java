<%-- 
    Document   : uplaod
    Created on : 26 Jun, 2014, 9:55:24 AM
    Author     : Elitebook
--%>

<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>  
<%@ page import="java.util.List"%>  
<%@ page import="java.util.Iterator"%>  
<%@ page import="java.io.File"%>  
<%@ page import="org.apache.commons.fileupload.*"%>  
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>  
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%> 
<%@ page import="org.apache.commons.io.FilenameUtils"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.lang.Exception"%>

<%




%>

<center>
	<table border="2">
    	<tr><td><h1>Your files are uploading.....</h1></td></tr>
        <%
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			
			if (!isMultipart) 
			{
				out.println("The Form is not Multipart!!!!!");
			} 
			else
			{
				FileItemFactory  factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List items = null;
				try {
					items = upload.parseRequest(request);
				} catch (FileUploadException  e) {
					out.println(e.toString());
				}
				Iterator itr = items.iterator();
			
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()){
						 String name = item.getFieldName();
						 String value = item.getString();
					} 
					else {
						try {
							String itemName = item.getName();
							itemName = FilenameUtils.getName(itemName);
							//out.println(itemName);
							File savedFile = new File(config.getServletContext().getRealPath("/")+"uploadedFiles/"+itemName);
							item.write(savedFile);  
							out.println("<tr><td>file saved at</td></tr><tr><td><b>"+config.getServletContext().getRealPath
("/")+"uploadedFiles"+"\\"+itemName+"</td></tr>");
							} catch (Exception e) {
								out.println(e.toString());
								}
					}
				}
			}
   %>
    </table>
   </center>
