package com.sir.richard.boss.generics;

import com.sir.richard.boss.model.animals.Animal;
import com.sir.richard.boss.model.animals.Cat;
import com.sir.richard.boss.model.animals.Mammal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainGenerics {
    // https://habr.com/ru/company/sberbank/blog/416413/
    public static void main(String[] args) {
/*
        The Get and Put Principle или PECS (Producer Extends Consumer Super)

        Если мы объявили wildcard с extends, то это producer. Он только «продюсирует», предоставляет элемент из контейнера,
            а сам ничего не принимает.
        Если же мы объявили wildcard с super — то это consumer. Он только принимает,
            а предоставить ничего не может.

        Особенность wildcard с верхней и нижней границей дает дополнительные фичи, связанные с безопасным использованием типов.
        Из одного типа переменных можно только читать, в другой — только вписывать (исключением является возможность
        записать null для extends и прочитать Object для super).
        Чтобы было легче запомнить, когда какой wildcard использовать, существует принцип
        PECS — Producer Extends Consumer Super.
*/

/*
        Если необходимо читать из контейнера, то используйте wildcard с верхней границей "? extends".
        Если необходимо писать в контейнер, то используйте wildcard с нижней границей "? super".
        Не используйте wildcard, если нужно производить и запись, и чтение.
*/
        List<Integer> ints1 = Arrays.asList(1, 2, 3, 4);
        List<? extends Number> nums1 = ints1; // producer
        //nums1.add(666); can't !!!!
        Number i1 = nums1.get(0); // can consumer
        System.out.println(i1);

        List<Number> nums2 = new ArrayList<>();
        List<? super Integer> ints2 = nums2; // consumer
        nums2.add(665);
        nums2.add(667);
        nums2.add(669);
        Number n1 = nums2.get(1); // producer
        System.out.println(n1);

        List<Cat> animalsSrc1 = Arrays.asList(new Cat("Richard"), new Cat("Rif"));
        List<Mammal> animalsDest1 = new ArrayList<>();
        copy(animalsDest1, animalsSrc1);
        System.out.println(animalsDest1);

/*
        Если необходимо читать из контейнера, то используйте wildcard с верхней границей "? extends".
        Если необходимо писать в контейнер, то используйте wildcard с нижней границей "? super".
        Не используйте wildcard, если нужно производить и запись, и чтение.
*/

        List<Mammal> animalsSrc2;
        List<Animal> animalsDest2 = new ArrayList<>();
        animalsSrc2 = Arrays.asList(new Cat("Eduard"), new Cat("Qupi"));
        copy(animalsDest2, animalsSrc2);
        System.out.println(animalsDest2);

        reverse(animalsDest2);
        System.out.println(animalsDest2);



    }

    /**
     * @param dest consumer - write
     * @param src  producer - read
     * @param <T>
     */
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        if (dest == null) {
            return;
        }
        dest.clear();
        // 1
        dest.addAll(src);

        // 2
/*
        for (int i = 0; i < src.size() - 1; i++) {
            dest.add(src.get(i));
        }
*/
        // 3
/*
        src.forEach(srcI -> {
            dest.add(srcI);
        });

*/
    }

    public static void reverseWithError(List<?> list) {
        List<Object> tmp = new ArrayList<Object>(list);
        for (int i = 0; i < list.size(); i++) {
            //list.set(i, tmp.get(list.size()-i-1)); // compile-time error
        }
    }

    // ? == ? extends Object
    // pattern Wildcard Capture: reverse ->  reverse(reverseLikeT)
    public static void reverse(List<?> list) {
        reverseLikeT(list);
    }


    public static <T> void reverseLikeT(List<T> list) {
        List<T> tmp = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1)); // no errors!
        }
    }

    static List<String> trash1() {
        List l = new ArrayList<Number>();
        l.add(1);
        List<String> ls = l; // (1)
        ls.add("");
        return ls;
    }

    static void trash2(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // (1)
        String s = stringLists[0].get(0); // (2)
    }

}
