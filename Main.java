package org.example;
import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void addStudent()
    {
        Scanner sc=new Scanner(System.in);
        EntityManager entity = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = entity.getTransaction();

        System.out.print("Enter name ");
        String name = sc.next();
        System.out.print("Enter age ");
        int age = sc.nextInt();
        System.out.print("Enter course ");
        String course = sc.next();

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setCourse(course);

        t.begin();
        entity.persist(student);
        t.commit();
        entity.close();

        System.out.println("Student added.");
    }

    public static void viewAllStudents()
    {
        EntityManager entity = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<Student> students = entity.createQuery("from Student", Student.class).getResultList();
        for (Student s : students) {
            System.out.printf("ID: %d, Name: %s, Age: %d, Course: %s%n", s.getId(), s.getName(), s.getAge(), s.getCourse());
        }
        entity.close();
    }

    public static void updateStudent()
    {
        Scanner sc=new Scanner(System.in);
        EntityManager entity = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = entity.getTransaction();
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        Student student = entity.find(Student.class, id);
        if (student != null)
        {
            System.out.print(" Enter New name: ");
            String name = sc.next();
            System.out.print("Enter New age: ");
            int age = sc.nextInt();
            System.out.print("Enter New course: ");
            String course = sc.next();
            t.begin();
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            t.commit();
            System.out.println("Student  data updated.");
        }
        else
        {
            System.out.println("Student not found.");
        }

        entity.close();
    }

    public static void deleteStudent()
    {
        Scanner sc=new Scanner(System.in);
        EntityManager entity = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = entity.getTransaction();

        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        Student student = entity.find(Student.class, id);
        if (student != null)
        {
            t.begin();
            entity.remove(student);
            t.commit();
            System.out.println("Student deleted.");
        }
        else
        {
            System.out.println("Student not found.");
        }
        entity.close();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 ->
                {
                    System.out.println("Exiting...");
                    Util.getEntityManagerFactory().close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
