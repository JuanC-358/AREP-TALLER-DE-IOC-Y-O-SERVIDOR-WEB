/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.httpserver;

/**
 *
 * @author ADMIN
 */
import java.net.*;
 import java.io.*;
 public class HttpServer {
 public static void main(String[] args) throws IOException {
 ServerSocket serverSocket = null;
try {
 serverSocket = new ServerSocket(35000);
} catch (IOException e) {
 System.err.println("Could not listen on port: 35000.");
System.exit(1);
 }
 Socket clientSocket = null;
try {
 System.out.println("Listo para recibir ...");
clientSocket = serverSocket.accept();
 } catch (IOException e) {
System.err.println("Accept failed.");
 System.exit(1);
}

PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
 BufferedReader in = new BufferedReader(
new InputStreamReader(
 clientSocket.getInputStream()));
String inputLine, outputLine;

while ((inputLine = in.readLine()) != null) {
 System.out.println("Received: " + inputLine);
if (!in.ready()) {
 break;
}
 }
outputLine = "<!DOCTYPE html>"
 + "<html>"
+ "<head>"
 + "<meta charset=\"UTF-8\">"
+ "<title>Title of the document</title>\n"
+ "</head>"
+ "<body>"
 + "My Web Site"
+ "</body>"
 + "</html>" + inputLine;
out.println(outputLine);

out.close();
 in.close();
clientSocket.close();
 serverSocket.close();
}

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String getComonentResurce(URI resourceURI){
    String response = default404HTMLResponse();
    try{
        String classPath = resourceURI.getPath().toString().replaceAll("/appuser/","");
        Class component = Class.forName(classPath);
        for(Method m : component.getDeclareMethods()){
            if(m.isAnnotationPresent(Service.class)){
                response = m.invoke(null).toString();
                response = "HTTP/1.1 200 ok\r\n"
                        +"Content-Type: text/html\r\n"
                        +"\r\n" + response;
            }
        }
    }catch(Exception ex)
        Logger.getLogger(HttpServer.class.getName())Log(Level.SEVERE, null,ex);
    {
    }
    }
 }
