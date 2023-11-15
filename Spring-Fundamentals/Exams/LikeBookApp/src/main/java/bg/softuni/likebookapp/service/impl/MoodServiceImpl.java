package bg.softuni.likebookapp.service.impl;

import bg.softuni.likebookapp.model.entity.Mood;
import bg.softuni.likebookapp.model.entity.enums.MoodType;
import bg.softuni.likebookapp.repository.MoodRepository;
import bg.softuni.likebookapp.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    @Autowired
    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void seedMood() {
        if (moodRepository.count() != 0) {
            return;
        }
        List<Mood> moods = Arrays.stream(MoodType.values()).map(Mood::new).toList();
        moodRepository.saveAll(moods);
    }
}
