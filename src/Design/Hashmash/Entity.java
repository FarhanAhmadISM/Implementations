package Design.Hashmash;

public class Entity<K, V> {
    private K key;
    private V value;
    private Entity<K, V> next;

    public Entity(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entity<K, V> getNext() {
        return next;
    }

    public void setNext(Entity<K, V> next) {
        this.next = next;
    }
}
