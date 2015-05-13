package de.mindrunner.goeuro.func;

import java.io.*;

/**
 * @author Lukas Elsner <open@mindrunner.de>
 * @version 1.0
 * @since 13-05-2015
 * <p/>
 * Class for writing CSV data to outputstreams
 */
public class CsvWriter {
    /**
     * Header of the CSV data
     */
    private String header;
    /**
     * Buffered writer to use with output stream
     */
    private BufferedWriter writer;

    /**
     * Constructs a GoEuroCsvWriter with an outputstream
     *
     * @param outputStream The stream the data should be output to
     */
    public CsvWriter(OutputStream outputStream, String header) throws FileNotFoundException {
        this.header = header;
        writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    /**
     * Writes the header to the outputstream
     */
    public void writeHeader() throws IOException {
        writer.write(header);
        writer.newLine();
    }

    /**
     * Writes a line to the outputstream
     *
     * @param line The line to be written
     * @throws IOException
     */
    public void writeLine(String line) throws IOException {
        writer.write(line);
        writer.newLine();
    }

    /**
     * Flushes and closes the outputstresm
     *
     * @throws IOException
     */
    public void writeEnd() throws IOException {
        writer.flush();
        writer.close();
    }

    /**
     * Writes the returnvalue of object's toString() method to output stream
     *
     * @param object The object to be written
     * @throws IOException
     */
    public void writeData(Object object) throws IOException {
        writeLine(object.toString());
    }

    /**
     * Performs writeData on an Array of objects
     *
     * @param array The Array to be written
     * @throws IOException
     */
    public void writeArray(Object[] array) throws IOException {
        for (Object o : array) {
            writeData(o);
        }
    }
}
