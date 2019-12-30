package com.aira.scorebook.repositories;

public class ClassRepo {
    private static final ClassRepo ourInstance = new ClassRepo();

    public static ClassRepo getInstance() {
        return ourInstance;
    }

    private ClassRepo() {
    }
}
