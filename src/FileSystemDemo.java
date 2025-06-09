// ===== Main Demo =====
public class FileSystemDemo {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.add(new File("readme.txt", 10));
        root.add(new File("logo.png", 200));

        Directory docs = new Directory("docs");
        docs.add(new File("manual.pdf", 100));
        docs.add(new File("guide.docx", 80));
        root.add(docs);

        // Visitor: Struktur anzeigen
        StructurePrinter printer = new StructurePrinter();
        root.accept(printer);

        // Visitor: Größe berechnen
        SizeCalculator calculator = new SizeCalculator();
        root.accept(calculator);
        System.out.println("Total size: " + calculator.getTotalSize() + "KB");

        // Iterator: Alle Elemente im root-Verzeichnis
        System.out.println("\nDirect children of root:");
        for (FileSystemComponent c : root) {
            System.out.println("- " + c.getName());
        }
    }
}
