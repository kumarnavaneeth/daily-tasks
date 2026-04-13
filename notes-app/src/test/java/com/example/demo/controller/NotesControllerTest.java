package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Note;
import com.example.demo.service.NotesService;

class NotesControllerTest {
	@InjectMocks
	NotesController notesController;
	@Mock
	NotesService notesService;
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void testGetNotes() {
		Iterable<Note> note=new ArrayList<>();
		when(notesController.GetNotes()).thenReturn(note);
		Iterable<Note> result=notesController.GetNotes();
		assertNotNull(result);
 	}
	@Test
	void testCreateNotes() {
		Note note=new Note();
		when(notesService.createNote(note)).thenReturn(note);
		Note result=notesController.addNote(note);
		assertNotNull(result);
		assertEquals(result, note);
	}

}
