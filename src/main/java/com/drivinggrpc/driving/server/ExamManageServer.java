package com.drivinggrpc.driving.server;

import com.drivinggrpc.driving.po.Exam;
import com.drivinggrpc.driving.po.Report;

import java.util.List;

public interface ExamManageServer {
    List<Exam> initDeleteExam();

    Exam deleteExamCheck(String exam_id);

    void deleteExamDelete(String exam_id);

    boolean addExam(Exam exam);

    boolean addExercise(List<Exam> listBeans);

    List<Exam> initDeleteExercise();

    List<Report> eligible(String user_id);

    List<Report> unEligible(String user_id);

    List<Report> initLoggingData();
}
