package com.tradetune.app.ui;

import com.tradetune.app.domain.model.Worker;

public final class AppState {
    private static Worker currentWorker;

    private AppState() {}

    public static Worker getCurrentWorker() { return currentWorker; }
    public static void setCurrentWorker(Worker w) { currentWorker = w; }
    public static void clear() { currentWorker = null; }
    public static boolean isLogged() { return currentWorker != null; }
}