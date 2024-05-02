package com.player;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.player.player.*;

public class QueryPlayer extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
	}

    public QueryPlayer(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String searchKey = req.getParameter("search-mth");
        PrintWriter pw = resp.getWriter();
        boolean isDone = false;

        try{
            switch (searchKey) {
                case "rank": System.out.println(req.getParameter("rank")); isDone = Query.searchPlayerByRank(Integer.parseInt(req.getParameter("rank"))); break;
                case "name": System.out.println(req.getParameter("player-name")); break;
                case "age": System.out.println(req.getParameter("min-age") + " " + req.getParameter("max-age")); break;
                case "email": System.out.println(req.getParameter("player-email")); break;
                case "phone-num": System.out.println(req.getParameter("player-phone")); break;
                case "position": System.out.println(req.getParameter("player-position")); break;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        // if(isDone)
        //     pw.print("<script>Search Successfully</script>");
        // else
        //     pw.print("<script>alert('Invalid Input! Try Again')</script>");
        req.getRequestDispatcher("./result/result.html").include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
