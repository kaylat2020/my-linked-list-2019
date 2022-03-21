import java.util.Collection;

/**
 * My recreation of the LinkedList class
 * @author Kayla Tucker
 * @version 10/24/2018
 * @param <E> type.
 */
public class MyLinkedList<E>
{
    private int size;
    private Node<E> head;

    /**
     * Inner Node class. Holds data for each node.
     * @author tuckerka20
     * @param <E> type.
     */
    static class Node<E>
    {
        private E data;
        private Node<E> next;

        /**
         * Links a new Node.
         * @param data contains Objects,
         * @param next points to next Node or null.
         */
        public Node( E data, Node<E> next )
        {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Default constructor.
     */
    public MyLinkedList()
    {
        size = 0;
        head = null;
    }

    /**
     * Converts a Collection into a MyLinkedList.
     * @param c is the Collection to be converted.
     */
    public MyLinkedList( Collection<E> c )
    {
        if ( ! c.isEmpty() )
        {
            addAll( c );
        }
        else
        {
            head = null;
        }
    }

    /**
     * Adds an element to the end of an array.
     * @param e is the element added.
     * @return true if added, false if not.
     */
    public boolean add( E e )
    {
        if ( isEmpty() )
        {
            head = new Node<E>( e , null );
        }
        else
        {
            Node<E> temp = head;
            while ( temp.next != null )
            {
                temp = temp.next;
            }

            temp.next = new Node<E>( e , null );
        }
        size++;

        return true;
    }

    /**
     * Adds an element at the index specified.
     * Shifts all elements around as necessary.
     * @param index given.
     * @param e element given.
     */
    public void add( int index , E e )
    {
        if ( index < 0 || index > size )
        {
            throw new IndexOutOfBoundsException();
        }

        if ( index == 0 )
        {
            head = new Node<>( e , head );
            size++;
            return;
        }
        Node<E> temp = getNode( index - 1 );
        temp.next = new Node<>( e , temp.next );

        size++;
    }

    /**
     * Removes the first occurrence of the
     * given element from MyLinkedList.
     * @param o is the Object to be found.
     * @return true if it was found and removed,
     * false if it wasn't.
     */
    public boolean remove( Object o )
    {
        if ( head.data.equals( o ) )
        {
            head = head.next;
            size--;
            return true;
        }

        if ( indexOf( o ) != -1 )
        {
            Node<E> cur  = head;
            Node<E> prev = null;

            while ( cur.next != null && !cur.data.equals( o ) )
            {
                prev = cur;
                cur = cur.next;
            }

            //deletes current node
            prev.next = cur.next;
            size--;
            return true;
        }
        return false;
    }

    /**
     * Removes the element at the given index.
     * @param index to be found.
     * @return Object keep at the index
     * before it was removed.
     */
    public Object remove( int index )
    {
        if ( ( index < 0 || index >= size ) )
        {
            throw new IndexOutOfBoundsException();
        }
        Object keep = get( index );
        removeRange( index , index + 1 );
        return keep;
    }

    /**
     * @param index to be found.
     * @return Object keep at the given index.
     */
    public Object get( int index )
    {
        if ( ( index < 0 || index >= size ) )
        {
            throw new IndexOutOfBoundsException();
        }
        return getNode( index ).data;
    }

    /**
     * Replaces the element at the given index
     * with the given element.
     * @param index to be found
     * @param e element to be set.
     * @return the element previously in that slot.
     */
    public Object set( int index , E e )
    {
        if ( ( index < 0 || index >= size ) )
        {
            throw new IndexOutOfBoundsException();
        }
        if ( index == 0 )
        {
            Object keep = head.data;
            head.data = e;
            return keep;
        }
        Object keep = get( index );
        getNode( index ).data = e;

        return keep;
    }

    /**
     * A method for the Node to get the size.
     * @return size how many nodes there are.
     */
    public int size()
    {
        return size;
    }

    /**
     * Searches the LinkedList for the given element.
     * @param o Object to be found.
     * @return true if found, false if not.
     */
    public boolean contains( Object o )
    {
        return indexOf( o ) != -1;
    }

    /**
     * @return true if this list contains no elements,
     * false if it does.
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * @return String that lists the elements in
     * the current MyLinkedList.
     */
    public String toString()
    {
        if ( size == 0 )
        {
            return "[]";
        }
        Object[] vals = toArray();
        StringBuilder str = new StringBuilder( "[" );

        for ( int i = 0 ; i < size - 1 ; i++ )
        {
            str.append( vals[ i ] + ", " );
        }

        str.append( vals[ size - 1 ] + "]" );

        return str.toString();
    }

    /**
     * Adds an array of elements to the current ArrayList.
     * @param c is the Collection to be added.
     */
    public void addAll( Collection<E> c )
    {
        for ( E e : c )
        {
            add( e );
        }
    }

    /**
     * Sets the size to zero.
     */
    public void clear()
    {
        head = null;
        size = 0;
    }

    /**
     * Searches the array for a given element.
     * @param o Object to be found.
     * @return int -1 if index isn't found.
     */
    public int indexOf( Object o )
    {
        Object [] a = toArray();

        for ( int i = 0 ; i < a.length ; i++ )
        {
            if ( a[ i ].equals( o ) )
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param o Object to be found.
     * @return int -1 if the last occurrence is never found.
     */
    public int lastIndexOf( Object o )
    {
        int holder = -1;
        if ( contains( o ) )
        {
            Object [] a = toArray();

            for ( int i = 0 ; i < a.length ; i++ )
            {
                if ( a[ i ].equals( o ) )
                {
                    holder = i;
                }
            }
        }
        return holder;
    }

    /**
     * Removes a set of elements within. 
     * @param from (inclusive) index given,
     * @param to (exclusive) index given.
     */
    public void removeRange( int from , int to)
    {
        if ( ( from < 0 || to < from || to > size ) )
        {
            throw new IndexOutOfBoundsException();
        }
        if ( from == 0 )
        {
            head = getNode( to );
            size -= to;
            return;
        }
        Node<E> f = getNode( from - 1 );
        Node<E> t = getNode( to - 1 );
        f.next = t.next;
        size -= ( to - from );
    }

    /**
     * Converts the current MyLinkedList into
     * an array of Objects.
     * @return Object[] array of the Nodes' data.
     */
    public Object [] toArray()
    {
        Object [] newVals = new Object[ size ];

        if ( head != null )
        {
            Node<E> temp = head;
            for ( int i  = 0 ; i < size ; i++ )
            {
                newVals[ i ] = temp.data;
                temp = temp.next;
            }
        }
        return newVals;
    }


    /**
     * Checks for a perfect match between
     * two MyLinkedLists.
     * @param o Object to be
     * @return true if equal, false if not.
     */
    public boolean equals( Object o )
    {
        if ( o == this )
            return true;

        if ( !( o instanceof MyLinkedList ) ) 
            return false;

        MyLinkedList<E> other = (MyLinkedList<E>)o;
        
        if ( size() == other.size() )
        {
            Node<E> temp = head;
            Node<E> otherTemp = other.head;
            while ( temp != null )
            {
                if ( !( temp.data.equals( otherTemp.data ) ) )
                {
                    return false;
                }
                temp = temp.next;
                otherTemp = otherTemp.next;
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    /**
     * Makes my life a little less painful
     * by allowing access to whole nodes.
     * ( Mr. Meermans does not approve. )
     * @param index to be found.
     * @return temp Node.
     */
    public Node<E> getNode( int index )
    {
        int i = 0;
        Node<E> temp = head;
        while ( temp != null )
        {
            if ( index == i )
            {
                return temp;
            }
            temp = temp.next;
            i++;
        }
        return temp;
    }
}