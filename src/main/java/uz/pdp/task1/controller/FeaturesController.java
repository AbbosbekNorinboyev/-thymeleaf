package uz.pdp.task1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.task1.entity.Todo;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Controller
public class FeaturesController {
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create");
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView update() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("todo",
                new Todo(1, "Dushanba", "EASY", LocalDateTime.now())
        );
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("delete");
        modelAndView.addObject("delete_todo",
                new Todo(2, "Seshanba", "EASY", LocalDateTime.now()));
        return modelAndView;
    }

    @GetMapping("/todo_list")
    public ModelAndView todo_list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("todo_list");
        modelAndView.addObject("todos",
                Stream.of(
                        new Todo(1, "Monday", "HARD", LocalDateTime.now()),
                        new Todo(2, "Tuesday", "EASY", LocalDateTime.now()),
                        new Todo(3, "Wednesday", "MEDIUM", LocalDateTime.now()),
                        new Todo(4, "Thursday", "MEDIUM", LocalDateTime.now()),
                        new Todo(5, "Friday", "MEDIUM", LocalDateTime.now()),
                        new Todo(6, "Saturday", "HARD", LocalDateTime.now()),
                        new Todo(7, "Sunday", "HARD", LocalDateTime.now())
                ).sorted((i, j) -> j.id().compareTo(i.id())).toList()
        );
        return modelAndView;
    }
}
