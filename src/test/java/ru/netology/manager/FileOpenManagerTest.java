package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FileOpenManagerTest {
    private FileOpenManager manager = new FileOpenManager();
    private String html = "html";
    private String pdf = "pdf";
    private String avi = "avi";
    private String jpg = "jpg";
    private String png = "png";
    private String fireFox = "FireFox";
    private String adobeReader = "AdobeReader";
    private String vlc = "VLC";
    private String paint = "Paint";

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
    void findProgNonByExt() {
        String actual = manager.findProgByExt("mkv");
        assertNull(actual);
    }

    @Test
    void delBinding() {
        manager.delBinding(html);
        List<String> actual = manager.findAllProg();
        List<String> expected = Arrays.asList("VLC");
        assertEquals(expected, actual);
    }

    @Test
    void delNonBinding() {
        manager.delBinding("mkv");
        List<String> actual = manager.findAllProg();
        List<String> expected = Arrays.asList(fireFox, vlc);
        assertEquals(expected, actual);
    }

    @Test
    void findAllExt() {
        List<String> actual = manager.findAllExt();
        List<String> expected = Arrays.asList("avi", "html");

        assertEquals(expected, actual);
    }

    @Test
    void findAllProg() {
        List<String> actual = manager.findAllProg();
        List<String> expected = Arrays.asList(fireFox, vlc);

        assertEquals(expected, actual);
    }
}
