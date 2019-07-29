package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class EndsWith {

    /**
     * Проверяет. что слово начинается с префикса.
     * @param post префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        // проверить. что массив data с конца имеет ли он элементы одинаковые с value
        for (int index = 1; index <= pst.length; index++){
            if (wrd[wrd.length - index] != pst[pst.length - index]){
                result = false;
                break;
            }
        }
        return result;
    }
}