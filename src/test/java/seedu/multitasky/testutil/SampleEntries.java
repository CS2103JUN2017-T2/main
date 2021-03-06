package seedu.multitasky.testutil;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

import org.ocpsoft.prettytime.shade.edu.emory.mathcs.backport.java.util.Arrays;

import seedu.multitasky.commons.core.index.Index;
import seedu.multitasky.commons.exceptions.IllegalValueException;
import seedu.multitasky.model.EntryBook;
import seedu.multitasky.model.entry.Entry;
import seedu.multitasky.model.entry.Name;
import seedu.multitasky.model.entry.exceptions.DuplicateEntryException;
import seedu.multitasky.model.entry.exceptions.EntryOverdueException;
import seedu.multitasky.model.entry.exceptions.OverlappingAndOverdueEventException;
import seedu.multitasky.model.entry.exceptions.OverlappingEventException;
import seedu.multitasky.model.entry.util.Comparators;
import seedu.multitasky.model.util.EntryBuilder;

/**
 * Provides sample entries for use in testing.
 */
public class SampleEntries {

    public static final Index INDEX_FIRST_ENTRY = Index.fromOneBased(1);
    public static final Index INDEX_SECOND_ENTRY = Index.fromOneBased(2);
    public static final Index INDEX_THIRD_ENTRY = Index.fromOneBased(3);

    // @@author A0125586X
    // Events (active)
    public static final Entry DINNER, CAT, MOVIE, OPENING;
    // Events (archive)
    public static final Entry ASSIGNMENT, SHOPPING;
    // Events (bin)
    public static final Entry GYM, PAINT;
    // Deadlines (active)
    public static final Entry TAX, PAPER, SUBMISSION, UPGRADE;
    // Deadlines (archive)
    public static final Entry QUIZ, REGISTRATION;
    // Deadlines (bin)
    public static final Entry APPOINTMENT, EMAIL;
    // Floating tasks (active)
    public static final Entry COOK, PROGRAMMING, HIRE, SPECTACLES, CLEAN, SELL;
    // Floating tasks (archive)
    public static final Entry EXERCISE, BOOK;
    // Floating tasks (bin)
    public static final Entry BAKE, SING;

    static {
        try {
            // Events (active)
            DINNER = EntryBuilder.build("Dinner with family",
                                        new GregorianCalendar(2030, Calendar.DECEMBER, 25, 19, 00),
                                        new GregorianCalendar(2030, Calendar.DECEMBER, 25, 21, 00),
                                        "cook");
            CAT = EntryBuilder.build("Feed the cat",
                                     new GregorianCalendar(2030, Calendar.JULY, 12, 19, 00),
                                     new GregorianCalendar(2030, Calendar.JULY, 12, 21, 00),
                                     "pet");
            MOVIE = EntryBuilder.build("Watch Spiderman",
                                       new GregorianCalendar(2030, Calendar.JULY, 15, 15, 00),
                                       new GregorianCalendar(2030, Calendar.JULY, 15, 17, 30),
                                       "marvel", "comics");
            OPENING = EntryBuilder.build("Attend exhibition opening",
                                         new GregorianCalendar(2030, Calendar.OCTOBER, 7, 18, 00),
                                         new GregorianCalendar(2030, Calendar.OCTOBER, 7, 21, 00),
                                         "tuxedo", "suit");
            // Events (archive)
            ASSIGNMENT = EntryBuilder.build("Finish cs2103 assignment",
                                            new GregorianCalendar(2030, Calendar.SEPTEMBER, 9, 19, 00),
                                            new GregorianCalendar(2030, Calendar.SEPTEMBER, 9, 21, 00),
                                            "school");
            ASSIGNMENT.setState(Entry.State.ARCHIVED);
            SHOPPING = EntryBuilder.build("Buy grocery",
                                          new GregorianCalendar(2030, Calendar.NOVEMBER, 13, 19, 00),
                                          new GregorianCalendar(2030, Calendar.NOVEMBER, 13, 21, 00),
                                          "weekends");
            SHOPPING.setState(Entry.State.ARCHIVED);
            // Events (bin)
            GYM = EntryBuilder.build("Go to gym",
                                     new GregorianCalendar(2030, Calendar.SEPTEMBER, 11, 13, 00),
                                     new GregorianCalendar(2030, Calendar.SEPTEMBER, 11, 15, 00),
                                     "health");
            GYM.setState(Entry.State.DELETED);
            PAINT = EntryBuilder.build("Attend painting workshop",
                                       new GregorianCalendar(2030, Calendar.NOVEMBER, 21, 14, 00),
                                       new GregorianCalendar(2030, Calendar.NOVEMBER, 21, 16, 00),
                                       "hobby");
            PAINT.setState(Entry.State.DELETED);

            // Deadlines (active)
            TAX = EntryBuilder.build("Submit tax forms",
                                     new GregorianCalendar(2030, Calendar.JULY, 1, 00, 00),
                                     "money", "pay");
            PAPER = EntryBuilder.build("CS2103 finals",
                                       new GregorianCalendar(2030, Calendar.JULY, 28, 10, 0),
                                       "school", "exam", "study");
            SUBMISSION = EntryBuilder.build("Submit assignment",
                                            new GregorianCalendar(2030, Calendar.JULY, 12, 16, 00),
                                            "school");
            UPGRADE = EntryBuilder.build("Upgrade computer",
                                         new GregorianCalendar(2030, Calendar.DECEMBER, 1, 00, 00),
                                         "personal", "project");
            // Deadlines (archive)
            QUIZ = EntryBuilder.build("Complete post-lecture quiz",
                                      new GregorianCalendar(2030, Calendar.JULY, 20, 00, 00),
                                      "school");
            QUIZ.setState(Entry.State.ARCHIVED);
            REGISTRATION = EntryBuilder.build("Register for marathon",
                                              new GregorianCalendar(2030, Calendar.NOVEMBER, 19, 10, 0),
                                              "health");
            REGISTRATION.setState(Entry.State.ARCHIVED);
            // Deadlines (bin)
            APPOINTMENT = EntryBuilder.build("Make health check appointment",
                                             new GregorianCalendar(2030, Calendar.OCTOBER, 16, 00, 00),
                                             "health", "weekends");
            APPOINTMENT.setState(Entry.State.DELETED);
            EMAIL = EntryBuilder.build("Email penpal",
                                       new GregorianCalendar(2030, Calendar.NOVEMBER, 9, 14, 0),
                                       "hobby");
            EMAIL.setState(Entry.State.DELETED);

            // Floating tasks (active)
            COOK = EntryBuilder.build("Learn to cook",
                                      "goals");
            PROGRAMMING = EntryBuilder.build("Learn programming",
                                             "lessons", "computer");
            HIRE = EntryBuilder.build("Hire an assistant",
                                      "help");
            SPECTACLES = EntryBuilder.build("Make new spectacles",
                                            "health", "eyesight");
            CLEAN = EntryBuilder.build("Clean up room",
                                       "never", "hopefully");
            SELL = EntryBuilder.build("Sell old things",
                                      "sale", "clutter");
            // Floating Tasks (archive)
            EXERCISE = EntryBuilder.build("Go jogging",
                                          "health");
            EXERCISE.setState(Entry.State.ARCHIVED);
            BOOK = EntryBuilder.build("Read books",
                                      "hobby");
            BOOK.setState(Entry.State.ARCHIVED);
            // Floating Tasks (bin)
            BAKE = EntryBuilder.build("Learn baking",
                                      "hobby");
            BAKE.setState(Entry.State.DELETED);
            SING = EntryBuilder.build("Learn singing",
                                      "hobby");
            SING.setState(Entry.State.DELETED);

        } catch (Exception e) {
            throw new AssertionError("Sample data cannot be invalid", e);
        }
    }

    // @@author A0126623L
    /**
     * @return Entry[] of sample events of mixed states (i.e. active, archived, deleted)
     */
    public static Entry[] getAllEvents() {
        ArrayList<Entry> allEntriesList = new ArrayList<Entry>();

        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleActiveEvents()));
        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleArchivedEvents()));
        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleDeletedEvents()));
        allEntriesList.sort(Comparators.EVENT_DEFAULT);

        return allEntriesList.toArray(new Entry[0]);
    }

    /**
     * @return Entry[] of sample deadlines of mixed states (i.e. active, archived, deleted)
     */
    public static Entry[] getAllDeadlines() {
        ArrayList<Entry> allEntriesList = new ArrayList<Entry>();

        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleActiveDeadlines()));
        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleArchivedDeadlines()));
        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleDeletedDeadlines()));
        allEntriesList.sort(Comparators.DEADLINE_DEFAULT);

        return allEntriesList.toArray(new Entry[0]);
    }

    /**
     * @return Entry[] of sample floating tasks of mixed states (i.e. active, archived, deleted)
     */
    public static Entry[] getAllFloatingTasks() {
        ArrayList<Entry> allEntriesList = new ArrayList<Entry>();

        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleActiveFloatingTasks()));
        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleArchivedFloatingTasks()));
        allEntriesList.addAll(Arrays.asList(SampleEntries.getSampleDeletedFloatingTasks()));
        allEntriesList.sort(Comparators.FLOATING_TASK_DEFAULT);

        return allEntriesList.toArray(new Entry[0]);
    }

    // @@author A0125586X
    public static Entry[] getSampleActiveEntries() {
        return new Entry[] {
            DINNER, TAX, PAPER, COOK, PROGRAMMING
        };
    }

    public static Entry[] getSampleActiveEvents() {
        return new Entry[] { DINNER };
    }

    public static Entry[] getSampleActiveDeadlines() {
        return new Entry[] { TAX, PAPER };
    }

    public static Entry[] getSampleActiveFloatingTasks() {
        return new Entry[] { COOK, PROGRAMMING };
    }

    // @@author A0126623L
    public static Entry[] getSampleArchivedEntries() {
        return new Entry[] {
            ASSIGNMENT, QUIZ, EXERCISE
        };
    }

    public static Entry[] getSampleArchivedEvents() {
        return new Entry[] {
            ASSIGNMENT
        };
    }

    public static Entry[] getSampleArchivedDeadlines() {
        return new Entry[] {
            QUIZ
        };
    }

    public static Entry[] getSampleArchivedFloatingTasks() {
        return new Entry[] {
            EXERCISE
        };
    }

    public static Entry[] getSampleDeletedEntries() {
        return new Entry[] {
            GYM, APPOINTMENT, BAKE
        };
    }

    public static Entry[] getSampleDeletedEvents() {
        return new Entry[] {
            GYM
        };
    }

    public static Entry[] getSampleDeletedDeadlines() {
        return new Entry[] {
            APPOINTMENT
        };
    }

    public static Entry[] getSampleDeletedFloatingTasks() {
        return new Entry[] {
            BAKE
        };
    }

    /**
     * Adds sample entries to the provided EntryBook
     */
    public static void loadEntryBookWithSampleActiveEntries(EntryBook entryBook) {
        Objects.requireNonNull(entryBook);
        for (Entry entry : getSampleActiveEntries()) {
            try {
                entryBook.addEntry(EntryBuilder.build(entry));
            } catch (OverlappingEventException oee) {
                // Do nothing. OverlappingEventException is to be expected here.
            } catch (OverlappingAndOverdueEventException e) {
                // Do nothing. Overlapping and overdue entries are fine.
            } catch (EntryOverdueException e) {
                // Do nothing. Overdue entries are fine.
            } catch (DuplicateEntryException e) {
                assert false : "Sample entries cannot have duplicate entries.";
            }
        }
    }

    private static void loadEntryBookWithSampleArchivedEntries(EntryBook entryBook) {
        Objects.requireNonNull(entryBook);
        for (Entry entry : getSampleArchivedEntries()) {
            try {
                entryBook.addEntry(entry);
            } catch (OverlappingEventException oee) {
                // Do nothing. OverlappingEventException is to be expected here.
            } catch (OverlappingAndOverdueEventException e) {
                // Do nothing. Overlapping and overdue entries are fine.
            } catch (EntryOverdueException e) {
                // Do nothing. Overdue entries are fine.
            } catch (DuplicateEntryException e) {
                assert false : "Sample entries cannot have duplicate entries.";
            }
        }
    }

    private static void loadEntryBookWithSampleDeletedEntries(EntryBook entryBook) {
        Objects.requireNonNull(entryBook);
        for (Entry entry : getSampleDeletedEntries()) {
            try {
                entryBook.addEntry(entry);
            } catch (OverlappingEventException oee) {
                // Do nothing. OverlappingEventException is to be expected here.
            } catch (OverlappingAndOverdueEventException e) {
                // Do nothing. Overlapping and overdue entries are fine.
            } catch (EntryOverdueException e) {
                // Do nothing. Overdue entries are fine.
            } catch (DuplicateEntryException e) {
                assert false : "Sample entries cannot have duplicate entries.";
            }
        }
    }

    /**
     * @return an {@code EntryBook} with active sample events, deadlines and floating tasks.
     */
    public static EntryBook getSampleEntryBookWithActiveEntries() {
        EntryBook entryBook = new EntryBook();
        loadEntryBookWithSampleActiveEntries(entryBook);
        return entryBook;
    }

    /**
     * @return  an {@code EntryBook} with sample events, deadlines and floating tasks
     *          of various states (i.e. active, archived, deleted).
     */
    public static EntryBook getSampleEntryBook() {
        EntryBook entryBook = new EntryBook();
        loadEntryBookWithSampleActiveEntries(entryBook);
        loadEntryBookWithSampleArchivedEntries(entryBook);
        loadEntryBookWithSampleDeletedEntries(entryBook);
        return entryBook;
    }

    /**
     * Creates an overlapping event with the given {@code Event} by creating a copy
     * of the given {@code Event} and changing the name.
     * @return {@code Entry}
     */
    public static Entry createOverlappingEvent(Entry entryToOverlapWith) {
        Entry overlappingEventToAdd = EntryBuilder.build(entryToOverlapWith);
        try {
            overlappingEventToAdd.setName(new Name("Overlapping entry dummy name"));
            assertFalse(overlappingEventToAdd.equals(entryToOverlapWith));
        } catch (IllegalValueException e) {
            fail("Should not fail here.");
        }
        return overlappingEventToAdd;
    }

    /**
     * Creates a sample overdue {@code Event}.
     * @return {@code Entry}
     * @throws IllegalValueException
     */
    public static Entry createOverdueEvent() throws IllegalValueException {
        Calendar startDate = Calendar.getInstance();
        startDate.set(Calendar.YEAR, 2013);
        Calendar endDate = Calendar.getInstance();
        endDate.set(Calendar.YEAR, 2014);

        return EntryBuilder.build("D&D", startDate, endDate, "party");
    }

    /**
     * Creates a sample overdue {@code Deadline}.
     * @return {@code Entry}
     * @throws IllegalValueException
     */
    public static Entry createOverdueDeadline() throws IllegalValueException {
        Calendar endDate = Calendar.getInstance();
        endDate.set(Calendar.YEAR, 2014);
        return EntryBuilder.build("dummy overdue entry name", endDate, "deadline");
    }
}
