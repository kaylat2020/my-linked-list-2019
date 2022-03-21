import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Testing class.
 * @author Kayla Tucker
 * @version 10/24/2018
 */
public class MyLinkedListTest
{
    private MyLinkedList<Object> var1;

    private ArrayList<Integer> v2 =
        new ArrayList<Integer>( Arrays.asList( 1, 2, 3, 4 ) );
    
    private MyLinkedList<Integer> var2;

    private ArrayList<String> v3;
        
    private MyLinkedList<String> var3;

    private ArrayList<Object> v4 =
        new ArrayList<Object>();
    private MyLinkedList<Object> var4;

    /**
     * Initializes all undefined variables.
     */
    @Before
    public void setUp()
    {
        v3 = new ArrayList<String>( Arrays.asList( "Spooky" ,
                                                    "Scary" ,
                                                    "Skeletons" ) );
        var1 = new MyLinkedList<Object>();
        var2 = new MyLinkedList<Integer>( v2 );
        var3 = new MyLinkedList<String>( v3 );
        var4 = new MyLinkedList<Object>( v4 );
    }

    /**
     * Nullifies data to free RAM.
     */
    @After
    public void cleanUp()
    {
        var1 = null;
        var2 = null;
        var3 = null;
        var4 = null;
    }

    /**
     * comment
     */
    @Test
    public void testAdd1()
    {
        assertTrue( "Oops" , var1.add("Oops") );
        assertEquals( "[Oops]" , var1.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testAdd2()
    {
        var3.add( 1 , "Sc-" );
        assertEquals( "[Spooky, Sc-, Scary, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testAdd3()
    {
        var3.add( 0 , "Sc-" );
        assertEquals( "[Sc-, Spooky, Scary, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testAddBad1()
    {
        assertTrue( var1.isEmpty() );
        var3.add( 8 , "oops" );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testAddBad2()
    {
        assertTrue( var1.isEmpty() );
        var3.add( -3 , "oops" );
    }

    /**
     * comment
     */
    @Test
    public void testSize()
    {
        assertEquals( 3 , var3.size() );
    }

    /**
     * comment
     */
    @Test
    public void testRemove1()
    {
        assertTrue( var3.remove( "Spooky" ) );
        assertEquals( "[Scary, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testRemove2()
    {
        assertTrue( var3.remove( "Scary" ) );
        assertEquals( "[Spooky, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testRemove3()
    {
        assertTrue( var3.remove( "Skeletons" ) );
        assertEquals( "[Spooky, Scary]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testRemoveIndex1()
    {
        assertEquals( "Skeletons" , var3.remove( 2 ) );
        assertEquals( "[Spooky, Scary]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testRemoveIndex2()
    {
        assertEquals( "Spooky" , var3.remove( 0 ) );
        assertEquals( "[Scary, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testRemoveIndex3()
    {
        assertEquals( "Scary" , var3.remove( 1 ) );
        assertEquals( "[Spooky, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveIndexBad1()
    {
        assertTrue( var1.isEmpty() );
        var3.remove( (int)-4 );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveIndexBad2()
    {
        assertTrue( var1.isEmpty() );
        var3.remove( 7 );
    }

    /**
     * comment
     */
    @Test
    public void testRemoveBad()
    {
        assertFalse( var3.remove( "Spoopy" ) );
    }

    /**
     * comment
     */
    @Test
    public void testRemoveRange1()
    {
        var2.removeRange( 1 , 3 );
        assertEquals( "[1, 4]" , var2.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testRemoveRange2()
    {
        var2.removeRange( 0 , 3 );
        assertEquals( "[4]" , var2.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testRemoveRange3()
    {
        var2.removeRange( 2 , 3 );
        assertEquals( "[1, 2, 4]" , var2.toString() );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveRangeBad1()
    {
        assertEquals( "[]" , var1.toString() );
        var3.removeRange( 0 , 7 );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveRangeBad2()
    {
        assertEquals( "[]" , var1.toString() );
        var3.removeRange( -4 , 2 );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveRangeBad3()
    {
        assertEquals( "[]" , var1.toString() );
        var3.removeRange( 5 , 2 );
    }

    /**
     * comment
     */
    @Test
    public void testRemoveRangeOnEmpty()
    {
    	var1.removeRange( 0 , 0 );
        assertEquals( "[]" , var1.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testClear()
    {
        var3.clear();
        assertEquals( "[]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testGet1()
    {
        assertEquals( "Scary" , var3.get( 1 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testGet2()
    {
        assertEquals( "Spooky" , var3.get( 0 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testGet3()
    {
        assertEquals( "Skeletons" , var3.get( 2 ) );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testGetBad1()
    {
        assertTrue( var1.isEmpty() );
        var2.get( -1 );
    }
    
    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testGetBad2()
    {
        assertTrue( var1.isEmpty() );
        var2.get( 7 );
    }

    /**
     * comment
     */
    @Test
    public void testSetHead()
    {
        var3.set( 0 , "Spoopy" );
        assertEquals( "[Spoopy, Scary, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testSet()
    {
        assertEquals( "Scary" , var3.set( 1 , "Sc-" ) );
        assertEquals( "[Spooky, Sc-, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testSetBad1()
    {
        assertTrue( var1.isEmpty() );
        var3.set( 5, "bloop" );
    }

    /**
     * comment
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testSetBad2()
    {
        assertTrue( var1.isEmpty() );
        var3.set( -3, "bloop " );
    }
    /**
     * comment
     */
    @Test
    public void testIsEmptyOnTrue()
    {
        assertTrue( var1.isEmpty() );
    }

    /**
     * comment
     */
    @Test
    public void testIsEmptyOnFalse()
    {
        assertFalse( var3.isEmpty() );
    }

    /**
     * comment
     */
    @Test
    public void testIsIndexOf()
    {
        assertEquals( 2 , var3.indexOf( "Skeletons" ) );
    }

    /**
     * comment
     */
    @Test
    public void testIsIndexOfBad()
    {
        assertEquals( -1 , var3.indexOf( "Spoopy" ) );
    }

    /**
     * comment
     */
    @Test
    public void testLastIndexOf()
    {
        var2.add( 4 );
        assertEquals( 4 , var2.lastIndexOf( 4 ) );
    }

    /**
     * comment
     */
    @Test
    public void testLastIndexOfBad()
    {
        assertEquals( -1 , var4.lastIndexOf( 6 ) );
    }

    /**
     * comment
     */
    @Test
    public void testToArrayEmpty()
    {
        assertEquals( "[]" , var1.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testToEqualsOnEmpty()
    {
        assertTrue( var1.equals( var4 ) );
    }

    /**
     * comment
     */
    @Test
    public void testToEqualsOnTrue1()
    {
        var1.add( 1 );
        var1.add( 2 );
        var1.add( 3 );
        var1.add( 4 );
        assertTrue( var1.equals( var2 ) );
    }

    /**
     * comment
     */
    @Test
    public void testToEqualsOnFalse1()
    {
        assertFalse( var3.equals( "oops" ) );
    }

    /**
     * comment
     */
    @Test
    public void testToEqualsOnFalse2()
    {
        var1.add( 1 );
        var1.add( 2 );
        var1.add( 3 );
        var1.add( 1 );
        assertFalse( var1.equals( var2 ) );
    }

    /**
     * comment
     */
    @Test
    public void testToEqualsOnTrue2()
    {
        assertTrue( var4.equals( var1 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testToEqualsOnTrue3()
    {
    	MyLinkedList<String> var5 = new MyLinkedList<>();
    	var5.add( "Spooky" );
    	var5.add( "Scary" );
    	var5.add( "Skeletons" );
        assertTrue( var3.equals( var5 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testToEqualsOnTrue4()
    {
    	MyLinkedList<String> var5 = var3;
        assertTrue( var3.equals( var5 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testToEqualsOnFalse5()
    {
        var1.add( 1 );
        var1.add( 2 );
        var1.add( 3 );
        assertFalse( var1.equals( var2 ) );
    }

    /**
     * comment
     */
    @Test
    public void testGetNode()
    {
        assertEquals( 4 , var2.get( 3 ) );
    }
    
    /**
     * comment
     */
    @Test
    public void testGetNodeBad()
    {
        assertEquals( null , var1.getNode( 3 ) );
    }

    /**
     * comment
     */
    @Test
    public void testToArray1()
    {
        var1.add( "Spooky" );
        assertArrayEquals( new String[]{ "Spooky" } , var1.toArray() );
    }

    /**
     * comment
     */
    @Test
    public void testToArray2()
    {
        assertArrayEquals( new String[]{ "Spooky",
                                         "Scary",
                                         "Skeletons" }, var3.toArray() );
    }

    /**
     * comment
     */
    @Test
    public void testToString1()
    {
        assertEquals( "[Spooky, Scary, Skeletons]" , var3.toString() );
    }

    /**
     * comment
     */
    @Test
    public void testToString2()
    {
        assertEquals( "[]" , var4.toString() );
    }
}
