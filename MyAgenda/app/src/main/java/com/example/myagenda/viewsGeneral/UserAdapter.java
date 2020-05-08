package com.example.myagenda.viewsGeneral;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myagenda.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolderUser> {

    private List<Users> items;

    public class ViewHolderUser extends RecyclerView.ViewHolder {

        //campos respectivos al CardView
        public TextView txt_name, txt_email, txt_phone;

        public ViewHolderUser(@NonNull View v) {
            super(v);
            txt_name = v.findViewById(R.id.txt_Name);
            txt_email = v.findViewById(R.id.txt_email);
            txt_phone = v.findViewById(R.id.txt_phone);
        }
    }

    public UserAdapter(List<Users> items){
        this.items = items;
    }

    //ViewGroup es una colección de recursos, son las secciones de los espacios disponibles que estan en el recycler view
    //Aquí

    @NonNull
    @Override
    public ViewHolderUser onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_list, viewGroup, false);
        return new ViewHolderUser(v);
    }

    // recibe dos parametros, nuestro item card o template y la posición donde quiero que se pinte
    @Override
    public void onBindViewHolder(@NonNull ViewHolderUser viewHolder, int i) {
        viewHolder.txt_name.setText(items.get(i).get_name());
        viewHolder.txt_email.setText(items.get(i).get_email());
        viewHolder.txt_phone.setText(items.get(i).get_phone());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
