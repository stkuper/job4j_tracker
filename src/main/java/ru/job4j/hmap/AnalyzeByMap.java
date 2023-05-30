package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                count++;
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum / count));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int[] sum = new int[pupils.size()];
        for (Pupil pupil : pupils) {
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), sum[count] + subject.score());
                sum[count] = map.get(subject.name());
                count++;
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int[] sum = new int[pupils.size()];
        for (Pupil pupil : pupils) {
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), sum[count] + subject.score());
                sum[count] = map.get(subject.name());
                count++;
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
