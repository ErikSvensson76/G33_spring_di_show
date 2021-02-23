package org.example;


import org.example.config.AppConfig;
import org.example.data_access.StudentDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDao studentDao = context.getBean(StudentDao.class);

        context.close();
    }
}
