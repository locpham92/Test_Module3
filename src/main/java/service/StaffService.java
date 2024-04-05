package service;

import model.Department;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffService implements IStaffService<Staff> {
    private Connection connection = ConnectToMySQL.getConnection();
    List<Staff> staffList = new ArrayList<>();

    public StaffService() {}
    @Override
    public void add(Staff staff) {
        String sql = "insert into staff(name, email , address, phonenumber, salary, idDepartment) values (?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getEmail());
            preparedStatement.setString(2, staff.getAdress());
            preparedStatement.setString(3, staff.getPhoneNumber());
            preparedStatement.setDouble(4, staff.getSalary());
            Department department = staff.getDepartment();
            preparedStatement.setInt(5, department.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Staff> findAll() {
        List<Staff> staffList = new ArrayList<>();
        String sql = "select staff.*, d.name as nameDepartment from staff join department d on d.id = staff.idDepartment;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                Double salary = rs.getDouble("salary");
                int idDepartment = rs.getInt("idDepartment");
                String nameDepartment = rs.getString("nameDepartment");
                Department department = new Department(idDepartment, nameDepartment);
                Staff staff = new Staff(id, name, email, address, phoneNumber, salary, department);
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    @Override
    public void edit(int id, Staff staff) {
        String sql = "UPDATE staff SET name = ?, email = ?, address = ?, phonenumber = ?, salary = ?, idDepartment = ? WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setString(2, staff.getEmail());
            preparedStatement.setString(2, staff.getAdress());
            preparedStatement.setString(3, staff.getPhoneNumber());
            preparedStatement.setDouble(4, staff.getSalary());
            Department department = staff.getDepartment();
            preparedStatement.setInt(5, department.getId());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM staff WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Staff findById(int id) {
        String sql = "select staff.*, d.name as nameDepartment from staff join department d on d.id = staff.idDepartment where staff.id=?;";
        Staff staff = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                Double salary = rs.getDouble("salary");
                int idDepartment = rs.getInt("idDepartment");
                String nameDepartment = rs.getString("nameDepartment");
                Department department = new Department(idDepartment, nameDepartment);
                staff = new Staff(id, name, email, address, phoneNumber, salary, department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }

}
