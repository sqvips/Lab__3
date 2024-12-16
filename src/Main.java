// Главный класс для запуска программы
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(); // Создаем новый граф

        // Добавляем рёбра в граф
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 1, 8);
        graph.addEdge(4, 5, 19);

        Graph graph1 = new Graph(); // Создаем еще один граф
        graph1.addEdge(1, 2, 10);
        graph1.addEdge(2, 3, 20);

        graph.combine(graph1); // Объединяем два графа
        GraphDisplay graphDisplay = new GraphDisplay(graph); // Создаем объект для отображения первого графа
        GraphDisplay graphDisplay1 = new GraphDisplay(graph1); // Создаем объект для отображения второго графа
        graphDisplay.show(); // Отображаем первый граф

        graph.removeTopsMinMax(); // Удаляем вершины с максимальным весом и минимальным количеством входящих рёбер
        graphDisplay.show(); // Отображаем граф после удаления

        graphDisplay.showTop(); // Отображаем все вершины графа
        graphDisplay.showTop2Limit(18); // Отображаем вершины с весом входящих рёбер <= 18
        graphDisplay.showTopsSortedWeight(); // Отображаем вершины, отсортированные по весу

        graph.combineEdges(2, 1); // Объединяем рёбра между вершинами 2 и 1
        graphDisplay.show(); // Отображаем граф после объединения

        graph.changeEdgeWeight(1, 2, -100); // Изменяем вес ребра между вершинами 1 и 2 на -100
        graphDisplay.show(); // Отображаем граф после изменения веса

        graph.removeEdgesBetween(1, 2); // Удаляем рёбра между вершинами 1 и 2
        graphDisplay.show(); // Отображаем граф после удаления рёбер

        graph1.removeTops(2); // Удаляем вершину 2 из второго графа
        graphDisplay.show(); // Отображаем первый граф после удаления
        graphDisplay.showTop(); // Отображаем все вершины первого графа
    }
}




