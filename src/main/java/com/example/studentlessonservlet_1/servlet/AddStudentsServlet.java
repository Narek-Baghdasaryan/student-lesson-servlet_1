package com.example.studentlessonservlet_1.servlet;

import com.example.studentlessonservlet_1.manager.LessonManager;
import com.example.studentlessonservlet_1.manager.StudentManager;
import com.example.studentlessonservlet_1.model.Lesson;
import com.example.studentlessonservlet_1.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addStudent")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class AddStudentsServlet extends HttpServlet {
  private   LessonManager lessonManager = new LessonManager();
  private   StudentManager studentManager = new StudentManager();

  private final String UPLOAD_DIRECTORY = "C:\\Users\\User\\IdeaProjects\\student-lesson-servlet_1\\uploadDirectory";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lessons", lessonManager.getLessons());
      List<Lesson> lessons = new LessonManager().getLessons();
        req.getRequestDispatcher("/WEB-INF/addStudents.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String name = req.getParameter("name");
      String surname = req.getParameter("surname");
      String email = req.getParameter("email");
      int age = Integer.parseInt(req.getParameter("age"));
      int lessonId = Integer.parseInt(req.getParameter("lessonId"));
      Part picture = req.getPart("picture");
      String pictureName = null;
      if (picture != null && picture.getSize() > 0) {
        pictureName = System.currentTimeMillis() + "_" + picture.getSubmittedFileName();
        picture.write(UPLOAD_DIRECTORY + File.separator + pictureName);

      }

      studentManager.add(Student.builder()
              .name(name)
              .surname(surname)
              .email(email)
              .age(age)
              .picName(pictureName)
              .lesson(lessonManager.getLessonsById(lessonId))
              .build());

      resp.sendRedirect("/students");
    }
}





