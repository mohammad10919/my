package ir.mohammad.my.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.mohammad.my.R;
import ir.mohammad.my.model.Contact;

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.contactViewHolder>{
    List<Contact> contact;

    public contactAdapter(List<Contact> contact) {
        this.contact = contact;
    }

    @NonNull
    @Override
    public contactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contactlayout,parent,false);
        return new contactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull contactViewHolder holder, int position) {
        holder.name.setText(contact.get(position).getName());
        Picasso.get().load(contact.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return contact.size();
    }

    public class contactViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;
        public contactViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.text_contact);
            image=(ImageView)itemView.findViewById(R.id.image_contact);
        }
    }
}
