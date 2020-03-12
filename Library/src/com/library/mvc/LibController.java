package com.library.mvc;

public class LibController extends AbstractLibraryClass{
    private Library library;
    private LibView view;

    public LibController(Library library, LibView view){
        this.library = library;
        this.view = view;
    }

    public String getLibName(){
        return library.getName();
    }

    public void setLibName(String name) {
        library.setName(name);
    }

    public String getUserArg(){
        return library.getArgs();
    }

    public void setUserArg(String args){
        library.setArgs(args);
    }

    public void updateConsole(){
        view.printLibrary();
    }
}
