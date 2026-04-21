package Bashirova;
import java.util.*;

// Узел дерева
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {//для листа (A,5)
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq, Node left, Node right) {
        this.ch = '\0'; // внутренний узел хранит сложенные частоты детей и \0 в нулевого качестве символа
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

public class Main {

    // Построение кодов
    public static void buildCodes(Node root, String code, Map<Character, String> map) {
        if (root == null) return;

        // Если лист — сохраняем код
        if (root.left == null && root.right == null) {
            map.put(root.ch, code);
        }

        buildCodes(root.left, code + "0", map);
        buildCodes(root.right, code + "1", map);
    }

    public static void main(String[] args) {
        String text = "ABRACADABRA";

        // 1. Считаем частоты
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // 2. Очередь с приоритетом (минимальная куча) доступ к мин. эл O(1), сортировка по правилу компаратора, который сравнивает по узлы по частотам
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // 3. Строим дерево
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left.freq + right.freq, left, right);
            pq.add(parent);
        }

        Node root = pq.poll();

        // 4. Генерируем коды
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildCodes(root, "", huffmanCodes);

        // Вывод кодов
        System.out.println("Коды Хаффмана:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 5. Кодируем строку
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            encoded.append(huffmanCodes.get(c));
        }

        System.out.println("\nИсходная строка: " + text);
        System.out.println("Закодированная строка: " + encoded.toString());
    }
}