package com.example.groceriesappilaria;

import android.util.Patterns;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;
import java.util.regex.Pattern;

public class ControlSaisie {
    private TextInputLayout userName, email, passwd1, passwd2;

    private boolean validLogin() {
        String strLOGIN = userName.getEditText().getText().toString().trim().toLowerCase(Locale.ROOT);
        if (strLOGIN.isEmpty()) {
            userName.setError("A valid name is required");
            userName.requestFocus();
            return false;
        } else {
            userName.setError(null);
            return true;
        }
    }

    private boolean validEmail() {
        String strEMAIL = email.getEditText().getText().toString().trim().toLowerCase(Locale.ROOT);
        if (strEMAIL.isEmpty()) {
            email.setError("A valid name is required");
            email.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(strEMAIL).matches()) {
            //contrôle du Pattern class Patterns Email_Address valide
            email.setError(strEMAIL + "A valid e-mail is required (example@example.com)");
            //email.requestFocus();
            return false;
        } else {
            //email.setErrorEnables(false); <- due modi equivalenti
            email.setError(null);
            return true;
        }
    }

    private boolean validPASSWORD() {
        String strPASSWORD = passwd1.getEditText().getText().toString().trim();
        if (strPASSWORD.isEmpty()) {
            passwd1.setError("Enter a password, please.");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(strPASSWORD).matches()) {
            passwd1.setError("Please enter a valid password (Example1!)");
            return false;
        } else {
            passwd1.setError(null);
            passwd2.setError(null);
            return true;
        }

    }

    private boolean validPASSWORD2() {
        String strPASSWORD = passwd1.getEditText().getText().toString().trim();
        String strPASSWORD2 = passwd2.getEditText().getText().toString().trim();
        if (strPASSWORD2.isEmpty()) {
            passwd2.setError("Please, confirm your password.");
            return false;
        } else if (!strPASSWORD.equals(strPASSWORD2)) {
            passwd1.setError("Your passwords don't match");
            return false;
        } else {
            passwd2.setError(null);
            return true;
        }
    }

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" + //début de la ligne
            "(?=.*[0-9])" + //au moins un chiffre
            "(?=.*[a-z])" + //au moins une minuscule
            "(?=.*[A-Z])" + //au moins un majuscule
            "(?=.*[@#!$%^&+=])" +   //au moins un caractère spéciale listé
            "(?=\\S+$)" +   //pas d'espace vide
            ".{6,20}" + //minimum 6 caractères et Maxi 20 caractères
            "$");   //fin de ligne
}
