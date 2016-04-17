package TwoThreeFourTree;

/**
 * Created by Home on 3/23/2016.
 */
public class Item<K extends Comparable,V> implements Comparable<Item<K,V>> {

    public K key;
    public V value;

    public Item(K key,V value)
    {
        this.key=key;
        this.value=value;
    }


    public int compareTo(Item<K, V> o) {
      return key.compareTo(o.key);
    }
}
