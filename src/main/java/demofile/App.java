/*
Steps to work with hibernate:

First we need to run MySQL. Steps to run MySql.

Step1: I have installed Mysql and working on port 3306 which is default of SQL.

Step 2 : Open run and enter 'services.msc' . It will list all the services. From there start the SQL service.

Step 3: SQL will start on localhost at port 3306. Now we can open either my sql client or work bench or console
        from intellij. Now Select any database say abc.

 After SQL is Configured follow below steps for Hibernate.

Step 1: Open a basic java project, better to choose maven project.
Step 2: In pom mention the dependency of hibernate and sql connector:

        <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.4.17.Final</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>

Step 3: In project add hibernate framework support.
        Right click on root of project, select add framework support and then use Hibernate.

Step 4: Now configure hibernate.cfg.xml. Here we need to tell the sql port, database name and id
        password. (Open /resources/hibernate.cfg.xml for more details.

Step5: Your Hibernate is ready. Use @Entity at top of class it will create table for that class.
 */
/*
Difference between Hibernate and Spring.
Spring is the bigger framework which has multiple features such as Autowired etc etc. Hibernate is
used for Database only. We can make normal Java program and use hibernate to create table in it.

If we are using Spring it has inbuilt support from Hibernate and hence we can create tables in a same
manner like we do in hibernate. In spring project dependency of hibernate are present by default.
 */

package demofile;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String Args[]) {

        /*
        Suppose my name is big and have fname,mname and last name. So wither i need to create the seperate
        feild in my main table for fname,mname & lastname.
        To avoid this i can create a class which will have these 3 fields. Then in my main entity table class
        i will have the object of that class.
        So point here is we just want table of main Alien class which has id name and color, we do not want
        seperate table for AlienName class which will have f,m,lname. We just want that AlienName table to be
        embedded in Alien table. So in AlienName table we have used @Embeddable.
         */

//        AlienName aname = new AlienName();
//        aname.setFname("Prakshal");
//        aname.setMname("kumar");
//        aname.setLname("jain");
//
//        Alien telusko = new Alien();
//        telusko.setId(101);
//        telusko.setName(aname);

        /*
        This is the basic steps of how we connect with hibernate. see /resources/hibernate.cfg.xml which
        has all the configuration related to hibernate.
         */
        //We want to create or work on Alein class that's why we have given Alien.class.
//        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class) ;
//
//        SessionFactory sf = con.buildSessionFactory();
//
//        Session session = sf.openSession();
//
//        Transaction tx = session.beginTransaction();
//
//        //It will save the telusko object in the DB.
//        session.save(telusko);
//
//        Alien tel = new Alien();
//
//        /*
//        To fetch the data back from the database. We are fetching id 100 from table called Alien.
//         */
//       tel = (Alien)session.get(Alien.class,100);
//
//        tx.commit();
//
//      System.out.println(tel);


       Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
       SessionFactory sf = config.buildSessionFactory();
       Session session = sf.openSession();

       session.beginTransaction();

       Laptop l1 = new Laptop();
       l1.setBrand("Dell");
       l1.setPrice(1000);

        Laptop l2 = new Laptop();
        l2.setBrand("Dell");
        l2.setPrice(1000);

        Laptop l3 = new Laptop();
        l3.setBrand("Dell");
        l3.setPrice(1000);

        Laptop l4 = new Laptop();
        l4.setBrand("Dell");
        l4.setPrice(1000);

        Laptop l5 = new Laptop();
        l5.setBrand("Dell");
        l5.setPrice(1000);

       Alien a1 = new Alien();
       a1.setName("Rahul");
       a1.getLaps().add(l1);
       l1.setAlien(a1);


        Alien a2 = new Alien();
        a2.setName("Rahul");
        a2.getLaps().add(l2);
        a2.getLaps().add(l4);
        l2.setAlien(a2);
        l4.setAlien(a2);

        Alien a3 = new Alien();
        a3.setName("Rahul");
        a3.getLaps().add(l3);
        a3.getLaps().add(l5);
        l3.setAlien(a3);
        l5.setAlien(a3);

        session.save(l1);
        session.save(l2);
        session.save(l3);
        session.save(l4);
        session.save(l5);

        session.save(a1);
        session.save(a2);
        session.save(a3);


        Alien f = new Alien();


       session.getTransaction().commit();

    }
}
