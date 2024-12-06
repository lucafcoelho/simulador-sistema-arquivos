import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Main (Classe Principal)
public class Main {
    private Directory root;
    private Journal journal;

    public Main() {
        this.root = new Directory("root");
        this.journal = new Journal();
    }

    public void createFile(String dirName, String fileName) {
        Directory dir = findDirectory(dirName);
        if (dir != null) {
            dir.addFile(new FileEntry(fileName));
            journal.logOperation("Created file: " + fileName + " in " + dirName);
        } else {
            System.out.println("Directory not found: " + dirName);
        }
    }

    public void createDirectory(String parentDirName, String dirName) {
        Directory parentDir = findDirectory(parentDirName);
        if (parentDir != null) {
            parentDir.addSubDirectory(new Directory(dirName));
            journal.logOperation("Created directory: " + dirName + " in " + parentDirName);
        } else {
            System.out.println("Parent directory not found: " + parentDirName);
        }
    }

    public void listDirectory(String dirName) {
        Directory dir = findDirectory(dirName);
        if (dir != null) {
            System.out.println("Contents of " + dirName + ":");
            for (FileEntry file : dir.getFiles()) {
                System.out.println("File: " + file.getName());
            }
            for (Directory subDir : dir.getSubDirectories()) {
                System.out.println("Directory: " + subDir.getName());
            }
        } else {
            System.out.println("Directory not found: " + dirName);
        }
    }

    public void deleteFile(String dirName, String fileName) {
        Directory dir = findDirectory(dirName);
        if (dir != null) {
            dir.removeFile(fileName);
            journal.logOperation("Deleted file: " + fileName + " from " + dirName);
        } else {
            System.out.println("Directory not found: " + dirName);
        }
    }

    public void deleteDirectory(String parentDirName, String dirName) {
        Directory parentDir = findDirectory(parentDirName);
        if (parentDir != null) {
            parentDir.removeSubDirectory(dirName);
            journal.logOperation("Deleted directory: " + dirName + " from " + parentDirName);
        } else {
            System.out.println("Parent directory not found: " + parentDirName);
        }
    }

    private Directory findDirectory(String name) {
        if (name.equals("root")) {
            return root;
        }
        return searchDirectory(root, name);
    }

    private Directory searchDirectory(Directory current, String name) {
        if (current.getName().equals(name)) {
            return current;
        }
        for (Directory subDir : current.getSubDirectories()) {
            Directory result = searchDirectory(subDir, name);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public void showJournal() {
        journal.showLog();
    }

    public static void main(String[] args) {
        Main simulator = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to File System Simulator");
        while (true) {
            System.out.println("\n1. Create Directory");
            System.out.println("2. Create File");
            System.out.println("3. List Directory");
            System.out.println("4. Delete File");
            System.out.println("5. Delete Directory");
            System.out.println("6. Show Journal");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter parent directory: ");
                    String parentDir = scanner.nextLine();
                    System.out.print("Enter directory name: ");
                    String dirName = scanner.nextLine();
                    simulator.createDirectory(parentDir, dirName);
                    break;
                case 2:
                    System.out.print("Enter directory name: ");
                    String fileDir = scanner.nextLine();
                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();
                    simulator.createFile(fileDir, fileName);
                    break;
                case 3:
                    System.out.print("Enter directory name: ");
                    String listDir = scanner.nextLine();
                    simulator.listDirectory(listDir);
                    break;
                case 4:
                    System.out.print("Enter directory name: ");
                    String delFileDir = scanner.nextLine();
                    System.out.print("Enter file name: ");
                    String delFileName = scanner.nextLine();
                    simulator.deleteFile(delFileDir, delFileName);
                    break;
                case 5:
                    System.out.print("Enter parent directory name: ");
                    String delParentDir = scanner.nextLine();
                    System.out.print("Enter directory name to delete: ");
                    String delDirName = scanner.nextLine();
                    simulator.deleteDirectory(delParentDir, delDirName);
                    break;
                case 6:
                    simulator.showJournal();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

// Classe Directory
class Directory {
    private String name;
    private List<FileEntry> files;
    private List<Directory> subDirectories;

    public Directory(String name) {
        this.name = name;
        this.files = new ArrayList<>();
        this.subDirectories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<FileEntry> getFiles() {
        return files;
    }

    public List<Directory> getSubDirectories() {
        return subDirectories;
    }

    public void addFile(FileEntry file) {
        files.add(file);
    }

    public void addSubDirectory(Directory directory) {
        subDirectories.add(directory);
    }

    public void removeFile(String fileName) {
        files.removeIf(file -> file.getName().equals(fileName));
    }

    public void removeSubDirectory(String dirName) {
        subDirectories.removeIf(dir -> dir.getName().equals(dirName));
    }
}

// Classe FileEntry
class FileEntry {
    private String name;

    public FileEntry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Classe Journal
class Journal {
    private List<String> log;

    public Journal() {
        this.log = new ArrayList<>();
    }

    public void logOperation(String operation) {
        log.add(operation);
    }

    public void showLog() {
        System.out.println("Journal Log:");
        for (String entry : log) {
            System.out.println(entry);
        }
    }
}
