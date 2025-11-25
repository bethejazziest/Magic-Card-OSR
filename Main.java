import net.sourceforge.tess4j.*;
import java.awt.Rectangle;
import java.io.*;

public class Main {

    /* Adjust these relative paths when running locally! */
    private static final String TESSDATA_PATH = "resources";
    private static final String IMAGE_FOLDER = "cards";
    private static final String OUTPUT_FOLDER = "out";

    public static void main(String[] args) {
        try {
            Tesseract reader = new Tesseract();
            reader.setDatapath(TESSDATA_PATH);

            File folder = new File(IMAGE_FOLDER);
            File outFolder = new File(OUTPUT_FOLDER);

            if (!outFolder.exists()) {
                outFolder.mkdirs();
            }

            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));

            if (files != null) {
                for (File imageFile : files) {
                    try {
                        reader.setLanguage("title");
                        Rectangle titleRect = new Rectangle(55, 55, 400, 35);
                        String title = reader.doOCR(imageFile, titleRect);

                        reader.setLanguage("body");
                        Rectangle bodyRect = new Rectangle(50, 600, 565, 260);
                        String body = reader.doOCR(imageFile, bodyRect);

                        String content = title + "\n-----------------------------\n" + body;

                        File outFile = new File(
                            OUTPUT_FOLDER,
                            imageFile.getName().replace(".jpg", ".txt")
                        );

                        try (FileWriter writer = new FileWriter(outFile)) {
                            writer.write(content);
                        }

                    } catch (TesseractException e) {
                        System.out.println("ERROR, skipping");
                    }
                }
            } else {
                System.out.println("ERROR, skipping");
            }

        } catch (Exception e) {
            System.out.println("ERROR, skipping");
        }
    }
}