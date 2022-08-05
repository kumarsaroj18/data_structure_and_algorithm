package kumar.saroj.ch03;

public class CaesorCipher {

    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];
    public CaesorCipher(int rotation) {
        for (int k = 0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
    }

    public String encrypt(String msg) {
        return transform(msg, encoder);
    }

    public String decrypt (String secret) {
        return transform(secret, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();

        for (int i = 0; i < msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {
                int k = msg[i] - 'A';
                msg[i] = code[k];
            }
        }

        return new String(msg);
    }

    public static void main(String[] args) {
        CaesorCipher cc = new CaesorCipher(-1);
        System.out.println("Encryption code: "+ new String(cc.encoder));
        System.out.println("Decryption code: "+ new String(cc.decoder));

        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";

        String coded = cc.encrypt(message);
        System.out.println("Secret: " + coded);

        String answer = cc.decrypt(coded);
        System.out.println("Message: "+ answer);
    }
}
