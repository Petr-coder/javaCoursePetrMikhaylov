package day6;

import java.util.Random;

public class Teacher {
    private String name;
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void evaluate(Student student) {
        int grade = generateGradeForStudent();
        String gradeForStudent = transformGradeFromNumberToString(grade);
        System.out.println("Преподаватель " + this.name + " оценил студента с именем " + student.getName() + " по предмету " + this.subject + " на оценку " + gradeForStudent);
    }

    private int generateGradeForStudent() {
        int min = 2;
        int max = 5;
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1) + min;
    }

    private String transformGradeFromNumberToString(int grade) {
        String gradeForStudent;
        if (grade == 2) {
            gradeForStudent = "неудовлетворительно";
        } else if (grade == 3) {
            gradeForStudent = "удовлетворительно";
        } else if (grade == 4) {
            gradeForStudent = "хорошо";
        } else {
            gradeForStudent = "отлично";
        }
        return gradeForStudent;
    }
}
