package com.Hasher;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Hasher {
    //surrounding the whole method with an exception as easier than surround each with try catch.
    //takes in an input of the password a salt and a boolean expression to check if it verifying or creating a new hash.
    public String generateHash(String passWord, byte[] salt, boolean vHash)throws Exception{
        //if it wants to create a new hash.
        if(!vHash){
            //like a randomiser gets reandom values
            SecureRandom.getInstance("SHA1PRNG");
            //fills the salt byte array of length 100
            salt = SecureRandom.getSeed(99);
            //when you want to save the salt just use a encoder to encode the array into string using a base64 encoder
            //enter the code here, it can change on how everything else is written so i haven't entered it.
        }else {
            //I have all my outputs to string so the input must be converted into Base64
            salt = Base64.getDecoder().decode(salt);
        }
        /*
        Specifying the spec of my has to take in my password as an array.
        Take in the salt, iterate 1000000 times, and have key-length 1111.
        The more the iterations and the bigger the key-length the more secure it is for brute fore
        as the longer time it takes to has each password, this spec takes roughly 5-7 sec on a decent pc.
        If this action takes to long, just reduce the iterations and key length, but PBKDF2 is a slow hashing algorithm.
         */
        KeySpec spec = new PBEKeySpec(passWord.toCharArray(), salt, 1000000, 1111);
        //Get an instance of the hashing algorithm, i have gone for SHA512 but can be changed to PBKDF2WithHmacSHA216
        //for use with SHA-216
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        //hashing the password
        byte[] hash = f.generateSecret(spec).getEncoded();
        //encoding the password from Base64 to string
        passWord = Base64.getEncoder().encodeToString(hash);
        //returning the string value
        return passWord;
    }
}
