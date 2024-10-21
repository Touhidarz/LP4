import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// import org.w3c.dom.Node;

/**
 *  Node
 */ 
class Node {

    int frequency;
    char data;
    Node left, right;

    Node(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;

        this.left = null;
        this.right = null;
    }
}

    class NodeComparator implements Comparator<Node> {
        public int compare(Node x, Node y) {
            return x.frequency - y.frequency;
    }
}


public class Daa_Ass2_Huffman_Encoding_greedy_Strategy {

    public static void printCodes (Node root, String code, Map<Character, String>huffmanCode) {
        
        if(root == null) {
            return;    
        }

        if (root.left == null && root.right == null) {
            huffmanCode.put(root.data, code);
        }

        printCodes(root.left, code + "0", huffmanCode);
        printCodes(root.right, code + "1", huffmanCode);
    }

    public static void buildHuffmanTree(char[] chars, int[] freq) {

        PriorityQueue<Node> pq = new PriorityQueue<>(chars.length, new NodeComparator());

        for(int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        while(pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();
            Node sum = new Node('-', left.frequency + right.frequency);
                sum.left = left;
                sum.right = right;
                pq.add(sum);
        }

            Node root = pq.poll();

            Map<Character, String> huffmanCode = new HashMap<>();

            printCodes(root, null, huffmanCode);

            System.out.println("Huffman Codes : - ");

            for(Map.Entry<Character, String> entry : huffmanCode.entrySet()) {

                System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {   
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};

        int[] freq = {5, 9, 12, 13, 16, 45};

        buildHuffmanTree(chars, freq);
    }   
}