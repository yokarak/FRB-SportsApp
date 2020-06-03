package com.example.eksamensprojekt.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.example.eksamensprojekt.data.model.Besked;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import static com.example.eksamensprojekt.utils.Konstante.chats;

public class BeskedRepository {


    public MutableLiveData<Besked> sendNyBesked(Besked nybesked) { // ved at have nybesked af Besked som Parameter kan vi modtage den samme besked igennem Viewmodel fra BeskedActivty
        final MutableLiveData<Besked> nyBeskedMutableLiveData = new MutableLiveData<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(); // her skabes forbindelsen til databasen i Firebase

        HashMap<String, Object> hashMap = new HashMap<>(); // her initializes Hashmap, ved at fortælle den at den skal have en String som værende indexet og et object som værende værdien af det specifikke index

        hashMap.put("afsender", nybesked.getAfsender()); //det gør det muligt at gemme afsenders ide med en forbindelse til indexet som fortæller at det ide tilhøre afsenderen
        hashMap.put("modtager", nybesked.getModtager());
        hashMap.put("besked", nybesked.getBesked());

        databaseReference.child(chats).push().setValue(hashMap); //ved "databaseReference.child(chats)" fortæller vi databasen at lokalitionen for vores Hashwap er under referencen "chats"

        return nyBeskedMutableLiveData;
    }


}