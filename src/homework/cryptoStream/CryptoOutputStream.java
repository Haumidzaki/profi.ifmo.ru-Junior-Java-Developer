package homework.cryptoStream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {

    private byte[] key;
    private int currentKeyPosition;

    public CryptoOutputStream(OutputStream out, byte[] key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {
        // шифрование
        super.write(b);
    }


    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        // шифрование
        super.write(b, off, len);
    }

}
