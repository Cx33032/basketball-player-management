package com.player;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.player.player.PlayersData;
import com.player.player.Register;


public class RegisterPlayer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
	}

    public RegisterPlayer(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        resp.setContentType("text/html");
        int rank = 0, age = 0;
        try{
            rank = Integer.parseInt(req.getParameter("rank"));
        }
        catch(Exception e){
            e.printStackTrace();
            rank = 0;
        }
        try{
            age = Integer.parseInt(req.getParameter("age"));
        }
        catch(Exception e){
            e.printStackTrace();
            age = 0;
        }
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phone_number");
        String position = req.getParameter("position");
        PrintWriter out = resp.getWriter();

        PlayersData newPlayer = new PlayersData(rank, firstName, lastName, age, phoneNumber, email, position);
        Register.registerPlayers(newPlayer);

        out.print("<script>alert('Register Complete!')</script>");
        req.getRequestDispatcher("register.html").include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
