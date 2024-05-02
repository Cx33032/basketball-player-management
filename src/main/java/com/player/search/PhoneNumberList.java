package com.player.search;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.*;

public class PhoneNumberList extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
	}

    public PhoneNumberList(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        System.out.println("doGet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        System.out.println("Service");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        List<String> names =ListSQL.readPhoneNumber();
        String jsonOut = gson.toJson(names);

        out.write(jsonOut);
    }
}
