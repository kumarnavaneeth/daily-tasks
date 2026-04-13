package com.example.demo.controller;

import com.example.demo.service.NotesService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Note;

@RestController
@RequestMapping(path = "/notes")
public class NotesController {
	@Autowired
	NotesService notesService;

	@GetMapping
	Iterable<Note> GetNotes() {
		return notesService.GetNotes();
	}

	@PostMapping
	void addNote(@Valid @RequestBody Note note) {
		notesService.createNote(note);
	}
}
