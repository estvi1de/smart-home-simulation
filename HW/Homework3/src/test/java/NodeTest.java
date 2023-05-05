import cz.cvut.k36.omo.hw.hw03.CustomIterator;
import cz.cvut.k36.omo.hw.hw03.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Sample tests for OMO/2016L HW3 come without any warranty
 *
 * @author Pavel Krulec krulepav@fel.cvut.cz
 */
public class NodeTest {
    private Node root_big;
    private Node root_small;
    private Node root_wiki;
    private Node squeezer01;
    private Node squeezer02;

    @Before
    public void setUp() throws Exception {
        //Graph from http://datastructuresnotes.blogspot.cz/2009/02/binary-tree-traversal-preorder-inorder.html
        root_big = new Node(7, new Node(1, new Node(0, null, null), new Node(3, new Node(2, null, null), new Node(5, new Node(4, null, null), new Node(6, null, null)))),
                new Node(9, new Node(8, null, null), new Node(10, null, null)));

        //My own graph
        root_small = new Node(1, new Node(2, null, null), new Node(3, null, null));
        //new Node(0, null, root_small);

        //Graph from wiki https://en.wikipedia.org/wiki/Tree_traversal
        //Chars will be casted to ints so do not worry about it, it works well
        root_wiki = new Node('F', new Node('B', new Node('A', null, null), new Node('D', new Node('C', null, null), new Node('E', null, null))),
                new Node('G', null, new Node('I', new Node('H', null, null), null)));

        /*
        - 2
        L - 1
        R  - 2
        R - 2
        L  - 4
        R  - 5
        R   - 6
         */
        squeezer01 = new Node(2, new Node(1, null, new Node(2, null, null)), new Node(2, new Node(4, null, null), new Node(5, null, new Node(6, null, null))));

        /*
        - -695682206
        L - -1443185588
        L  - 908060144
        L   - 131644070
        L    - 1408561298
        L     - -1804482947
        L      - -2106934973
        L       - -1789893391
        L        - 1694107480
        L         - -1552062183
*/
        squeezer02 = new Node(-695682206, new Node(-1443185588, new Node(908060144, new Node(131644070, new Node(1408561298, new Node(-1804482947, new Node(-2106934973, new Node(-1789893391, new Node(1694107480, new Node(-1552062183, null, null), null), null), null), null), null), null), null), null), null);
    }

    @Test
    public void postorderIterator_Squeezer01() throws Exception {
        CustomIterator iterator = squeezer01.postorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{2, 1, 4, 6, 5, 2, 2};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            assertEquals("Check iterator.next i=" + i, expected[i], iterator.next());
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void inorderIterator_Squeezer02() throws Exception {
        CustomIterator iterator = squeezer02.inorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{-1552062183, 1694107480, -1789893391, -2106934973, -1804482947, 1408561298, 131644070, 908060144, -1443185588, -695682206};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            assertEquals("Check iterator.next i=" + i, expected[i], iterator.next());
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void preorderIterator_big() throws Exception {
        CustomIterator iterator = root_big.preorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            assertEquals("Check iterator.next i=" + i, iterator.next(), expected[i]);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void preorderIterator_small() throws Exception {
        CustomIterator iterator = root_small.preorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{1, 2, 3};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            int val = iterator.next();
            assertEquals("Check iterator.next i=" + i, expected[i], val);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void preorderIterator_wiki() throws Exception {
        CustomIterator iterator = root_wiki.preorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{'F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H'};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            assertEquals("Check iterator.next i=" + i, iterator.next(), expected[i]);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void inorderIterator_big() throws Exception {
        CustomIterator iterator = root_big.inorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            int val = iterator.next();
            System.out.println("GET: " + val);
            assertEquals("Check iterator.next i=" + i, expected[i], val);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void inorderIterator_small() throws Exception {
        CustomIterator iterator = root_small.inorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{2, 1, 3};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            assertEquals("Check iterator.next i=" + i, iterator.next(), expected[i]);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void inorderIterator_wiki() throws Exception {
        CustomIterator iterator = root_wiki.inorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            assertEquals("Check iterator.next i=" + i, iterator.next(), expected[i]);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void postorderIterator_big() throws Exception {
        CustomIterator iterator = root_big.postorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{0, 2, 4, 6, 5, 3, 1, 8, 10, 9, 7};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            assertEquals("Check iterator.next i=" + i, iterator.next(), expected[i]);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void postorderIterator_small() throws Exception {
        CustomIterator iterator = root_small.postorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{2, 3, 1};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            int val = iterator.next();
            System.out.println("GETf: " + val);
            assertEquals("Check iterator.next i=" + i, val, expected[i]);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }

    @Test
    public void postorderIterator_wiki() throws Exception {
        CustomIterator iterator = root_wiki.postorderIterator();
        if (iterator == null) {
            fail();
            return;
        }
        int[] expected = new int[]{'A', 'C', 'E', 'D', 'B', 'H', 'I', 'G', 'F'};

        for (int i = 0; i < expected.length; i++) {
            assertTrue("Check hasNext while iterating i=" + i, iterator.hasNext());
            assertEquals("Check iterator.next i=" + i, iterator.next(), expected[i]);
        }
        assertFalse("Check has no more next after iterating everything", iterator.hasNext());
    }
}