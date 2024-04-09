package com.chunjae.comm;

public class Forward {
    // forward 를 할 거면 true, sendRedirect 를 할 거면 false
    private boolean forward;
    // url
    private String path;

    public boolean isForward() {
        return forward;
    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
