package com.test.servlet;

import com.test.entity.Student;
import com.test.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private  StudentRepository studentRepository = new StudentRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //返回 视图+数据
        String method = req.getParameter("method");
        if (method==null){
            method = "findAll";
        }
        switch (method){
            case "findAll":
                List<Student> list = studentRepository.findAll();
                req.setAttribute("list",list);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
            case "delete":
                String idStr = req.getParameter("student_id");
                System.out.println(idStr);
                Integer id = 1;
                studentRepository.deleteById(idStr);
                resp.sendRedirect("/student");
                break;

            case "findById":

                 idStr = req.getParameter("student_id");
                System.out.println(idStr);
                 Student a = studentRepository.findById(idStr);
                 req.setAttribute("student",a);
                 req.getRequestDispatcher("update.jsp").forward(req,resp);
                 break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case"add":
                String student_id = req.getParameter("student_id");
                String name = req.getParameter("name");
                String gender = req.getParameter("gender");
                Integer age = -1;
                if (req.getParameter("age")!="")
                    age = Integer.parseInt(req.getParameter("age"));

                String birthday = req.getParameter("birthday");
                String contact = req.getParameter("contact");
                String email = req.getParameter("email");
                String classes = req.getParameter("classes");
                String hobby = req.getParameter("hobby");
                studentRepository.add(student_id,name,gender,age,birthday,contact,email,classes,hobby);
                resp.sendRedirect("/student");
                break;
            case "update":

                student_id = req.getParameter("student_id");
                name = req.getParameter("name");
                gender = req.getParameter("gender");
                 age = Integer.parseInt(req.getParameter("age"));
                 birthday = req.getParameter("birthday");
                 contact = req.getParameter("contact");
                email = req.getParameter("email");
                classes = req.getParameter("classes");
                hobby = req.getParameter("hobby");
                studentRepository.update(student_id,name,gender,age,birthday,contact,email,classes,hobby);
                resp.sendRedirect("/student");
                break;

            case "search":

                student_id = req.getParameter("student_id");
                name = req.getParameter("name");
                gender = req.getParameter("gender");

                if (req.getParameter("age")!="")
                    age = Integer.parseInt(req.getParameter("age"));
                else
                    age = -1;
                birthday = req.getParameter("birthday");
                contact = req.getParameter("contact");
                email = req.getParameter("email");
                classes = req.getParameter("classes");
                hobby = req.getParameter("hobby");
                Student temp_stu = new Student(student_id,name,gender,age,birthday,contact,email,classes,hobby);

                System.out.println(temp_stu);
                List<Student> list = studentRepository.search(temp_stu);
                req.setAttribute("list",list);
                req.getRequestDispatcher("index.jsp").forward(req,resp);

                break;

            case "to_add_page":
                System.out.println("go to add.jsp");
                resp.sendRedirect("/add.jsp");
                break;

            case"to_search_page":
                System.out.println("go to search.jsp");
                resp.sendRedirect("/search.jsp");
                break;


        }


    }
}
