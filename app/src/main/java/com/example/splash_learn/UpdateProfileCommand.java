package com.example.splash_learn;
import com.google.firebase.database.DatabaseReference;

interface Command {
    void execute();
}

public class UpdateProfileCommand implements Command {
    private DatabaseReference reference;
    private UserProfile userProfile;

    public UpdateProfileCommand(DatabaseReference reference, UserProfile userProfile) {
        this.reference = reference;
        this.userProfile = userProfile;
    }

    @Override
    public void execute() {
        reference.updateChildren(userProfile.toMap());
    }
}