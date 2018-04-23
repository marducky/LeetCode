package majors.openSource.youbanWithRegex.java.category.studyWord;

import majors.openSource.youbanWithRegex.java.category.childSong.controllers.ChildSongControllers;

public class StudyWordControllers {
    private static final String RENZHI_URL = "http://www.youbanWithRegex.com/renzhi/";

    public static void doMain() throws Exception {
        ChildSongControllers.main_function(RENZHI_URL);
    }
}
