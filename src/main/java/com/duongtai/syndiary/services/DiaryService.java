package com.duongtai.syndiary.services;

import com.duongtai.syndiary.entities.Diary;
import com.duongtai.syndiary.entities.User;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public interface DiaryService {

    Diary save_diary(Diary diary);

    Diary update_diary(Diary diary);

    void deleteById(Long id);

    void update_display(Diary diary);

    void update_done(Diary diary);
}
