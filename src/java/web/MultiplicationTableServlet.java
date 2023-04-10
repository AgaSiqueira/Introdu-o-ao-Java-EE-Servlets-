/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author agath
 */
@WebServlet(name = "MultiplicationTableServlet", urlPatterns = {"/mult_table.html"})
public class MultiplicationTableServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int n=2;
        String errorMessage=null;
        try{
             n = Integer.parseInt(request.getParameter("n"));
        }catch(Exception ex){
             errorMessage = "Invalid Parameter";       
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Java EE Mult</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4><a href='index.html'>Voltar</a></h4>");
            out.println("<h1>Java EE</h1>");
            out.println("<h2>Intro</h2>");
            out.println("<h3>Multiplicate Table</h3>");
            out.println("<form>");
                out.println("<input type='number' name='n' value='"+n+"'> ");
                out.println("<input type='submit' name='random' value='Generate'> ");
            out.println("</form>");  
            out.println("<hr/>");
            if(errorMessage!=null){
                out.println("<h4 style='color:red'>Deu ruim!</h4>");
            }else{
                out.println("<table border='0'>");
                for(int i=1; i <= 10; i++){
                    out.println("<tr>");
                        out.println("<td>"+n+"</td>");
                        out.println("<td>x</td>");
                        out.println("<td>"+i+"</td>");
                        out.println("<td>=</td>");
                        out.println("<td>"+(n*i)+"</td>");
                    out.println("</tr>");
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
