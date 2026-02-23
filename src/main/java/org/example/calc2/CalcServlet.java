package org.example.calc2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    private List<Calculation> history = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        if (getServletContext().getAttribute("calculationHistory") == null) {
            getServletContext().setAttribute("calculationHistory", new ArrayList<Calculation>());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String num1Str = req.getParameter("num1");
        String num2Str = req.getParameter("num2");
        String operation = req.getParameter("operation");

        double num1 = 0;
        double num2 = 0;
        double result = 0;
        String error = null;

        try {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
            switch (operation) {
                case "sum":
                    result = num1 + num2;
                    break;
                case "minus":
                    result = num1 - num2;
                    break;
                case "umnoj":
                    result = num1 * num2;
                    break;
                case "delenie":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        error = "Деление на ноль невозможно!";
                    }
                    break;
            }

            if (error == null) {
                Calculation calc = new Calculation(num1, num2, operation, result);

                List<Calculation> history = (List<Calculation>) getServletContext().getAttribute("calculationHistory");
                if (history == null) {
                    history = new ArrayList<>();
                    getServletContext().setAttribute("calculationHistory", history);
                }
                history.add(calc);

                DBManager.saveCalculation(calc);
            }
        } catch (NumberFormatException e) {
            error = "Введите корректные числа!";
        }

        req.setAttribute("num1", num1Str);
        req.setAttribute("num2", num2Str);
        req.setAttribute("operation", operation);
        req.setAttribute("result", result);
        req.setAttribute("error", error);

        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}