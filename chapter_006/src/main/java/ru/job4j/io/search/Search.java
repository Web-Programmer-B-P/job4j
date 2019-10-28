package ru.job4j.io.search;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class Search
 *
 * @author Petr B.
 * @since 30.10.2019, 19:37
 */

/**
 * Class Search
 *
 * @author Petr B.
 * @since 27.10.2019, 15:08
 */
public class Search {
    public List<File> file(String pathSearch, List<String> exts) {
        List<File> res = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(new File(pathSearch));
        while (!data.isEmpty()) {
            File newPath = data.poll();
            if (newPath.isDirectory()) {
                for (String el : newPath.list()) {
                    File concat = new File(newPath + "/" + el);
                    data.offer(concat);
                }
            }
            if (newPath.isFile()) {
                if (checkExtInList(exts, findExt(newPath))) {
                    res.add(new File(newPath.getName()));
                }
            }
        }
        return res;
    }

    private String findExt(File file) {
        String ext = file.getName();
        return ext.substring(ext.indexOf(".") + 1);
    }

    private boolean checkExtInList(List<String> list, String ext) {
        return list.contains(ext);
    }
}
