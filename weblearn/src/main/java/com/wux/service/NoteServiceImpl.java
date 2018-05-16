package com.wux.service;

import com.wux.dao.NoteDao;
import com.wux.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/5/5.
 */
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao notesDao;
    @Override
    public void postNote(Note note) {
        notesDao.postNote(note);
    }

    @Override
    public void deleteNote(Integer id) {
        notesDao.deleteNote(id);
    }

    @Override
    public void putNote(Note note) {
        notesDao.putNote(note);
    }

    @Override
    public Note getNote(Integer id) {
        return notesDao.getNote(id);
    }

    @Override
    public List<Note> getAllNote() {
        return notesDao.getAllNote();
    }
}
