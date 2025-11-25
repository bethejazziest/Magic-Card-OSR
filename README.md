# Magic-Card-OSR
A Java OCR tool that extracts text from card images using Tess4J (Tesseract). Processes title and body regions with predefined bounding boxes, converts multiple images automatically, and outputs structured text files. Includes configurable paths, language data, and 
batch-processing support.

This project is a Java OCR tool that automatically extracts text from card images using Tess4J, a Java wrapper for the Tesseract OCR engine. The application reads all .jpg files in the local cards directory, processes each image by applying OCR to predefined rectangular 
regions that correspond to the card’s title and body text, and writes the extracted content into matching .txt files inside the out directory. Tesseract language and training data are loaded from a relative resources folder, allowing the program to run on any machine 
without hard-coded paths. The tool supports batch processing of multiple images, creates the output folder automatically if it does not exist, and gracefully handles OCR failures or unreadable images. This project demonstrates practical use of OCR, file handling, 
rectangular region targeting, text extraction, and automated dataset processing in Java.
