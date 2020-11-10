package com.company;

public class Reply {
    private int t;
    private String[] replies;
    private String reply;

    public Reply(int trigger) {
        t = trigger;
        replies = new String[] {
                "I don't know what to say.",
                "Okay, I will explain the rules.",
                "Let's start the game then."
        };
        reply = replies[t];
        show();
    }

    public void show() {
        System.out.println(reply);
    }
}
