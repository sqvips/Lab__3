import java.util.ArrayList;
import java.util.List;

// Класс, представляющий граф
class Graph {
    private final List<Edge> edges; // Список рёбер графа

    // Конструктор графа
    public Graph() {
        edges = new ArrayList<>(); // Инициализация списка рёбер
    }

    // Метод для получения рёбер графа
    public List<Edge> getEdges() {
        return edges; // Возвращаем список рёбер
    }

    // Метод для добавления нового ребра в граф
    public void addEdge(int top1, int top2, int weight) {
        if (top1 == top2) return; // Не добавляем ребро между одной и той же вершиной
        Edge edgeNew = new Edge(top1, top2, weight); // Создаем новое ребро
        edges.add(edgeNew); // Добавляем ребро в список
    }

    // Метод для объединения рёбер между двумя вершинами
    public void combineEdges(int top_1, int top_2) {
        List<Edge> edgesToCombine = new ArrayList<>(); // Список рёбер для объединения
        int totalWeight = 0; // Общий вес объединяемых рёбер
        int firstEdgeIndex = -1; // Индекс первого рёбер для вставки нового

        // Поиск рёбер, которые нужно объединить
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if ((edge.getTop1() == top_1 && edge.getTop2() == top_2) || (edge.getTop1() == top_2 && edge.getTop2() == top_1)) {
                edgesToCombine.add(edge); // Добавляем ребро в список для объединения
                totalWeight += edge.getWeight(); // Суммируем вес рёбер

                if (firstEdgeIndex == -1) {
                    firstEdgeIndex = i; // Запоминаем индекс первого ребра
                }
            }
        }

        // Если рёбер для объединения не найдено
        if (edgesToCombine.isEmpty()) {
            System.out.println("Нет рёбер для объединения между вершинами " + top_1 + " и " + top_2);
            return;
        }

        edges.removeAll(edgesToCombine); // Удаляем все объединяемые рёбра

        Edge firstEdge = edgesToCombine.get(0); // Получаем первое ребро
        Edge newEdge = new Edge(top_1, top_2, totalWeight); // Создаем новое ребро с общим весом

        edges.add(firstEdgeIndex, newEdge); // Вставляем новое ребро в список
    }

    // Метод для объединения рёбер между двумя вершинами (другой вариант)
    public void combineEdges2(int top_1, int top_2) {
        List<Edge> edgesToCombine = new ArrayList<>(); // Список рёбер для объединения
        int totalWeight = 0; // Общий вес объединяемых рёбер
        int firstEdgeIndex = -1; // Индекс первого рёбер для вставки нового

        // Поиск рёбер, которые нужно объединить
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if ((edge.getTop1() == top_1 && edge.getTop2() == top_2) || (edge.getTop1() == top_2 && edge.getTop2() == top_1)) {
                edgesToCombine.add(edge); // Добавляем ребро в список для объединения
                totalWeight += edge.getWeight(); // Суммируем вес рёбер

                if (firstEdgeIndex == -1) {
                    firstEdgeIndex = i; // Запоминаем индекс первого ребра
                }
            }
        }

        // Если рёбер для объединения не найдено
        if (edgesToCombine.isEmpty()) {
            System.out.println("Нет рёбер для объединения между вершинами " + top_1 + " и " + top_2);
            return;
        }

        Edge firstEdge = edgesToCombine.get(0); // Получаем первое ребро
        Edge newEdge = new Edge(top_1, top_2, totalWeight); // Создаем новое ребро с общим весом

        edges.remove(firstEdgeIndex); // Удаляем первое ребро
        edges.add(firstEdgeIndex, newEdge); // Вставляем новое ребро в список
    }

    // Метод для изменения веса ребра между двумя вершинами
    public void changeEdgeWeight(int top_1, int top_2, int weightNew) {
        for (Edge edge : edges) {
            // Проверяем, есть ли ребро между вершинами
            if ((edge.getTop1() == top_1 && edge.getTop2() == top_2) || (edge.getTop1() == top_2 && edge.getTop2() == top_1)) {
                // Проверяем, не станет ли вес отрицательным
                if (edge.getWeight() + weightNew < 0) {
                    System.out.println("Вес ребра не может быть отрицательным");
                    return;
                } else {
                    edge.setWeight(edge.getWeight() + weightNew); // Изменяем вес ребра
                }
            }
        }
    }

    // Метод для удаления рёбер между двумя вершинами
    public void removeEdgesBetween(int top_1, int top_2) {
        for (int i = edges.size() - 1; i >= 0; i--) { // Проходим с конца, чтобы избежать ошибок при удалении
            Edge edge = edges.get(i);

            // Проверяем, есть ли ребро между вершинами
            if ((edge.getTop1() == top_1 && edge.getTop2() == top_2) || (edge.getTop1() == top_2 && edge.getTop2() == top_1)) {
                edges.remove(i); // Удаляем ребро
            }
        }
    }

    // Метод для удаления вершин по заданному номеру
    public void removeTops(int top) {
        for (int i = edges.size() - 1; i >= 0; i--) { // Проходим с конца, чтобы избежать ошибок при удалении
            Edge edge = edges.get(i);

            // Проверяем, связано ли ребро с удаляемой вершиной
            if (edge.getTop1() == top || edge.getTop2() == top) {
                edges.remove(i); // Удаляем ребро
            }
        }
    }

    // Метод для удаления вершин с максимальным весом и минимальным количеством входящих рёбер
    public void removeTopsMinMax() {
        int n = 1001; // Максимальное количество вершин
        int[] incomingWeights = new int[n]; // Массив для хранения весов входящих рёбер
        int[] incomingCounts = new int[n]; // Массив для хранения количества входящих рёбер

        // Подсчет весов и количества входящих рёбер
        for (Edge edge : edges) {
            incomingWeights[edge.getTop2()] += edge.getWeight(); // Суммируем веса
            incomingCounts[edge.getTop2()]++; // Увеличиваем счетчик
        }

        // Поиск максимального веса
        int maxWeight = Integer.MIN_VALUE;
        for (int weight : incomingWeights) {
            if (weight > maxWeight) {
                maxWeight = weight; // Запоминаем максимальный вес
            }
        }

        // Поиск минимального количества входящих рёбер
        int minCount = Integer.MAX_VALUE;
        for (int count : incomingCounts) {
            if (count > 0 && count < minCount) {
                minCount = count; // Запоминаем минимальное количество
            }
        }

        // Удаление вершин с максимальным весом или минимальным количеством входящих рёбер
        for (int i = 0; i < n; i++) {
            if (incomingWeights[i] == maxWeight || (incomingCounts[i] > 0 && incomingCounts[i] == minCount)) {
                removeTops(i); // Удаляем вершину
            }
        }
    }

    // Метод для объединения рёбер из другого графа
    public void combine(Graph newGraph) {
        for (Edge newGraphEdge : newGraph.edges) { // Проходим по всем рёбрам нового графа
            boolean found = false; // Флаг для проверки наличия рёбер

            for (Edge currentEdge : edges) { // Проверяем существующие рёбра
                if (currentEdge.getTop1() == newGraphEdge.getTop1() && currentEdge.getTop2() == newGraphEdge.getTop2()) {
                    currentEdge.setWeight(currentEdge.getWeight() + newGraphEdge.getWeight()); // Объединяем веса
                    found = true; // Устанавливаем флаг
                    break; // Выходим из цикла
                }
            }

            // Если ребро не найдено, добавляем его в граф
            if (!found) {
                edges.add(new Edge(newGraphEdge.getTop1(), newGraphEdge.getTop2(), newGraphEdge.getWeight())); // Добавляем новое ребро
            }
        }
    }
}
