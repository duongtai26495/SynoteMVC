package com.duongtai.syndiary.services.impl;

import com.duongtai.syndiary.configs.Snippets;
import com.duongtai.syndiary.entities.Diary;
import com.duongtai.syndiary.repositories.DiaryRepository;
import com.duongtai.syndiary.services.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.duongtai.syndiary.configs.MyUserDetail.getUsernameLogin;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Diary save_diary(Diary diary) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(Snippets.TIME_PATTERN);
        diary.setAdded_at(sdf.format(date));
        diary.setLast_edited(sdf.format(date));
        diary.setDone(false);
        diary.setAuthor(userService.findByUsername(getUsernameLogin()));
        return diaryRepository.save(diary);
    }

    @Override
    public Diary update_diary(Diary diary) {
        Diary found_diary = diaryRepository.findById(diary.getId()).get();
        found_diary.setTitle(diary.getTitle());
        found_diary.setContent(diary.getContent());
        found_diary.setDone(diary.isDone());
        found_diary.setDisplay(diary.isDisplay());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(Snippets.TIME_PATTERN);
        found_diary.setLast_edited(sdf.format(date));
        return diaryRepository.save(found_diary);
    }

    @Override
    public void deleteById(Long id) {
        diaryRepository.deleteById(id);
    }

    @Override
    public void update_display(Diary diary) {
        Diary found_diary = diaryRepository.findById(diary.getId()).get();
        found_diary.setDisplay(diary.isDisplay());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(Snippets.TIME_PATTERN);
        found_diary.setLast_edited(sdf.format(date));
        diaryRepository.save(found_diary);
    }

    @Override
    public void update_done(Diary diary) {
        Diary found_diary = diaryRepository.findById(diary.getId()).get();
        found_diary.setDone(diary.isDone());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(Snippets.TIME_PATTERN);
        found_diary.setLast_edited(sdf.format(date));
        diaryRepository.save(found_diary);
    }

}
