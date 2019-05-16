package net.iescm.abogadosapp.data;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

import net.iescm.abogadosapp.data.AbogadosContract.AbogadoEntry;

/**
 * Entidad "abogado"
 * Created by JoseMaria on 01/09/2016.
 */
public class Abogado {
    private String id;
    private String name;
    private String specialty;
    private String phoneNumber;
    private String bio;
    private String avatarUri;

    public Abogado(String name,
                   String specialty, String phoneNumber,
                   String bio, String avatarUri) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.avatarUri = avatarUri;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AbogadoEntry.ID, id);
        values.put(AbogadoEntry.NAME, name);
        values.put(AbogadoEntry.SPECIALTY, specialty);
        values.put(AbogadoEntry.PHONE_NUMBER, phoneNumber);
        values.put(AbogadoEntry.BIO, bio);
        values.put(AbogadoEntry.AVATAR_URI, avatarUri);
        return values;
    }

    public Abogado(Cursor cursor) {
        id = cursor.getString(cursor.getColumnIndex(AbogadoEntry.ID));
        name = cursor.getString(cursor.getColumnIndex(AbogadoEntry.NAME));
        specialty = cursor.getString(cursor.getColumnIndex(AbogadoEntry.SPECIALTY));
        phoneNumber = cursor.getString(cursor.getColumnIndex(AbogadoEntry.PHONE_NUMBER));
        bio = cursor.getString(cursor.getColumnIndex(AbogadoEntry.BIO));
        avatarUri = cursor.getString(cursor.getColumnIndex(AbogadoEntry.AVATAR_URI));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }
}
