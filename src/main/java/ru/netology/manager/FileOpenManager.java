package ru.netology.manager;

import java.util.*;

public class FileOpenManager {

    private HashMap<String, String> fileManager = new HashMap<>();

    public void addExtension(String extension) {
        fileManager.put(extension, null);
    }

    public HashMap<String, String> getAllBinding() {
        return fileManager;
    }

    public void addProgramName(String extension, String programName) {
        fileManager.replace(extension, programName);
    }

    public String findProgByExt(String extension) {
        return fileManager.get(extension);
    }

    public void delBinding(String extension) {
        if (fileManager.containsKey(extension)) {
            fileManager.replace(extension, null);
        }
    }

    public List findAllExt() {
        List<String> keys = new ArrayList<>();
        for (Map.Entry entry : fileManager.entrySet())
            if (entry.getValue() != null) {
                keys.add((String) entry.getKey());
            }
        Collections.sort(keys);
        return keys;
    }

    public List findAllProg() {
        List<String> program = new ArrayList<>();
        for (String prog : fileManager.values())
            if (prog != null) {
                program.add(prog);
            }
        Collections.sort(program);
        return program;
    }
}
