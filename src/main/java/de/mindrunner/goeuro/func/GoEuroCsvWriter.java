package de.mindrunner.goeuro.func;

import de.mindrunner.goeuro.model.Position;

import java.io.*;

/**
 * Created by le on 5/13/15.
 */
public class GoEuroCsvWriter {
    private static final String HEADER = "_type,_id,name,type,latitude,longitude";
    private BufferedWriter writer;

    public GoEuroCsvWriter(OutputStream outputStream) throws FileNotFoundException {
        writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public void writeHeader() throws IOException {
        writer.write(HEADER);
        writer.newLine();
    }

    public void writeLine(String line) throws IOException {
        writer.write(line);
        writer.newLine();
    }

    public void writeEnd() throws IOException {
        writer.flush();
        writer.close();
    }

    public void writePosition(Position position) throws IOException {
        writeLine(position.toString());
    }

    public void writePositions(Position[] positions) throws IOException {
        for(Position position : positions) {
            writePosition(position);
        }
    }
}
