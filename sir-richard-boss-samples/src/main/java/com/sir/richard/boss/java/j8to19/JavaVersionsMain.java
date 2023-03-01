package com.sir.richard.boss.java.j8to19;

public class JavaVersionsMain {
    // https://habr.com/ru/post/488144/
    // Тагир Валеев — Java 17 для тех, кто в танке https://www.youtube.com/watch?v=1WaQoBiIoK4&t=2456s
    private static String TEXT = """
                        
            Java 8
            Java 8 была массовым выпуском, и вы можете найти список всех функций на веб-сайте Oracle. Здесь я хотел бы упомянуть два основных набора функций:

            Особенности языка: лямбды и т.д.
            До Java 8 всякий раз, когда вы хотели создать экземпляр, например, нового Runnable, вы должны были написать анонимный внутренний класс, например, так:

             Runnable runnable = new Runnable(){
                   @Override
                   public void run(){
                     System.out.println("Hello world !");
                   }
                 };

            С лямбдами тот же код выглядит так:
            Runnable runnable = () -> System.out.println("Hello world two!");

            Вы также получили ссылки на методы, повторяющиеся аннотации, методы по умолчанию для интерфейсов и некоторые другие языковые функции.

            Коллекции и потоки
            В Java 8 вы также получили операции в функциональном стиле для коллекций, также известные как Stream API. Быстрый пример:

            List<String> list = Arrays.asList("franz", "ferdinand", "fiel", "vom", "pferd");

            До Java 8, вам нужно было написать циклы for, чтобы что-то сделать с этим списком.
            С помощью API Streams вы можете сделать следующее:

            list.stream()
                .filter(name -> name.startsWith("f"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

            Java 9
            Java 9 также была довольно большой версией, с несколькими дополнениями:

            Коллекции
            Коллекции получили несколько новых вспомогательных методов для простого создания списков, наборов и карт.

            List<String> list = List.of("one", "two", "three");
            Set<String> set = Set.of("one", "two", "three");
            Map<String, String> map = Map.of("foo", "one", "bar", "two");

            Streams
            Потоки получили несколько дополнений, в виде методов takeWhile, dropWhile и iterate.

            Stream<String> stream = Stream.iterate("", s -> s + "s")
              .takeWhile(s -> s.length() < 10);

            Optionals
            Optionals получили метод ifPresentOrElse, которого крайне не хватало.

            user.ifPresentOrElse(this::displayAccount, this::displayLogin);

            Интерфейсы
            Интерфейсы получили private методы:

            public interface MyInterface {
                private static void myPrivateMethod(){
                    System.out.println("Yay, I am private!");
                }
            }

            Другие возможности языка
            И пара других улучшений, таких как улучшенный оператор try-with-resources или расширения diamond оператора.
            JShell
            Наконец, в Java появилась оболочка, в которой вы можете попробовать простые команды и получить немедленные результаты.

            % jshell
            |  Welcome to JShell -- Version 9
            |  For an introduction type: /help intro
            jshell> int x = 10
            x ==> 10

            HTTPClient
            Java 9 принес первоначальную предварительную версию нового HttpClient. До этого встроенная поддержка Http в Java была довольно низкоуровневой, и вам приходилось использовать сторонние библиотеки, такие как Apache HttpClient или OkHttp (кстати, отличные библиотеки).
            В Java 9 у Java появился собственный современный клиент — хотя он находится в режиме превью, что означает, что он может быть изменен в более поздних версиях Java.

            Проект Jigsaw: модули Java и файлы Jar с несколькими выпусками
            Java 9 получила Jigsaw Module System, которая чем-то напоминает старую добрую спецификацию OSGI. Целью данного руководства не является подробное описание Jigsaw — посмотрите предыдущие ссылки, чтобы узнать больше.

            Файлы Multi-Release .jar позволили создать один файл .jar, содержащий разные классы для разных версий JVM. Таким образом, ваша программа может вести себя по-разному / иметь разные классы, используемые при запуске на Java 8 и на Java 10, например.

            Java 10
            В Java 10 было несколько изменений, таких как сборка мусора и т.д. Но единственное реальное изменение, которое вы, 
            как разработчик, вероятно, заметите, — это введение ключевого слова var, также называемого выводом типа локальной переменной.

            Вывод типа локальной переменной: ключевое слово var

            // Pre-Java 10
            String myName = "Marco";
            // With Java 10
            var myName = "Marco"
            Чувствуете себя как в Javascript-е, не так ли? Однако Java все еще строго типизирован и var применяется только к переменным внутри методов (спасибо, dpash, за то, что снова указал на это).

            Java 11
            Java 11 также была несколько меньшей версией с точки зрения разработчика.

            Строки и файлы
            Строки и файлы получили несколько новых методов (не все перечислены здесь):

            "Marco".isBlank();
            "Mar\\nco".lines();
            "Marco  ".strip();
            Path path = Files.writeString(Files.createTempFile("helloworld", ".txt"), "Hi, my name is!");
            String s = Files.readString(path);

            Запустить исходные файлы
            Начиная с Java 10, вы можете запускать исходные файлы Java без предварительной компиляции. Шаг к написанию сценариев.

            ubuntu@DESKTOP-168M0IF:~$ java MyScript.java

            Вывод типа локальной переменной (var) для лямбда-параметров
            В заголовке все сказано:
            
            (var firstName, var lastName) -> firstName + lastName

            HttpClient
            HttpClient из Java 9, но уже в окончательной, а не превью версии.

            Другие вкусности
            Flight Recorder (Регистратор полетов), сборщик мусора No-Op, Nashorn-Javascript-Engine объявлен deprecated (устаревшим) и т.д.

            Java 12
            В Java 12 появилось несколько новых функций и исправлений, но здесь стоит упомянуть только поддержку Unicode 11 и превью нового выражения switch, о котором вы узнаете в следующем разделе.

            Java 13
            Вы можете найти полный список возможностей здесь, но, по сути, вы получаете поддержку Unicode 12.1, а также две новые или улучшенные превью функции (могут быть изменены в будущем):

            Switch выражение (Preview — предварительная версия)
            Выражения переключателя теперь могут возвращать значение. И вы можете использовать лямбда-стиль синтаксиса для своих выражений, без проблем с ошибками:

            Старые операторы switch выглядели так:
            switch(status) {
              case SUBSCRIBER:
                // code block
                break;
              case FREE_TRIAL:
                // code block
                break;
              default:
                // code block
            }

            В то время как в Java 13 операторы switch могут выглядеть так:
            
            boolean result = switch (status) {
                case SUBSCRIBER -> true;
                case FREE_TRIAL -> false;
                default -> throw new IllegalArgumentException("something is murky!");
            };

            Многострочные строки (превью)
            Наконец-то вы можете сделать это на Java:

            String htmlBeforeJava13 = "<html>\\n" +
                          "    <body>\\n" +
                          "        <p>Hello, world</p>\\n" +
                          "    </body>\\n" +
                          "</html>\\n";
            String htmlWithJava13 = ""\"
                          <html>
                              <body>
                                  <p>Hello, world</p>
                              </body>
                          </html>
                          ""\";

            Java 14 и позже
            """;

    public static void main(String[] args) {
        System.out.println(TEXT);

    }
}
