package be.plutus.common.crypto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Crypto{

    public static String createSalt(){
        return new BigInteger( 130, new SecureRandom() ).toString( 20 );
    }

    public static String createHash( String text, String salt ){
        if( text == null )
            return null;

        MessageDigest digest = null;

        try{
            digest = MessageDigest.getInstance( "SHA-512" );
            digest.reset();
        }catch( NoSuchAlgorithmException ignored ){
        }

        digest.update( text.getBytes() );

        if( salt != null )
            digest.update( salt.getBytes() );

        return ( new BigInteger( 1, digest.digest() ).toString( 40 ) );
    }

}
