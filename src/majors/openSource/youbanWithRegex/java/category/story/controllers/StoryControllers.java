package majors.openSource.youbanWithRegex.java.category.story.controllers;

import majors.openSource.youbanWithRegex.java.category.childSong.controllers.ChildSongControllers;

public class StoryControllers {
    private static final String STORY_URL = "http://www.youbanWithRegex.com/story/";

    public static void doMain() throws Exception {
        ChildSongControllers.main_function(STORY_URL);
    }
}
