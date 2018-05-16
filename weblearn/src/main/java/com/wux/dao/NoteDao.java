package com.wux.dao;

import com.wux.entity.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/5/5.
 */
@Repository
public interface NoteDao {
    void postNote(Note note);
    void deleteNote(@Param("id") Integer id);
    void putNote(Note note);
    Note getNote(@Param("id") Integer id);

    List<Note> getAllNote();
}
