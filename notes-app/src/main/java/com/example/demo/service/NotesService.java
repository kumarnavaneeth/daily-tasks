package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Note;
import com.example.demo.repositories.NotesRepository;

@Service
public class NotesService {
	@Autowired
	NotesRepository notesRepository;
	public Iterable<Note> GetNotes() {
		return notesRepository.findAll();
	}
	public Note createNote(Note note) {
	 return notesRepository.save(note);
	}
}
