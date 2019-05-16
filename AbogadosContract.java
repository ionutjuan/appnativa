package net.iescm.abogadosapp.data;

import android.provider.BaseColumns;

/**
 * Esquema de la base de datos para abogados
 * Created by JoseMaria on 01/09/2016.
 */
public class AbogadosContract {

    public static abstract class AbogadoEntry implements BaseColumns {
        public static final String TABLE_NAME ="abogado";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SPECIALTY = "specialty";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String AVATAR_URI = "avatarUri";
        public static final String BIO = "bio";
    }

}
