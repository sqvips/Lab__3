public class Edge {
    private final int top1; // Первая вершина
    private final int top2; // Вторая вершина
    private int weight; // Вес ребра

    // Конструктор ребра
    public Edge(int top1, int top2, int weight) {
        this.top1 = Math.min(top1, top2); // Устанавливаем вершины в порядке возрастания
        this.top2 = Math.max(top1, top2);
        this.weight = weight; // Устанавливаем вес ребра
    }

    // Геттер для первой вершины
    public int getTop1() {
        return top1;
    }

    // Геттер для второй вершины
    public int getTop2() {
        return top2;
    }

    // Геттер для веса
    public int getWeight() {
        return weight;
    }

    // Сеттер для веса с проверкой на отрицательные значения
    public void setWeight(int weight) {
        if (weight < 0) {
            System.out.println("Вес ребра не может быть отрицательным");
        } else {
            this.weight = weight; // Устанавливаем новый вес
        }
    }

    // Переопределение метода toString для вывода информации о ребре
    @Override
    public String toString() {
        return top1 + " - " + top2 + " (" + weight + ")";
    }
}

