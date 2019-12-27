package utils;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

public final class FastWriter extends PrintWriter {

    public FastWriter(OutputStream out) {
        super(out);
    }

    public FastWriter(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void printAll(char separator, Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                print(separator);
            }
            print(objects[i]);
        }
    }
}
