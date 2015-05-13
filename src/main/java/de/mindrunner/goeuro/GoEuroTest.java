package de.mindrunner.goeuro;

import de.mindrunner.goeuro.func.GoEuroClient;
import de.mindrunner.goeuro.func.CsvWriter;
import de.mindrunner.goeuro.model.Position;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Lukas Elsner <open@mindrunner.de>
 * @version 1.0
 * @since 13-05-2015
 * <p>
 * Entry point class of the program
 */
public class GoEuroTest {
    private static GoEuroClient goEuroClient = new GoEuroClient();
    private static final String HEADER = "_type,_id,name,type,latitude,longitude";
    /**
     * The main entry point of the program. Requests the GoEuro REST Api and writes CSV data to either a file or stdout.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        String filenanme = "output.csv";

        if (args.length < 1) {
            System.out.println("Please pass a search query as parameter");
            System.exit(-1);
        }

        if (args.length > 1) {
            filenanme = args[1];
        }

        Position[] positions = goEuroClient.getPositions(args[0]);

        CsvWriter writer = null;
        try {
            if (filenanme.equals("stdout"))
                writer = new CsvWriter(System.out, HEADER);
            else
                writer = new CsvWriter(new FileOutputStream(filenanme), HEADER);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot write to File");
            System.exit(-2);
        }

        try {
            writer.writeHeader();
            writer.writeArray(positions);
            writer.writeEnd();
        } catch (IOException e) {
            System.out.println("I/O Error while writing file");
        }
    }
}
