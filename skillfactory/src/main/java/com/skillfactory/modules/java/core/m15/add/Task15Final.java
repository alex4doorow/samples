package com.skillfactory.modules.java.core.m15.add;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task15Final {

//            0. Скопировать текст из задания в файл balance.txt в текущий рабочий каталог.
//
//            1. Прочесть файл balance.txt в Map<String, Integer>.
//
//            2. Отсортировать строки файла в убывающем порядке.
//
//            3. Добавить в конце списка сумму всех трат: "Итого: n руб. (дата формирования файла в формате dd.MM.yyyy)", пример: "Итого: 100 руб. (01.03.2021)".
//
//            4. Сохранить файл как balance_total_ddMMyy.txt, где ddMMyy — это день, число и год слитно.
// balance.txt
//    Дима, 510
//    Катя, 2800
//    Никита, 1500
//    Эмилия, 5000
//    Ярослав, 3000
//    Андрей

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("ddMMyy");

    public static void main(String[] args) {

        final Path fileSource = Paths.get("balance.txt");
        final LocalDate now = LocalDate.now();
        final String formattedDate = SIMPLE_DATE_FORMAT.format(now.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli());
        final Path fileToWrite = Paths.get("balance_total_" + formattedDate + ".txt");

        try {
            // 1
            final List<String> strings = Files.readAllLines(fileSource, Charset.defaultCharset());
            final List<String[]> sortedNames = strings.stream()
                    .map(s -> {
                        final String[] split = s.split(",");
                        return new String[]{
                                split[0],
                                split.length > 1 ? split[1].trim() : ""
                        };
                    })
                    .sorted((o1, o2) -> Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]))
                    .toList();

            try (final BufferedWriter writer = Files.newBufferedWriter(fileToWrite, Charset.defaultCharset())) {
                for (String[] split : sortedNames) {
                    writer.write(String.format("%s\n", String.join(", ", split)));
                }
                writer.append(String.format(
                        "===\nИтого: %d руб. (%s)",
                        sortedNames.stream().mapToInt(split -> Integer.parseInt(split[1])).sum(),
                        now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
