package com.caicy.pattern.observer.simple;

public class App{

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new Watcher());

        subject.mockUpdate();
    }
}
