    // Ana Paula Hong 22731
public class SplayTree {


import java.util.ArrayList;
import java.util.Comparator;

public class SplayTree <K, V> implements ISplayTree<K, V> {
    private int count;
	private treeNode<K, V> root;
	private Comparator<K> keyComparator;
    
    public BinarySearchTree(Comparator<K> _keyComparator) {
		this.keyComparator = _keyComparator;
		root = null;
		count = 0;
	}

}
}
