package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileOpenManagerTest {
    FileOpenManager manager = new FileOpenManager();
    String html = "html";
    String pdf = "pdf";
    String avi = "avi";
    String jpg = "jpg";
    String png = "png";
    String fireFox = "FireFox";
    String adobeReader = "AdobeReader";
    String vlc = "VLC";
    String paint = "Paint";

    @BeforeEach
    void setUp() {
        manager.addExtension(html);
        manager.addExtension(pdf);
        manager.addExtension(avi);
        manager.addExtension(jpg);
        manager.addExtension(png);
        manager.addProgramName(html, fireFox);
        manager.addProgramName(avi, vlc);
    }

    @Test
    void findProgByExt() {
        String actual = manager.findProgByExt(avi);
        String expected = vlc;
        assertEquals(expected, actual);
    }

    @Test
    void delBinding() {
        manager.delBinding(html);
        System.out.println(manager.getAllBinding());
    }

    @Test
    void findAllExt() {
        List<String> actual = manager.findAllExt(manager.getAllBinding());
        List<String> expected = Arrays.asList("avi", "html");

        assertEquals(expected, actual);
    }

    @Test
    void findAllProg() {
        List<String> actual = manager.findAllProg(manager.getAllBinding());
        List<String> expected = Arrays.asList(fireFox, vlc);

        assertEquals(expected, actual);
    }
}
