package com.example.studentlessonservlet_1.servlet;

import com.example.studentlessonservlet_1.manager.LessonManager;
import com.example.studentlessonservlet_1.manager.StudentManager;
import com.example.studentlessonservlet_1.model.Lesson;
import com.example.studentlessonservlet_1.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addStudent")
public class AddStudentsServlet extends HttpServlet {
    LessonManager lessonManager = new LessonManager();
    StudentManager studentManager = new StudentManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lessons", lessonManager.getLessons());

        req.getRequestDispatcher("/WEB-INF/addStudents.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String name = req.getParameter("name");
      String surname = req.getParameter("surname");
      String email = req.getParameter("email");
      int age = Integer.parseInt(req.getParameter("age"));
      int lessonId = Integer.parseInt(req.getParameter("lessonId"));
        studentManager.add(Student.builder()
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .age(age)
                        .lesson(lessonManager.getLessonsById(lessonId))
                .build());
        resp.sendRedirect("/students");
    }
}





