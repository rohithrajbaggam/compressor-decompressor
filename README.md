# compressor-decompressor
# Minor Project

## Compressor and Decompressor

→ This is used for data compression

### Data Compression

→ It is used for data reduction (compress or unzip) in the number of bits and need to represent the data.

→ While compressing the data if we loss the data it is known as loose conversion. We should always improve for loose compression.

**→ Advantages of compression**

- Storage will be less
- It speeds up the file transfer
- decrease cost for storage hardware and network bandwidth

→ Data should be same as before

## Data DeCompression

→ process of restoring the compressed data to the original data.

### Gz archive file

→Gz algorithm is used for compressing a file

→ These files are created by using these standard algorithm.



## Technologies used for this project

```python
Java
Java Swing
JFrame
```

- [Java.io](http://Java.io).* this package is used for taking file input and output
- Java Swing is part of JFC (Java Foundation Class)
    - This is used to build light weight and platform independent window based application.
    - This provides various components like buttons, labels, etc to build GUI.
- In Java Swing we use JFrame to represent main window
- JFile Chooser is used to open the file chooser window to select the file inside PC file system.
-

```python
Required to learn
implements
override 
@ (decorators)
revise oops
```

## File input Stream and File output Stream

## File input Stream

→ This class contains input bites from a file.

→ Used for reading byte oriented data

## File output Stream

→ Write the data inside a file.

→This data will be in the form raw bytes.

→ it helps to write the raw bytes inside the file. and also used for storing data to a files

## Gzip input and output Stream

### Gzip Output Stream

- this class is used for writing compressed data into gzip file.
    - This takes a normal file and converts into Gzip files.
- File will be taken using file input stream and compressed into raw data and raw data will be written into output Gzip file.

### Gzip Input Stream

- decompress the file which are compressed with Gzip compression Algorithm
- We can use normal file output stream because as it was decompressed into original file format.

# Algorithm of compression and decompression

**Compression Algorithm**

```java
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
```

**Decompression Algorithm**

```java
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class decompressor {

    public static void method(File file) throws  IOException {
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/DecompressedFile");

        byte[] buffer = new byte[1024];
        int len;

        while((len=gzip.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws  IOException {
        File path = new File("/Users/rohithrajbaggam/desktop/decompress/CompressedFile.gzip");
        method(path);
    }

}
```

## Implementation of Action Listener

- **Interface action listener** → receives action & even only whenever a user requested for a certain action.
- Allows us to access properties of action & event.
