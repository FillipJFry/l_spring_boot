package com.goit.fry.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {

	private static final long EMPTY_ID = -1;
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
		Note note;
		if (id != null)
			note = srv.getById(id);
		else
			note = new Note(EMPTY_ID, "", "");

		result.addObject("existing_note", note);
		return result;
	}

	@PostMapping("/edit")
	public String create(@ModelAttribute Note note) {

		long id = note.getId();
		if (id <= EMPTY_ID)
			srv.addWithNewId(note);
		else if (srv.getById(id) == null)
			srv.add(note);
		else
			srv.update(note);

		return "redirect:/note/list";
	}

	@PostMapping("/delete")
	public String delete(@ModelAttribute Note noteToDel) {

		assert noteToDel != null;
		assert srv.getById(noteToDel.getId()) != null;

		srv.deleteById(noteToDel.getId());
		return "redirect:/note/list";
	}
}
