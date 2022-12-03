public class FileData {
    private String name;
    private byte size;
    private String path;

    public FileData(String name, byte size, String path) {
        setName(name);
        setSize(size);
        setPath(path);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String toString() {
        return "name: " + getName() +
                " size: " + getSize() +
                " path: " + getPath();
    }
}
