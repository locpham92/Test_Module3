package controller;

import model.Department;
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

@WebServlet(name = "userController", value = "/staff")

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
        Staff staffEdit = staffService.findById(idEdit);
        req.setAttribute("staffEdit", staffEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/edit.jsp");
        dispatcher.forward(req, resp);
    }

    public void showAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("staff/add.jsp");
        dispatcher.forward(req, resp);
    }

    public void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        }
    }

    private void deleteStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        staffService.delete(id);
        resp.sendRedirect("/staff?action=home");
    }

    private void editStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        String department = req.getParameter("department");
        List<Department> departmentList = departmentService.findAll();
        for (int i = 0; i <departmentList.size(); i++) {
            if (departmentList.get(i).getName().equals(department)) {
                Staff newStaff = new Staff(id, name, email, address,phoneNumber,salary, departmentList.get(i));
                staffService.edit(id, newStaff);
                resp.sendRedirect("/staff?action=home");
            }
        }
    }

    private void addStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        String department = req.getParameter("department");
        List<Department> departmentList = departmentService.findAll();
        for (int i = 0; i <departmentList.size(); i++) {
            if (departmentList.get(i).getName().equals(department)) {
                Staff newStaff = new Staff(id, name, email, address,phoneNumber,salary, departmentList.get(i));
                staffService.edit(id, newStaff);
                resp.sendRedirect("/staff?action=home");
            }
        }
    }
}
