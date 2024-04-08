package controller;

import model.Department;
import org.w3c.dom.ls.LSException;
import service.ConnectToMySQL;
import model.Staff;
import service.DepartmentService;
import service.IDepartmentService;
import service.StaffService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "StaffController", value = "/staff")

public class StaffController extends HttpServlet {
    private StaffService staffService = new StaffService();
    private DepartmentService departmentService = new DepartmentService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "home":
                showHomePage(req, resp);
                break;
            case "add":
                showAddPage(req, resp);
                break;
            case "edit":
                showEditPage(req, resp);
                break;
            case "delete":
                showDeletePage(req, resp);
                break;
        }
    }

    private void showDeletePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idDelete = Integer.parseInt(req.getParameter("idDelete"));
        req.setAttribute("idDelete", idDelete);
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/delete.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
        req.setAttribute("idEdit", idEdit);
        Staff staffEdit = staffService.findById(idEdit);
        req.setAttribute("staffEdit", staffEdit);
        List<Department> departments = departmentService.findAll();
        req.setAttribute("departments", departments);
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void showAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments = departmentService.findAll();
        req.setAttribute("departments", departments);
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/add.jsp");
        dispatcher.forward(req, resp);
    }

    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Staff> staffList = staffService.findAll();
        req.setAttribute("staffList", staffList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/home.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addStaff(req, resp);
                break;
            case "edit":
                editStaff(req, resp);
                break;
            case "delete":
                deleteStaff(req, resp);
                break;
            case "search":
                searchStaff(req, resp);
                break;
        }
    }

    private void searchStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Staff> foundStaffList = staffService.findStaffByName(keyword);
        req.setAttribute("keyword", keyword);
        req.setAttribute("foundStaffList", foundStaffList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/search.jsp");
        dispatcher.forward(req, resp);
    }


    private void deleteStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        staffService.delete(id);
        resp.sendRedirect("/staff?action=home");
    }

    private void editStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(1);
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phonenumber");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        int departmentId = Integer.parseInt(req.getParameter("department"));
        Department department = departmentService.findById(departmentId);
        Staff editStaff = new Staff(name, email, address, phoneNumber, salary, department);
        staffService.edit(id, editStaff);
        resp.sendRedirect("/staff?action=home");
    }

    private void addStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phonenumber");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        int departmentId = Integer.parseInt(req.getParameter("department"));
        Department department = departmentService.findById(departmentId);
        Staff newStaff = new Staff(name, email, address, phoneNumber, salary, department);
        staffService.add(newStaff);
        resp.sendRedirect("/staff?action=home");
    }
}
