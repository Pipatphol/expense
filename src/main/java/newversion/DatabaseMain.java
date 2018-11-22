package newversion;

import DBNewVersion.Connector;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;

public class DatabaseMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        Connector databaseConnector = context.getBean("connector", Connector.class);


        Connector dc2 = context.getBean("connector", Connector.class);
        try {
            ArrayList<TransactionNewVersion> t = databaseConnector.getTransaction();
            System.out.println(t.size());
            t = dc2.getTransaction();
            System.out.println(t.size());
            System.out.println(t.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
