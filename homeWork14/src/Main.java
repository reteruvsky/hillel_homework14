import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileData firstData = new FileData("FileOne.txt", (byte) 111, "/path/to/file");
        FileData secondData = new FileData("FileTwo.txt", (byte) 84, "/path/to/file");
        FileData thirdData = new FileData("FileThree.txt", (byte) 23, "/path/to/fileNext");
        FileData fourthData = new FileData("FileFour.txt", (byte) 121, "/path/to/fileNext");

        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add(firstData.getPath(), firstData);
        fileNavigator.add(secondData.getPath(), secondData);
        fileNavigator.add(thirdData.getPath(), thirdData);
        fileNavigator.add(fourthData.getPath(), fourthData);


        List<FileData> firstList = fileNavigator.find(firstData.getPath());
        for (FileData arr : firstList) {
            System.out.println(arr);
        }
        System.out.println();
        List<FileData> secondList = fileNavigator.find(fourthData.getPath());
        for (FileData arr : secondList) {
            System.out.println(arr);
        }

        System.out.println();

        List<FileData> thirdList = fileNavigator.filterBySize((byte) 100);
        for (FileData arr : thirdList) {
            System.out.println(arr);
        }

        System.out.println();

        List<FileData> fourthList = fileNavigator.sortBySize();
        for (FileData arr : fourthList) {
            System.out.println(arr);
        }

        System.out.println();

        fileNavigator.remove(firstData.getPath());
        for (Map.Entry<String, List<FileData>> arr : fileNavigator.getFilesHashmap().entrySet()) {
            System.out.println(arr.getValue());
        }
    }

}
