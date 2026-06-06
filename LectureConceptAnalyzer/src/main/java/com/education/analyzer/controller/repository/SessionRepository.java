package com.education.analyzer.repository;

import com.education.analyzer.model.StudentSession;

public class SessionRepository {

    private static StudentSession session;

    public static void setSession(StudentSession s) {
        session = s;
    }

    public static StudentSession getSession() {
        return session;
    }

}