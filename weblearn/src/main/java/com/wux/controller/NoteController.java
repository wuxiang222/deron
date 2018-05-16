package com.wux.controller;

/**
 * Created by wuxiang
 * on 2018/5/5.
 */

import com.wux.entity.Note;
import com.wux.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/note", method = RequestMethod.POST)
    @ResponseBody
    public String postNote(Note note){
        noteService.postNote(note);
        return "";
    }
    @RequestMapping(value = "/note/{id}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable("id") Integer id){
        noteService.deleteNote(id);
    }
    @PutMapping("/note")
    public void putNote(Note note){
        noteService.postNote(note);
    }
    @GetMapping("/note/{id}")
    @ResponseBody
    public Note getNote(@PathVariable("id") Integer id){
        return noteService.getNote(id);
    }
    @GetMapping("/allNote")
    @ResponseBody
    public List<Note> getNote(){
        return noteService.getAllNote();
    }
}
