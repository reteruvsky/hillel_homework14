import java.util.*;

public class FileNavigator {
    private HashMap<String, List<FileData>> filesHashmap = new HashMap<>();

    public HashMap<String, List<FileData>> getFilesHashmap() {
        return filesHashmap;
    }

    public void add(String path, FileData file) {
        if (!path.equals(file.getPath())) {
            System.out.println("Ошибка! Неверный путь файла.");
        } else {
            if (filesHashmap.containsKey(path)) {
                filesHashmap.get(path).add(file);
            } else {
                List<FileData> newList = new ArrayList<>();
                newList.add(file);
                filesHashmap.put(path, newList);
            }
        }
    }

    public List<FileData> find(String path) {
        return new ArrayList<>(filesHashmap.get(path));
    }

    public List<FileData> filterBySize(byte size) {
        List<FileData> newList = new ArrayList<>();

        for (Map.Entry<String, List<FileData>> arr : filesHashmap.entrySet()) {
            for (int i = 0; i < arr.getValue().size(); i++) {
                if (arr.getValue().get(i).getSize() <= size) {
                    newList.add(arr.getValue().get(i));
                }
            }
        }

        return newList;
    }

    public void remove(String path) {
        for (Map.Entry<String, List<FileData>> arr : filesHashmap.entrySet()) {
            if (arr.getKey().equals(path)) {
                filesHashmap.remove(arr.getKey(), arr.getValue());
            }
        }
    }

    public List<FileData> sortBySize() {
        List<FileData> newList = new ArrayList<>();

        for (Map.Entry<String, List<FileData>> arr : filesHashmap.entrySet()) {
            newList.addAll(arr.getValue());
        }

        for (int i = 1; i < newList.size(); i++) {

            for (int j = i; j > 0; j--) {
                if (newList.get(j - 1).getSize() < newList.get(i).getSize()) {
                    FileData fileData = newList.get(j - 1);
                    newList.set(j - 1, newList.get(i));
                    newList.set(i, fileData);
                }
            }
        }

        return newList;
    }
}
