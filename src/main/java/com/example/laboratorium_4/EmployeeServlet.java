package com.example.laboratorium_4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final Map<Integer, Employee> employees = new HashMap<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String position = request.getParameter("position");
            Employee newEmployee = new Employee(id, firstName, lastName, position);
            employees.put(id, newEmployee);
            response.sendRedirect("index.jsp");
        } else if (action.equals("update")) {
            String idToUpdateStr = request.getParameter("idToUpdate");
            if (idToUpdateStr != null && !idToUpdateStr.isEmpty()) {
                int idToUpdate = Integer.parseInt(idToUpdateStr);
                String newFirstName = request.getParameter("newFirstName");
                String newLastName = request.getParameter("newLastName");
                String newPosition = request.getParameter("newPosition");
                Employee existingEmployee = employees.get(idToUpdate);
                if (existingEmployee != null) {
                    existingEmployee.setFirstName(newFirstName);
                    existingEmployee.setLastName(newLastName);
                    existingEmployee.setPosition(newPosition);
                    response.sendRedirect("index.jsp");
                } else {
                    response.getWriter().println("Pracownik o podanym ID nie istnieje.");
                }
            } else {
                response.getWriter().println("Nieprawidłowy identyfikator pracownika do aktualizacji.");
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("getById")) {
            int id = Integer.parseInt(request.getParameter("idToFind"));
            Employee employee = employees.get(id);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (employee != null) {
                out.println("Employee ID: " + employee.getId() + "<br>");
                out.println("First Name: " + employee.getFirstName() + "<br>");
                out.println("Last Name: " + employee.getLastName() + "<br>");
                out.println("Position: " + employee.getPosition() + "<br>");
            } else {
                out.println("Employee not found");
            }
            out.println("</body></html>");
        } else if (action.equals("getAll")) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            for (Employee employee : employees.values()) {
                out.println("Employee ID: " + employee.getId() + "<br>");
                out.println("First Name: " + employee.getFirstName() + "<br>");
                out.println("Last Name: " + employee.getLastName() + "<br>");
                out.println("Position: " + employee.getPosition() + "<br><br>");
            }
            out.println("</body></html>");
        }
    }
}
