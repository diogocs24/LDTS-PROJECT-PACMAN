package com.aor.pman.controller;

import com.aor.pman.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    public final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(T t, GUI.PressedKey action, long time) throws IOException;
}


