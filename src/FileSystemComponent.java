// ===== Composite Pattern =====
interface FileSystemComponent {
    String getName();
    void accept(FileSystemVisitor visitor);
}