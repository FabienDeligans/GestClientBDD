/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import dal.UserDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeles.User;

/**
 *
 * @author Fabien
 */
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String erreur;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String demande, vueReponse;
        vueReponse = "/index.jsp";
        try {
            demande = getDemande(request);

            if (demande.equalsIgnoreCase("home.user")) {
                vueReponse = "/home.jsp"; 
            }
            if (demande.equalsIgnoreCase("login.user")) {
                vueReponse = login(request);
            }
            if (demande.equalsIgnoreCase("connecter.user")) {
                vueReponse = connecter(request);
            }
            if (demande.equalsIgnoreCase("deconnecter.user")) {
                vueReponse = deconnecter(request);
            }

        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            request.setAttribute("erreurR", erreur);
            request.setAttribute("vueR", vueReponse);
            RequestDispatcher dsp = request.getRequestDispatcher("/index.jsp");
            dsp.forward(request, response);
        }
    }

    private String getDemande(HttpServletRequest request) throws Exception {
        String demande = request.getRequestURI();
        demande = demande.substring(demande.lastIndexOf("/") + 1);
        return demande;
    }

    private String login(HttpServletRequest request) throws Exception {
        erreur = null;

        try {
            String vueReponse = "/login.jsp";
            return vueReponse;
        } catch (Exception e) {
            throw e;
        }
    }

    private String connecter(HttpServletRequest request) {
        String vueReponse = "/login.jsp";
        erreur = null;
        try {
            String login, pwd;

            login = request.getParameter("login");
            pwd = request.getParameter("pwd");

            UserDao userDao = new UserDao();
            User user;

            user = userDao.loguer(login, pwd);

            if (user != null) {
                vueReponse = "/accueil.jsp";
                HttpSession session = request.getSession(true);
                session.setAttribute("userId", user.getIdUser());
                request.setAttribute("userR", user);
            } else {
                erreur = "Login mdp inconnus !";
            }
        } catch (Exception e) {
            erreur = e.getMessage();
        } finally {
            return vueReponse;
        }

    }

    private String deconnecter(HttpServletRequest request) {
        String vueReponse;
        erreur = null;

        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", null);
            vueReponse = "/home.jsp";
            return vueReponse;
        } catch (Exception e) {
            throw e;
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
