package majors.openSource.youban.java.category.studyWord;

import majors.openSource.youban.java.category.childSong.controllers.ChildSongControllers;

public class StudyWordControllers {
    private static final String RENZHI_URL = "http://www.youban.com/renzhi/";

    public static void doMain() throws Exception {
        ChildSongControllers.main_function(RENZHI_URL);
    }
}
