import java.util.HashMap;

/**
 * @author zhangnan
 * @date 2021/9/2
 */
public class LRUCache {

    class Node {
        int key;
        int value;

        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        private Node dummyHead;
        private Node dummyTail;

        private int size;

        public DoubleList() {
            this.dummyHead = new Node(0, 0);
            this.dummyTail = new Node(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
            this.size = 0;
        }


        public void addLast(Node node) {
            Node prev = dummyTail.prev.prev;
            node.next = dummyTail;
            dummyTail.prev = node;
            prev.next = node;
            node.prev = prev;
            size++;
        }


        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeFirst() {
            if (dummyHead.next == dummyTail) {
                return null;
            }
            Node head = dummyHead.next;
            remove(head);
            return head;
        }

        public int getSize() {
            return size;
        }
    }


    private HashMap<Integer, Node> map;

    private DoubleList cache;

    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleList();
        this.capacity = capacity;
    }


    // 使某个元素存放在最后
    private void makeElementRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node node = cache.removeFirst();
        int deleteKey = node.key;
        map.remove(deleteKey);
    }


    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeElementRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (capacity == cache.getSize()) {
            removeLeastRecently();
        }
        addRecently(key, value);


    }


}
