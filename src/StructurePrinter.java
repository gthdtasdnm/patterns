class StructurePrinter implements FileSystemVisitor {
    private int indent = 0;

    @Override
    public void visit(File file) {
        printIndent();
        System.out.println("- " + file.getName() + " (" + file.getSize() + "KB)");
    }

    @Override
    public void visit(Directory directory) {
        printIndent();
        System.out.println("[" + directory.getName() + "]");
        indent++;
    }

    private void printIndent() {
        for (int i = 0; i < indent; i++) System.out.print("  ");
    }
}