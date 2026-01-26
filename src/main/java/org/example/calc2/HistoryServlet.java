package org.example.calc2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Calculation> history = (List<Calculation>) getServletContext().getAttribute("calculationHistory");

        if (history != null) {
            req.setAttribute("history", history);
        }

        getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
}