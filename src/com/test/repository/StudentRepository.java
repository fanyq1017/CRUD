package com.test.repository;

import com.test.util.DbUtil;
import com.test.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentRepository {

    private DbUtil dbUtil = new DbUtil();
    private Connection  connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

//获取所有同学的信息
    public List<Student> findAll(){
        List<Student> list = new ArrayList<>();
        try{
            connection = dbUtil.getConnection();
            String sql = "select * from team_member";
            preparedStatement= connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student = null;
            while(resultSet.next()){

                String student_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                Integer age = resultSet.getInt(4);
                String birthday = resultSet.getString(5);
                String contact  = resultSet.getString(6);
                String email = resultSet.getString(7);
                String classes = resultSet.getString(8);
                String hobby = resultSet.getString(9);

                student = new Student(student_id,name,gender,age,birthday,contact,email,classes,hobby);
                list.add(student);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }




//添加
    public  void add(String student_id,String name,String gender,Integer age,String birthday,
                         String contact,String email, String classes, String hobby){
        try{
            dbUtil = new DbUtil();
            connection = dbUtil.getConnection();
            String sql = "insert  into team_member(student_id,name,gender,age,birthday,contact," +
                    "email,classes,hobby) values (?,?,?,?,?, ?,?,?,?)";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,student_id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,gender);
            preparedStatement.setInt(4,age);
            preparedStatement.setString(5,birthday);
            preparedStatement.setString(6,contact);
            preparedStatement.setString(7,email);
            preparedStatement.setString(8,classes);
            preparedStatement.setString(9,hobby);

            preparedStatement.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
//删除
    public void deleteById(String id)  {
        connection = null;
        preparedStatement = null;
        try{
            connection = dbUtil.getConnection();
            String sql = "delete from team_member where student_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
//按Id查找
    public Student findById(String id){
        Student student = null;
        try {
            connection = dbUtil.getConnection();
            String sql = "select * from team_member where student_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String student_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                Integer age = resultSet.getInt(4);
                String birthday = resultSet.getString(5);
                String contact = resultSet.getString(6);
                String email = resultSet.getString(7);
                String classes = resultSet.getString(8);
                String hobby = resultSet.getString(9);

                student = new Student(student_id,name,gender,age,birthday,contact,email,classes,hobby);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
//按照条件查找
    public List<Student> search(Student s_student){
        List<Student> list = new ArrayList<>();
        try{
            connection = dbUtil.getConnection();
            StringBuffer sb = new StringBuffer("select * from team_member where true ");
            if(s_student.getStudent_id()!=""){
                sb.append(" and student_id = '"+s_student.getStudent_id()+"'");
            }
            if (s_student.getName()!=""){
                sb.append(" and name = '"+s_student.getName()+"'");
            }
            if(s_student.getGender()!=""){
                sb.append(" and gender = '"+s_student.getGender()+"'");
            }
            if (s_student.getAge()!=-1){
                sb.append(" and age = '"+s_student.getAge()+"'");
            }
            if (s_student.getBirthday()!=""){
                sb.append(" and birthday = '"+s_student.getBirthday()+"'");
            }
            if(s_student.getContact()!=""){
                sb.append(" and contact = '"+s_student.getContact()+"'");
            }
            if(s_student.getEmail()!=""){
                sb.append(" and email = '"+s_student.getEmail()+"'");
            }
            if(s_student.getClasses()!=""){
                sb.append(" and classes = '"+s_student.getClasses()+"'");
            }
            if (s_student.getHobby()!=""){
                sb.append(" and hobby = '"+s_student.getHobby()+"'");
            }
            String sql = sb.toString();
            System.out.println(sql);
            preparedStatement= connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student = null;
            while(resultSet.next()){
                String student_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String gender = resultSet.getString(3);
                Integer age = resultSet.getInt(4);
                String birthday = resultSet.getString(5);
                String contact  = resultSet.getString(6);
                String email = resultSet.getString(7);
                String classes = resultSet.getString(8);
                String hobby = resultSet.getString(9);

                student = new Student(student_id,name,gender,age,birthday,contact,email,classes,hobby);
                list.add(student);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

//更新
    public void  update(String student_id,String name,String gender,Integer age,String birthday,
                        String contact,String email, String classes, String hobby)  {
        try {
            connection = dbUtil.getConnection();
            String sql = "update team_member set student_id = ?,name =?,gender=?,age=?,birthday=?," +
                    "contact=?,email=?,classes=?,hobby=? where student_id=?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,student_id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,gender);
            preparedStatement.setInt(4,age);
            preparedStatement.setString(5,birthday);
            preparedStatement.setString(6,contact);
            preparedStatement.setString(7,email);
            preparedStatement.setString(8,classes);
            preparedStatement.setString(9,hobby);
            preparedStatement.setString(10,student_id);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        System.out.println(studentRepository.findAll());
    }
}
