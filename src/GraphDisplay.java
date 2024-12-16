class GraphDisplay {
    private final Graph graph; // Граф, который мы будем отображать

    // Конструктор графа
    public GraphDisplay(Graph graph) {
        this.graph = graph; // Инициализация графа
    }

    // Метод для отображения рёбер графа
    public void show() {
        for (Edge edge : graph.getEdges()) {
            System.out.println(edge); // Вывод информации о каждом ребре
        }
        System.out.println(); // Пустая строка для разделения выводов
    }

    // Метод для отображения всех вершин графа
    public void showTop() {
        boolean[] peak = new boolean[1001]; // Массив для отслеживания вершин

        for (Edge edge : graph.getEdges()) {
            int top1 = edge.getTop1();
            int top2 = edge.getTop2();

            if (!peak[top1]) {
                peak[top1] = true; // Отмечаем первую вершину
            }
            if (!peak[top2]) {
                peak[top2] = true; // Отмечаем вторую вершину
            }
        }

        // Выводим вершины в порядке убывания
        for (int i = 1000; i >= 0; i--) {
            if (peak[i])
                System.out.println(i);
        }
        System.out.println(); // Пустая строка для разделения выводов
    }

    // Метод для отображения вершин с весом входящих рёбер меньше или равным заданному значению
    public void showTop2Limit(int value) {
        int[] top2Weight = new int[1001]; // Массив для хранения весов входящих рёбер

        // Перебираем все рёбра графа
        for (Edge edge : graph.getEdges()) {
            int top1 = edge.getTop1(); // Первая вершина
            int top2 = edge.getTop2(); // Вторая вершина
            int weight = edge.getWeight(); // Вес ребра

            // Суммируем вес для обеих вершин
            top2Weight[top1] += weight; // Учитываем вес для первой вершины
            top2Weight[top2] += weight; // Учитываем вес для второй вершины
        }

        // Выводим вершины, у которых общий вес входящих рёбер не превышает указанного значения
        for (int i = 0; i < top2Weight.length; i++) {
            if (top2Weight[i] <= value && top2Weight[i] > 0) {
                System.out.println(i);
            }
        }
        System.out.println(); // Пустая строка для разделения выводов
    }

    // Метод для отображения вершин, отсортированных по весу входящих рёбер
    public void showTopsSortedWeight() {
        int[] top2Weight = new int[1001]; // Массив для хранения весов
        int[] topX = new int[1001]; // Массив для хранения индексов вершин

        for (Edge edge : graph.getEdges()) {
            int top2 = edge.getTop2();

            top2Weight[top2] += edge.getWeight(); // Суммируем веса для каждой вершины
        }

        for (int i = 0; i < top2Weight.length; i++) {
            topX[i] = i; // Заполняем массив индексов
        }

        // Сортировка вершин по весу входящих рёбер
        for (int i = 1; i < topX.length; i++) {
            for (int j = 0; j < topX.length - i; j++) {
                if (top2Weight[topX[j]] < top2Weight[topX[j + 1]] || (top2Weight[topX[j]] == top2Weight[topX[j + 1]] && topX[j] < topX[j + 1])) {
                    // Меняем местами индексы, если нужно
                    int temp = topX[j];
                    topX[j] = topX[j + 1];
                    topX[j + 1] = temp;
                }
            }
        }

        // Выводим отсортированные вершины
        for (int i = 0; i < topX.length; i++) {
            if (top2Weight[topX[i]] > 0) {
                System.out.println(topX[i]);
            }
        }
        System.out.println(); // Пустая строка для разделения выводов
    }
}
