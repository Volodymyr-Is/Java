import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static int PAGE_SIZE = 20;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String filePath = scanner.nextLine();

//        task1
        displayFile(filePath);

//        task1
        displayFilePaged(filePath);

//        task3
        System.out.println("Enter word to find: ");
        String searchWord = scanner.nextLine();
        countWordOccurrences(filePath, searchWord);

//        task4
        countCharacters(filePath);

//        task5
        System.out.println("Enter word to change: ");
        String replaceWord = scanner.nextLine();
        replaceWordInFile(filePath, searchWord, replaceWord);

//        task6
        mergeFiles(scanner);

//        task7
        System.out.println("Enter list of words to censor (use ',' as delimiter): ");
        String[] bannedWords = scanner.nextLine().split(",");
        censorWords(filePath, bannedWords);
    }

    public static void displayFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayFilePaged(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Scanner scanner = new Scanner(System.in);
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
                if (count % PAGE_SIZE == 0) {
                    System.out.println("Click Enter to continue...");
                    scanner.nextLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void countWordOccurrences(String filePath, String word) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));){
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
            }
            reader.close();
            System.out.println("Word \"" + word + "\" occures " + count + " times.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void countCharacters(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));){
            int letters = 0, digits = 0, delimiters = 0;
            int ch;
            while ((ch = reader.read()) != -1) {
                if (Character.isLetter(ch)) {
                    letters++;
                } else if (Character.isDigit(ch)) {
                    digits++;
                } else if (",.!?;:'\"(){}[]".indexOf(ch) >= 0) {
                    delimiters++;
                }
            }
            reader.close();
            System.out.println("Words: " + letters + ", Digits: " + digits + ", delimiters: " + delimiters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void replaceWordInFile(String filePath, String searchWord, String replaceWord) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                int occurrences = line.split("\\b" + searchWord + "\\b", -1).length - 1;
                count += occurrences;
                lines.add(line.replaceAll("\\b" + searchWord + "\\b", replaceWord));
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();
            System.out.println("Change completed " + count + " times.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mergeFiles(Scanner scanner) {
        System.out.println("Enter 3 files path to marge: ");
        String file1 = scanner.nextLine();
        String file2 = scanner.nextLine();
        String file3 = scanner.nextLine();
        System.out.println("Enter result file path: ");
        String outputFile = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            copyFileContent(writer, file1);
            copyFileContent(writer, file2);
            copyFileContent(writer, file3);
            writer.close();

            long bytes = Files.size(Paths.get(outputFile));
            System.out.println("Moved " + bytes + " bites.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFileContent(BufferedWriter writer, String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void censorWords(String filePath, String[] bannedWords) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            List<String> lines = new ArrayList<>();
            Map<String, Integer> wordCount = new HashMap<>();
            for (String banned : bannedWords) {
                wordCount.put(banned, 0);
            }
            String line;
            while ((line = reader.readLine()) != null) {
                for (String banned : bannedWords) {
                    int occurrences = line.split("\\b" + banned + "\\b", -1).length - 1;
                    wordCount.put(banned, wordCount.get(banned) + occurrences);
                    line = line.replaceAll("\\b" + banned + "\\b", "[CENSORED]");
                }
                lines.add(line);
            }
            reader.close();
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
                writer.close();
                System.out.println("Deleted words:");
                for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}