package com.wux.entity;

/**
 * Created by wuxiang
 * on 2018/5/5.
    id INT(10) primary key AUTO_INCREMENT,
    title VARCHAR(64) null,
    content VARCHAR(2048) null,
    menu_id INT UNSIGNED,
    foreign key(menu_id) references menus(id)
 */
public class Note {
    private Integer id;
    private String title;
    private String content;
    private Integer menuId;
    public Note() {
    }

    public Note(Integer id, String title, String content, Integer menuId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.menuId = menuId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", menuId=" + menuId +
                '}';
    }
}
