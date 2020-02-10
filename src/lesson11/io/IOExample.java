package lesson11.io;


import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Vector;

public class IOExample {
    // IO | NIO

    public static void main(String[] args) {
//        File file = new File("file.txt");
        // IO API
//        работают с байтами
//        InputStream
//        OutputStream

//        работают с char
//        Reader
//        Writer

        /*try {
            writeToFile("src/file.txt", true, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readByte(new File("src/file.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
//        try {
//            readByteArray(new File("src/file.txt"), Charset.forName("UTF-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File[] files = {
                new File("src/file.txt"),
                new File("src/file1.txt")
        };

        try {
            readFromSeveralFiles(files, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName,
                                   boolean append, Charset charset)
            throws IOException {
//        FileOutputStream - запись в файл
        try (FileOutputStream outputStream =
                     new FileOutputStream(fileName, append))
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++){
                sb.append("line ").append(i).append("\n");
            }

            byte[] bytes = sb.toString().getBytes(charset);
            outputStream.write(bytes);
        }
    }

    public static long readByte(File file) throws IOException{

//        FileInputStream
        long sum = 0;
        try (FileInputStream inputStream = new FileInputStream(file)){
            System.out.println(inputStream.available());

            while (inputStream.available() > 0){
                int data = inputStream.read();
                sum += data;
                System.out.println((char) data);
            }
            return sum;
        }
    }

    public static void readByteArray(File file, Charset charset) throws IOException{
//        FileInputStream
//        ByteArrayOutputStream

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        )
        {


            byte[] buf = new byte[1024];

            int len;

            while ((len = fileInputStream.read(buf)) > 0) {
                System.out.println(Arrays.toString(buf));
                byteArrayOutputStream.write(buf, 0, len);
            }

            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
            System.out.println(new String(byteArrayOutputStream.toByteArray(), charset));
        }

    }

    public void writeWithBuffer(File file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)
        ){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++){
                sb.append("line ").append(i).append("\n");
            }

            byte[] buffer = sb.toString().getBytes();
            outputStream.write(buffer, 0, buffer.length);
        }
    }

    public static void readFromSeveralFiles(File[] files, Charset charset) throws IOException{
        try (FileInputStream inputStream1 = new FileInputStream(files[0]);
             FileInputStream inputStream2 = new FileInputStream(files[1]);
             ByteArrayOutputStream bout = new ByteArrayOutputStream())
        {

            /*InputStream stream1 = new FileInputStream("file1.txt");
            InputStream stream2 = new FileInputStream("file2.txt");
            InputStream stream3 = new FileInputStream("file3.txt");
            InputStream stream4 = new FileInputStream("file4.txt");

            Vector<InputStream> sequence = new Vector<>();
            sequence.add(stream1);
            sequence.add(stream2);
            sequence.add(stream3);
            sequence.add(stream4);

            SequenceInputStream sequenceStream = new SequenceInputStream(sequence.elements());*/

            SequenceInputStream sequenceInputStream =
                    new SequenceInputStream(inputStream1, inputStream2);

            byte[] buf  = new byte[1024];
            int len;

            while ((len = sequenceInputStream.read(buf)) > 0) {
                bout.write(buf, 0, len);
            }

            System.out.println(new String(bout.toByteArray(), charset));

        }
    }

    public static String readChar(InputStream in, Charset charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(in);

        StringBuilder sb = new StringBuilder();

        char[] buf = new char[20];
        int len;
        while ((len = reader.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }

        return sb.toString();
    }













}
