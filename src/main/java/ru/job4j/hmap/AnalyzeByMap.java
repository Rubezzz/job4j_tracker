package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double scope = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scope += subject.score();
                count++;
            }
        }
        return scope / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double scope = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                scope += subject.score();
                count++;
            }
            labels.add(new Label(pupil.name(), scope / count));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int scope = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), scope + subject.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (String subjectName : map.keySet()) {
            rsl.add(new Label(subjectName, map.get(subjectName) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double scope = 0;
            for (Subject subject : pupil.subjects()) {
                scope += subject.score();
            }
            labels.add(new Label(pupil.name(), scope));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int scope = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), scope + subject.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (String subjectName : map.keySet()) {
            rsl.add(new Label(subjectName, map.get(subjectName)));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}
