/** 
    An implementation of the ADT sorted list that uses the ADT list.
    @author Frank M. Carrano
 */
public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T>
{
    private ListInterface<T> list;
    
    public SortedList()
    {
        list = new LList<>();
    } // end default constructor
    
    /** Adds a new entry to the sorted list in its proper order.
        The list's size is increased by 1.
        @param newEntry  An object to be added as a new entry. */
    public void add(T newEntry)
    {
        int newPosition = Math.abs(getPosition(newEntry));
        list.add(newPosition, newEntry);
    } // end add    
    
    /** Removes the first or the only occurrence of a specified entry 
        from this sorted list.
        @param anEntry  The object to be removed.
        @return  True if anEntry was located and removed; 
                 otherwise returns false. */
    public boolean remove(T anEntry)
    {
        boolean result = false;
        int position = getPosition(anEntry);
        if (position > 0)
        {
            list.remove(position);
            result = true;
        } // end if
        return result;
    } // end remove
    
    /** Gets the position of an entry in this sorted list.
        @param anEntry  The object to be found.
        @return  The position of the first or only occurrence of anEntry
                 if it occurs in the list; otherwise returns the position
                 where anEntry would occur in the list, but as a negative
                 integer. */
    public int getPosition(T anEntry)
    {
        int position = 1;
        int length = list.getLength();
        // Find position of an entry
        while ((position <= length) && 
                (anEntry.compareTo(list.getEntry(position)) > 0))
        {
            position++;
        } // end while            
        // See whether anEntry is in list
        if ((position > length) || 
                (anEntry.compareTo(list.getEntry(position)) != 0))
        {
            position = -position;   // anEntry is not in list
        } // end if        
        return position;
    } // end getPosition

    /** Retrieves the entry at a given position in this list.
        Any givenPosition is invalid if empty.
        @param givenPosition  An integer that indicates the position of the 
                              desired entry.
        @return  A reference to the indicated entry.
        @throws  IndexOutOfBoundsException if either
                  givenPosition < 1 or givenPosition > getLength(). */
    public T getEntry(int givenPosition)
    {     
        return list.getEntry(givenPosition);
    } // end getEntry
    
    /** Sees whether this list contains a given entry.
        @param anEntry  The object that is the desired entry.
        @return  True if the list contains anEntry, or false if not. */
    public boolean contains(T anEntry)
    {
        return getPosition(anEntry) > 0;
    } // end contains

    /** Removes the entry at a given position from this list.
        Entries originally at positions higher than the given position are at the
        next lower position within the list, and the list’s size is decreased by 1.
        @param givenPosition  An integer that indicates the position of the entry
                              to be removed. Any givenPosition is invalid if empty.
        @return  A reference to the removed entry.
        @throws  IndexOutOfBoundsException if either
                 givenPosition < 1 or givenPosition > getLength(). */
    public T remove(int givenPosition)
    {
        return list.remove(givenPosition);
    } // end remove
    
    /** Removes all entries from this list. */
    public void clear()
    {
        list.clear();
    } // end clear
    
    /** Gets the length of this list.
        @return  The integer number of entries currently in the list. */
    public int getLength()
    {
        return list.getLength();
    } // end getLength
    
    /** Sees whether this list is empty.
        @return  True if the list is empty, or false if not. */
    public boolean isEmpty()
    {
        return list.isEmpty();
    } // end isEmpty

    /** Retrieves all entries that are in this list in the order in which they
        occur in the list.
        @return  A newly allocated array of all the entries in the list.
                 If the list is empty, the returned array is empty. */
    public T[] toArray()
    {        
        return list.toArray();
    } // end toArray
 
    
    // @author Frank M. Carrano, Timothy M. Henry
    // @version 5.0 */
    private class Node
    {
        private T    data;  // Entry in bag
        private Node next;  // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    } // end Node    
} // end SortedList
