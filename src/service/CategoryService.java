package service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CategoryService {
    private static final String FILE_NAME = "data/categories.txt";

    public static List<String> getAllCategories() {
        List<String> lines = FileHandler.readLinesFromFile(FILE_NAME);
        Set<String> unique = new LinkedHashSet<>();
        for (String line : lines) {
            String trimmed = line.trim();
            if (!trimmed.isEmpty()) {
                unique.add(trimmed);
            }
        }
        return new ArrayList<>(unique);
    }

    public static boolean addCategory(String category) {
        String trimmed = category.trim();
        if (trimmed.isEmpty()) {
            return false;
        }
        List<String> categories = getAllCategories();
        for (String existing : categories) {
            if (existing.equalsIgnoreCase(trimmed)) {
                return false;
            }
        }
        FileHandler.writeLineToFile(FILE_NAME, trimmed);
        return true;
    }
}
