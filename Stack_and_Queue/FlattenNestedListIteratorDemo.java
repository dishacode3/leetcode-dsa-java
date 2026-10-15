package Stack_and_Queue;
import java.util.*;

public class FlattenNestedListIteratorDemo {

    static class NestedInteger {
        Integer value;
        List<NestedInteger> list;

        NestedInteger(int value) {
            this.value = value;
        }

        NestedInteger(List<NestedInteger> list) {
            this.list = list;
        }

        boolean isInteger() {
            return value != null;
        }

        Integer getInteger() {
            return value;
        }

        List<NestedInteger> getList() {
            return list;
        }
    }

    public static class NestedIterator implements Iterator<Integer> {
        private Deque<NestedInteger> stack = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger top = stack.peek();

                if (top.isInteger()) {
                    return true;
                }

                stack.pop();
                List<NestedInteger> list = top.getList();

                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }

            return false;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return stack.pop().getInteger();
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> nested = Arrays.asList(
            new NestedInteger(Arrays.asList(
                new NestedInteger(1),
                new NestedInteger(1)
            )),
            new NestedInteger(2),
            new NestedInteger(Arrays.asList(
                new NestedInteger(1),
                new NestedInteger(1)
            ))
        );

        NestedIterator iterator = new NestedIterator(nested);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}