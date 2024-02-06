package Design.Hashmash;
public class MyHashMap<K, V>{

    private static final int INITIAL_CAPACITY = (1 << 4);
    private static final int MAXIMUM_CAPACITY = (1 << 30);
    private Entity<K, V>[] hashTable;

    public MyHashMap() {
        this.hashTable = new Entity[INITIAL_CAPACITY];
    }

    public MyHashMap(int capacity) {
        int tableSize = findTableSizeForCapacity(capacity);
        this.hashTable = new Entity[tableSize];
    }

    public void put(K key, V value) {
        int hashcode = key.hashCode() % hashTable.length;
        Entity<K, V> node = hashTable[hashcode];

        if (node == null) {
            node = new Entity(key, value);
            hashTable[hashcode] = node;
        } else {
            while (node.getNext() != null) {
                if (node.getKey().equals(key)) {
                    node.setValue(value);
                    return;
                }
                node = node.getNext();
            }
            node.setNext(new Entity<>(key, value));
        }
    }

    public V get(K key) {
        int hashcode = key.hashCode() % hashTable.length;
        Entity<K, V> node = hashTable[hashcode];
        while (node != null) {
            if(node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    private int findTableSizeForCapacity(int capacity) {
        int n = capacity - 1;
        n = n | n >>> 1;
        n = n | n >>> 2;
        n = n | n >>> 4;
        n = n | n >>> 8;
        n = n | n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : n + 1);
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>(7);
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Farhan");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");
        String value = map.get(9);
        System.out.println(value);
    }
}