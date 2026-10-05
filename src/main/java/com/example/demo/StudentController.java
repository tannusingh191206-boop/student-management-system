
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // HOME
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // ADD STUDENT - SHOW FORM
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // ADD STUDENT - SAVE
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    // VIEW STUDENTS
    @GetMapping("/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "view-students";
    }

    // SEARCH PAGE
    @GetMapping("/search")
    public String searchPage() {
        return "search-student";
    }

    // SEARCH STUDENT
    @GetMapping("/search-result")
    public String searchStudent(
            @RequestParam("rollNo") String rollNo,
            Model model) {

        studentRepository.findByRollNo(rollNo)
                .ifPresentOrElse(
                        student -> model.addAttribute("student", student),
                        () -> model.addAttribute("notFound", true)
                );

        return "search-student";
    }

    // UPDATE PAGE
    @GetMapping("/update")
    public String updatePage(Model model) {
        model.addAttribute("student", new Student());
        return "update-student";
    }

    // UPDATE STUDENT
    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {

        studentRepository.findByRollNo(student.getRollNo())
                .ifPresent(existingStudent -> {

                    existingStudent.setName(student.getName());
                    existingStudent.setAge(student.getAge());
                    existingStudent.setGender(student.getGender());
                    existingStudent.setCourse(student.getCourse());
                    existingStudent.setPhone(student.getPhone());
                    existingStudent.setEmail(student.getEmail());
                    existingStudent.setAddress(student.getAddress());

                    studentRepository.save(existingStudent);
                });

        return "redirect:/students";
    }

    // DELETE PAGE
    @GetMapping("/delete")
    public String deletePage() {
        return "delete-student";
    }

    // DELETE STUDENT
    @PostMapping("/delete")
    public String deleteStudent(@RequestParam("rollNo") String rollNo) {

        studentRepository.findByRollNo(rollNo)
                .ifPresent(studentRepository::delete);

        return "redirect:/students";
    }
}

