package seedu.multitasky.model.entry;

import static java.util.Objects.requireNonNull;

import java.util.List;

//@@author A0126623L
/**
 * A list of Event objects that does not allow nulls.
 */
public class EventList extends EntryList {

    /**
     * Adds an event to the list.
     *
     * @param toAdd is of type Event and must not be null.
     */
    @Override
    public void add(ReadOnlyEntry toAdd) {
        requireNonNull(toAdd);
        assert (toAdd instanceof Event);

        internalList.add(new Event(toAdd));
    }

    // @@author A0126623L
    /**
     * Clears the current list of events and add all elements from the list of entries given.
     *
     * @param entries must be a list of events.
     */
    public void setEntries(List<? extends ReadOnlyEntry> entries) {
        final EventList replacement = new EventList();
        for (final ReadOnlyEntry entry : entries) {
            replacement.add(new Event(entry));
        }
        super.setEntries(replacement);
    }

}
