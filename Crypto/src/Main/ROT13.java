package Main;

public class ROT13 {
    Character cs;
    Character cf;
    private Integer shift;
    
    public ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
        this.shift = Math.abs(Character.compare(cs, cf));
    }
    
    public ROT13() {
    }

//    ROT13 superSecure = new ROT13('a', 'm');
    
    
    public String crypt(String text) throws UnsupportedOperationException {
        return Cipherizer(shift, text);
    }

// deciphering
    
    /* plaintext2 = "";
        for (i = 0; i < ciphertext.length; i++) {
            if (re.test(ciphertext.charAt(i)))
                plaintext2 += String.fromCharCode((ciphertext.charCodeAt(i) - 97 + 26 - key) % 26 + 97);
            else plaintext += ciphertext.charAt(i);
        }
        return "";
    }*/
    
    public String encrypt(String text) {
        return crypt(text);
    }
    
    public String decrypt(String text) {
        crypt(text);
        return crypt(text);
    }
    
    public static String encrypter(Character cs, Character cf, String text) {
        return appendCipher(cs, cf, text, true);
    }
    
    protected static String appendCipher(Integer shift, String text) {
        return Cipherizer(shift, text);
    }
    
    private static String Cipherizer(Integer shift, String text) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z') {
                ciphertext.append((char) ((text.charAt(i) - 97 + shift) % 26 + 97));
            } else if (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z') {
                ciphertext.append((char) ((text.charAt(i) - 65 + shift) % 26 + 65));
            } else {
                ciphertext.append(text.charAt(i));
            }
        }
        //System.out.println(ciphertext.toString());
        return ciphertext.toString();
    }
    
    protected static String appendCipher(Character cs, Character cf, String text, Boolean notShifted) {
        Integer shift = Math.abs(Character.compare(cs, cf));
        if (!notShifted) {
            return Cipherizer(-shift, text);
        } else {
            return Cipherizer(shift, text);
        }
    }
    
    public static String rotate(String s, Character c) {
        String output = "";
        StringBuilder piggedString = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            while (piggedString.charAt(0) != c) {
                piggedString.append(s.charAt(i));
                piggedString.deleteCharAt(0);
                i++;
            }
            output = piggedString.toString();
        }
        return output;
    }
}