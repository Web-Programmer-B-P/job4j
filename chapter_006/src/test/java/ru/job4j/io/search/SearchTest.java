package ru.job4j.io.search;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Class SearchTest
 *
 *                      Tree root directory
 *                               root
 *                                 |
 *                  |--------------|--------------|
 *                dir1            dir2           dir3
 *              first.txt       exam.cvs          |
 *              kilo.xml        linked.pom       red
 *              list.css        newFile.txt      name.txt
 *              sub_dir/
 *                  |
 *              example.com
 *              file.txt
 *              ===============================================
 *              total: 4 txt, 1 xml, 1 css, 1 com, 1 cvs, 1 pom
 * @author Petr B.
 * @since 27.10.2019, 15:25
 */
public class SearchTest {
    private String rootPath;
    private List<File> files;
    private List<String> ext = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        File tmp = new File(System.getProperty("java.io.tmpdir"));
        rootPath = tmp + "/root";
        ext.add("txt");
        ext.add("pom");
        ext.add("xml");
        ext.add("css");
        ext.add("com");
        ext.add("cvs");
    }

    /*@Test
    public void whenWolkInTree() throws IOException {
        Search call = new Search();
        files = call.file(rootPath, ext);
        assertThat(files.size(), is(9));
    }

    @Test
    public void whenShowFile() throws IOException {
        Search call = new Search();
        files = call.file(rootPath, ext);
        assertThat(files.get(0).getName(), is("linked.pom"));
    }*/
}