import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Directory implements FileSystemComponent, Iterable<FileSystemComponent> {
    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemComponent child : children) {
            child.accept(visitor);
        }
    }

    @Override
    public Iterator<FileSystemComponent> iterator() {
        return children.iterator();  // Simple iterator
    }

    @Override
    public String getName() {
        return name;
    }
}