import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {
        // @source StudentArrayDequeLauncher.java
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ans = new ArrayDequeSolution<>();
        Integer random;

        for (int i = 0; i < 10; i++) {
            // addFirst
            random = StdRandom.uniform(100);
            sad.addFirst(random);
            ans.addFirst(random);
            assertEquals("\naddFirst(" + random + ")\n", ans.get(i), sad.get(i));
            System.out.println("addFirst("+random+")");
        }


        for (int i = 0; i < 10; i++) {
            // addLast
            random = StdRandom.uniform(100);
            sad.addLast(random);
            ans.addLast(random);
            assertEquals("\naddLast(" + random + ")\n", ans.get(1), sad.get(1));
            System.out.println("addLast("+random+")");
        }


        for (int i = 0; i < 10; i++) {
            // removeFirst
            assertEquals("\nremoveFirst()\n", ans.removeFirst(), sad.removeFirst());
            System.out.println("removeFirst()");
        }


        for (int i = 0; i < 10; i++) {
            // removeLast
            assertEquals("\nremoveLast()\n", ans.removeLast(), sad.removeLast());
            System.out.println("removeLast()");
        }

    }
}
