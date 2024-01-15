package com.example.studentlessonservlet_1.servlet;

import com.example.studentlessonservlet_1.manager.LessonManager;
import com.example.studentlessonservlet_1.model.Lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/addLesson")
public class AddLessonsServlet extends HttpServlet {
    LessonManager lessonManager = new LessonManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lessons", lessonManager.getLessons());
        req.getRequestDispatcher("/WEB-INF/addLesson.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String duration =req.getParameter("duration");
        String lecturerName = req.getParameter("lecturerName");
        Double price =Double.parseDouble(req.getParameter("price")) ;
        lessonManager.add(Lesson.builder()
                        .name(name)
                        .duration(duration)
                        .lecturerName(lecturerName)
                        .price(price)
                .build());
        resp.sendRedirect("/lessons");
    }
}





