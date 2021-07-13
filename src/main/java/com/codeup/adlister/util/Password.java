package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    //static methods and properties goes here
    private static final int ROUNDS = 12; // ROUNDS = num of times we mix up the passwords

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS)); //pass in password; lets use create a password
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
