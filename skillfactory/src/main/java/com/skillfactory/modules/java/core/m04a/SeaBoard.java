package com.skillfactory.modules.java.core.m04a;

public class SeaBoard {
    /* Итак, план решения:
    если с с методами getField() и check() все +- понятно,
    то как быть со сбитым кораблем?
    Мы предлагаем следующее:
    1 Давайте записывать попадание не как "x", а как "X", а сбитые
    корабли как "x",
    а при возвращении значений, просто заменять все "X", на "x"
    Тогда, как только пришла команда о сбитие корабля, мы легко обойдем
    участок сбития (см метод "sink()").
     */
    private String[][] field; // создаем приватное поле

    public SeaBoard() {
        field = new String[10][10]; // инициализируем и заполняем его в
        //конструкторе
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = ".";
            }
        }
    }

    String[][] getField() {
        String[][] result = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (field[i][j].equals("X")) result[i][j] = "x"; // как и
                    //говорилось в начале
                else result[i][j] = field[i][j];                 //
                //искусственно заменяем X на x
            }
        }
        return result; // создаем геттер для поля
    }

    String check(int line, int column) {
        if (field[line][column].equals("X")) return "x"; // тоже
        //искусственно заменяем X на x
        return field[line][column]; // метод чек, для проверки полей
    }

    void shoot(int line, int column, String issue) {
        if (issue.equals("m")) field[line][column] = "#"; // если
            //промахнулись, то просто ставим промах
        else if (issue.equals("h")) field[line][column] = "X"; // если
            //попали, но не потопили, то ставим X
        else {
            field[line][column] = "X"; // если же этим выстрелом корабль
            //был потоплен, то ставим попадание
            sink(line, column);        // и обрабатываем уничтожение в методе sink
        }
    }

    private void sink(int line, int column) {
        int[][] commands = new int[][]  // массив всех возможных полей,
                //которые надо поменять
                {{line - 1, column}, {line + 1, column}, // вокруг
                        //клетки, в которую попали
                        {line, column - 1}, {line, column + 1},
                        {line - 1, column - 1}, {line - 1, column + 1},
                        {line + 1, column - 1}, {line + 1, column + 1}};

        for (int[] i : commands) {
            if (0 <= i[0] && i[0] <= 9 && 0 <= i[1] && i[1] <= 9 &&
                    field[i[0]][i[1]].equals(".")) {
                field[i[0]][i[1]] = "#"; // если координаты лежат внутри
                //поля и в них не стреляли, то меняем их
            }
        }

        field[line][column] = "x"; // после того, как обработали это
        //поле, заменяем его на потопленное

        for (int[] i : commands) {
            if (0 <= i[0] && i[0] <= 9 && 0 <= i[1] && i[1] <= 9 && field[i[0]][i[1]].equals("X")) {
                sink(i[0], i[1]); // и ищем следующее, прилежащее к
                //нашему полю и так же обрабатываем его
            }
        }
        // таким образом мы рекурсивно обойдем все прилежащие поля, к
        //полю, которое подбили и прилежащие к ним.
    }
}

