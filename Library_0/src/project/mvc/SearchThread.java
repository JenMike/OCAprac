package project.mvc;

import static project.Main.buildLibraryModel;

public class SearchThread extends Thread{
    private String keyword;
    private String Option;

    public SearchThread(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void run() {
        LibraryView view = new LibraryView();
        MyLibraryModel model = buildLibraryModel("-t", keyword);
        LibraryController controller = new LibraryController(model, view);
        controller.renderView();

    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return Option;
    }

    public void setOption(String option) {
        Option = option;
    }
}
