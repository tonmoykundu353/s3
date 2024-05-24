package com.example.splash_learn.SuperSingleton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SuperSingleton {
    private static DatabaseReference superSingletonClassobj;

    private SuperSingleton(){

    }
    public static DatabaseReference getSuperSingleton(){
        if(superSingletonClassobj==null){
            superSingletonClassobj= FirebaseDatabase.getInstance().getReference();
        }
        return superSingletonClassobj;
    }



}
