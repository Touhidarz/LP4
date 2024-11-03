import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

// Node class for the Huffman tree
class Node implements Comparable<Node> {
    int frequency;
    char character;
    Node left, right;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanCoding {

    // Build the Huffman tree and generate codes
    public static Map<Character, String> generateHuffmanCodes(String text) {
        // Calculate frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue for the Huffman tree
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.offer(new Node(entry.getKey(), entry.getValue()));
        }

        // Build the Huffman tree
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node newNode = new Node('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            priorityQueue.offer(newNode);
        }

        // Generate Huffman codes
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(priorityQueue.poll(), "", huffmanCodes);
        return huffmanCodes;
    }

    // Helper method to generate codes recursively
    private static void generateCodes(Node root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.character, code);
        }
        generateCodes(root.left, code + "0", huffmanCodes);
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    // Main method to test Huffman encoding
    public static void main(String[] args) {
        String text = "huffman coding example";
        Map<Character, String> huffmanCodes = generateHuffmanCodes(text);

        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
