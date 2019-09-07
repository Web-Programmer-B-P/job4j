package ru.job4j.departament;

import java.util.ArrayList;
import java.util.List;

/**
 * Class SortDepartament
 *
 * @author Petr B.
 * @since 06.09.2019, 11:05
 */
public class SortDepartament {
    /**
     * Метод формирования группы по имени группы.
     * @param name критерий по которому формируется группа.
     * @param array массив который содержит строки в которые входят имена.
     * @return сфомированная группа.
     */
    public String[] formedGroup(String[] name, String[] array) {
        List<String> result = new ArrayList<>();
        boolean switcher = true;
        int index = 0;
        String[] sortName = this.checkGroup(name);
        int stopLoop = sortName.length - 1;
        while (switcher) {
            result.add(sortName[index]);
            for (String el : array) {
                String sub = el.substring(0, sortName[index].length());
                if (sub.equals(sortName[index]) && !result.contains(el)) {
                    result.add(el);
                }
            }
            index++;
            if (index > stopLoop) {
                switcher = false;
            }
        }
        return result.toArray(new String[0]);
    }

    /**
     * Метод проверка группы на недостающие элементы.
     * @param array массив который сортируем.
     * @return array на выходе отсортированный.
     */
    public String[] checkGroup(String[] array) {
        for (int outer = 1; outer < array.length; outer++) {
            for (int inner = outer + 1; inner < array.length; inner++) {
                String first = array[outer];
                String second = array[inner];
                if (first.length() > second.length()) {
                    array[outer] = second;
                    array[inner] = first;
                } else if (first.length() == second.length()) {
                    if (first.charAt(first.length() - 1) > second.charAt(second.length() - 1)) {
                        array[outer] = second;
                        array[inner] = first;
                    }
                }
            }
        }
        return array;
    }

    /**
     * Метод сортирует массив в порядке возрастания.
     * @param array
     * @return
     */
    public String[] sortAsc(String[] array) {
        for (int outer = 0; outer < array.length; outer++) {
            for (int inner = outer + 1; inner < array.length; inner++) {
                String first = array[outer];
                String second = array[inner];
                int check = this.compare(first, second, 0);
                if (check == 1) {
                    array[outer] = second;
                    array[inner] = first;
                }
            }
        }
        return array;
    }

    /**
     * Метод сортирует массив в порядке убывания.
     * @param array
     * @return
     */
    public String[] sortDesc(String[] array) {
        for (int outer = 0; outer < array.length; outer++) {
            for (int inner = outer + 1; inner < array.length; inner++) {
                String first = array[outer];
                String second = array[inner];
                int check = this.compare(first, second, 1);
                if (check == -1) {
                    array[outer] = second;
                    array[inner] = first;
                }
            }
        }
        return array;
    }

    /**
     * Метод сравнения строк.
     * @param left
     * @param right
     * @param sort параметр сравнения если 0 сравнивает по нарастанию 1 по убыванию
     * Например строки "K1" и "K1\SK1" с флагм <0> вернет -1 а с флагом <1> вернет 1
     * @return
     */
    public int compare(String left, String right, int sort) {
        int res = 0;
        int size = Math.min(left.length(), right.length());
        if (!left.equals(right)) {
            for (int index = 0; index < size; index++) {
                char l = left.charAt(index);
                char r = right.charAt(index);
                int re = l - r;
                if (index <= size - 1 && l < r) {
                    res = -1;
                    break;
                } else if (re == 0 && index == size - 1) {
                    if (sort == 0) {
                        res = left.length() > right.length() ? 1 : -1;
                    } else {
                        res = left.length() > right.length() ? -1 : 1;
                    }
                } else if (l > r) {
                    res = 1;
                    break;
                }
            }
        }
        return res;
    }
}
