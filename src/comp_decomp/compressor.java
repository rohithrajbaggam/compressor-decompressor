package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;


public class compressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/CompressedFile.gzip");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1) {
            /*
            fis.read() reads data up to the buffer.length bytes of fis.read() data from input stream into an array of bytes
             */
            gzip.write(buffer, 0, len);
            /*
            gzip 1st params we need to pass the data, where we stored data in bytes in buffer byte array
            gzip 2nd params is used for offset -> The start offset it tells where we need to start writing the data
            gzip 3rd params is for length, numbers of bytes to write
            2nd and 3rd are the starting and ending values to write the data
             */

        }
        gzip.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws  IOException {
        File path = new File("/Users/rohithrajbaggam/desktop/decompress");
        method(path);
    }
}
