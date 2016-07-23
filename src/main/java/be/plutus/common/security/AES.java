package be.plutus.common.security;

import be.plutus.core.config.Config;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public class AES{

    private static SecretKeySpec secretKey;

    static{
        AES.setKey( Config.SECRET_KEY );
    }

    private static void setKey( String key ){
        MessageDigest mDigest;
        try{
            byte[] keyBytes = key.getBytes( "UTF-8" );
            mDigest = MessageDigest.getInstance( "SHA-1" );
            keyBytes = mDigest.digest( keyBytes );
            keyBytes = Arrays.copyOf( keyBytes, 16 );
            secretKey = new SecretKeySpec( keyBytes, "AES" );
        }catch( Exception ignored ){
        }
    }

    public static String encrypt( String toEncrypt ){
        try{
            Cipher cipher = Cipher.getInstance( "AES/ECB/PKCS5Padding" );
            cipher.init( Cipher.ENCRYPT_MODE, secretKey );
            return Base64.encodeBase64String( cipher.doFinal( toEncrypt.getBytes( "UTF-8" ) ) );
        }catch( Exception ignored ){
            return null;
        }
    }

    public static String decrypt( String toDecrypt ){
        try{
            Cipher cipher = Cipher.getInstance( "AES/ECB/PKCS5PADDING" );
            cipher.init( Cipher.DECRYPT_MODE, secretKey );
            return new String( cipher.doFinal( Base64.decodeBase64( toDecrypt ) ) );
        }catch( Exception ignored ){
            return null;
        }
    }
}
