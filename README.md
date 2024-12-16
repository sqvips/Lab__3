# LabN3
## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2402`

#### Выполнил: `Савушкин Павел Павлович`

#### Вариант: `21`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Почему я разделил задачу на данные классы](#2-классы)
- [Описание](#3-описание)

### 1. Постановка задачи

- Условия задачи
  > Передо мной стояла задача разработать программу для работы с взвешенным графом, представленным рёбрами с начальной и конечной вершинами и весом. Также реализовать некоторые, нижеперечисленные функции для работы с ним.

### 2. Классы

Мы знаем, что каждый класс отвечает за конкретную задачу, разделяя большую программу на несколько маленьких. Я сделал также, разделив программу на четыре "части". Так, например, класс `Edge` управляет рёбрами графа, класс `Graph` управляет логикой работы с графом (добавление, удаление рёбер, объединение и т.д.), а класс `GraphDisplay` отвечает за отображение информации о графе. Последним же - является главный класс для запуска программы, одновременно являющийся тестовой программой.
Теперь немного подробнее.
1. Класс `Edge`:
Представление рёбер: Класс Edge отвечает за представление рёбер графа. Ребро связывает две вершины и имеет вес. Этот класс инкапсулирует все необходимые данные о ребре (две вершины и вес) и методы для работы с ними.
Упрощение работы с рёбрами: Наличие отдельного класса для рёбер позволяет легко управлять их свойствами и методами (например, изменение веса, сравнение рёбер и т.д.).
2. Класс `Graph`:
Логика графа: Класс Graph отвечает за основную логику работы с графом, включая добавление, удаление и изменение рёбер. Этот класс управляет коллекцией рёбер и реализует алгоритмы, связанные с графами (например, объединение графов, удаление вершин и т.д.).
Инкапсуляция данных: Класс Graph инкапсулирует логику работы с рёбрами. Пользователь может добавлять рёбра и выполнять операции над графом, не беспокоясь о внутренней реализации.
3. Класс `GraphDisplay`:
Отображение данных: Класс GraphDisplay отвечает исключительно за отображение информации о графе. Он содержит методы для вывода рёбер, вершин и сортировки. Это разделение позволяет отделить логику отображения от логики работы с данными.
Упрощение визуализации: Наличие отдельного класса для отображения упрощает изменение способа вывода данных (например, можно легко изменить формат вывода или добавить графический интерфейс), не затрагивая логику работы с графом.

### 3. Описание

Как было написано в рекомендациях к выполнению, разберу математические модели, но чуть позже. В этот раз мы учтем тестовый класс `Main`.

