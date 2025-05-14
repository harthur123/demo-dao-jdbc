package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: Department findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n=== TEST 2: Department findALL ===");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        for(Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Department insert ===");
        Department newDepartment = new Department(null, "DB1");
        departmentDao.insert(newDepartment);
        System.out.println("Insert! new Id = " + newDepartment.getId());

        System.out.println("\n=== TEST 4: Department update ===");
        department = departmentDao.findById(6);
        department.setName("DB2");
        departmentDao.update(department);
        System.out.println("Update Completed!");

        System.out.println("\n=== TEST 5: Department delete ===");
        department = departmentDao.findById(7);
        departmentDao.deleteById(7);
        System.out.println("Delete Completed");

    }
}
