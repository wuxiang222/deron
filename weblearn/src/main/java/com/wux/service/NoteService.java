package com.wux.service;

import com.wux.entity.Note;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/5/5.
 */
public interface NoteService {
    void postNote(Note note);
    void deleteNote(Integer id);
    void putNote(Note note);
    Note getNote(Integer id);

    List<Note> getAllNote();
}
