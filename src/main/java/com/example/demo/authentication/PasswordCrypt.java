package com.example.demo.authentication;

import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.apache.tomcat.util.codec.binary.Base64;

public class PasswordCrypt {

//        public static void main( String [] args ) throws Exception {
//
//            PasswordCrypt crypto = new PasswordCrypt();
//
//            String plaintext = "This is a good secret.";
//            System.out.println( plaintext );
//
//            String ciphertext = crypto.encrypt( plaintext );
//            System.out.println( ciphertext );
//
//            String decrypted = crypto.decrypt( ciphertext );
//            System.out.println( decrypted );
//
//        }

        public String encrypt( String plaintext ) throws Exception {
            return encrypt( generateIV(), plaintext );
        }

        public String encrypt( byte [] iv, String plaintext ) throws Exception {

            byte [] decrypted = plaintext.getBytes();
            byte [] encrypted = encrypt( iv, decrypted );

            StringBuilder ciphertext = new StringBuilder();

            ciphertext.append( Base64.encodeBase64String( iv ) );
            ciphertext.append( ":" );
            ciphertext.append( Base64.encodeBase64String( encrypted ) );

            return ciphertext.toString();

        }

        public String decrypt( String ciphertext ) throws Exception {
            String [] parts = ciphertext.split( ":" );
            byte [] iv = Base64.decodeBase64( parts[0] );
            byte [] encrypted = Base64.decodeBase64( parts[1] );
            byte [] decrypted = decrypt( iv, encrypted );
            return new String( decrypted );
        }

        private Key key;

        public PasswordCrypt( Key key ) {
            this.key = key;
        }

        public PasswordCrypt() throws Exception {
            this( generateSymmetricKey() );
        }

        public Key getKey() {
            return key;
        }

        public void setKey( Key key ) {
            this.key = key;
        }

        public static byte [] generateIV() {
            SecureRandom random = new SecureRandom();
            byte [] iv = new byte [16];
            random.nextBytes( iv );
            return iv;
        }

        public static Key generateSymmetricKey() throws Exception {
            KeyGenerator generator = KeyGenerator.getInstance( "AES" );
            SecretKey key = generator.generateKey();
            return key;
        }

        public byte [] encrypt( byte [] iv, byte [] plaintext ) throws Exception {
            Cipher cipher = Cipher.getInstance( key.getAlgorithm() + "/CBC/PKCS5Padding" );
            cipher.init( Cipher.ENCRYPT_MODE, key, new IvParameterSpec( iv ) );
            return cipher.doFinal( plaintext );
        }

        public byte [] decrypt( byte [] iv, byte [] ciphertext ) throws Exception {
            Cipher cipher = Cipher.getInstance( key.getAlgorithm() + "/CBC/PKCS5Padding" );
            cipher.init( Cipher.DECRYPT_MODE, key, new IvParameterSpec( iv ) );
            return cipher.doFinal( ciphertext );
        }
}

