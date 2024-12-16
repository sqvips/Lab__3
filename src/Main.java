public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(); // Создаем новый граф

        // Добавляем рёбра в граф
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 1, 8);
        graph.addEdge(4, 5, 19);
        graph.addEdge(3, 4, 12);
        graph.addEdge(5, 1, 6);
        graph.addEdge(2, 4, 11);
        graph.addEdge(3, 5, 9);
        graph.addEdge(1, 4, 14);
        graph.addEdge(2, 5, 20);
        graph.addEdge(4, 6, 30);
        graph.addEdge(6, 7, 25);
        graph.addEdge(7, 1, 5);

        Graph graph1 = new Graph(); // Создаем еще один граф
        graph1.addEdge(5, 1, 6);
        graph1.addEdge(100, 65, 1);
        // Создаем объект для отображения объединенного графа
        GraphDisplay graphDisplay = new GraphDisplay(graph);

        graphDisplay.show();

        graphDisplay.showTop();

        graphDisplay.showTop2Limit(30);

        graphDisplay.showTopsSortedWeight();

        graph.combineEdges2(1, 2);
        graphDisplay.show();

        graph.combineEdges(1, 2);
        graphDisplay.show();

        graph.changeEdgeWeight(1, 2, 5);
        graphDisplay.show();

        graph.removeEdgesBetween(1, 2);
        graphDisplay.show();

        graph.removeTops(3);
        graphDisplay.show();

        graph.removeTopsMinMax();
        graphDisplay.show();

        graph.combine(graph1);
        graphDisplay.show();

    }
}




