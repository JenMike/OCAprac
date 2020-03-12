package com.library.mvc;

class LibraryModel{
    private String args;
    private String name;

    protected String getArgs() {
        return args;
    }

    protected void setArgs(String args) {
        this.args = args;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
}