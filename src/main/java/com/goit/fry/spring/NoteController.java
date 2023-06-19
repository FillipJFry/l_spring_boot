package com.goit.fry.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService srv;

    @GetMapping("/list")
    public ModelAndView getList() {

        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", srv.listAll());
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) Long id) {

        ModelAndView result = new ModelAndView("note/edit");
        Note note = srv.getById(id);
        result.addObject("existing_note", note);
        return result;
    }

    @PostMapping("/edit")
    public String create(@ModelAttribute Note note) {

        srv.save(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Note noteToDel) {

        assert noteToDel != null;
        srv.deleteById(noteToDel.getId());
        return "redirect:/note/list";
    }
}
