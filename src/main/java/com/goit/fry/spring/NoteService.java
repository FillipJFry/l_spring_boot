package com.goit.fry.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private static final long EMPTY_ID = -1;
    @Autowired
    private NoteRepository repository;

    public List<Note> listAll() {

        return repository.findAll();
    }

    public void save(Note note) {

        repository.save(note);
    }

    public void deleteById(long id) {

        repository.deleteById(id);
    }

    public Note getById(Long id) {

        if (id != null && repository.existsById(id)) {
            return repository.findById(id).orElse(createEmptyNote());
        }
        return createEmptyNote();
    }

    private static Note createEmptyNote() {

        return new Note(EMPTY_ID, "", "");
    }
}
