package org.example;


import org.example.config.AppConfig;
import org.example.service.StudentManagement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentManagement management = context.getBean(StudentManagement.class);
        System.out.println(management.create());

        context.close();
    }
}
