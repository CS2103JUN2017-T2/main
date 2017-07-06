package guitests.guihandles;

import guitests.GuiRobot;
import javafx.stage.Stage;

//@@author A0125586
/**
 * Provides a handle for the panel containing the deadline list.
 */
public class DeadlineListPanelHandle extends EntryListPanelHandle {

    private static final String LIST_VIEW_ID = "#deadlineListView";

    public DeadlineListPanelHandle(GuiRobot guiRobot, Stage primaryStage) {
        super(guiRobot, primaryStage);
    }
}
