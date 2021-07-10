package ir.mohammad.my;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ir.mohammad.my.Adapter.contactAdapter;
import ir.mohammad.my.model.Contact;

public class ContactFragment extends Fragment {
    private List<Contact>contact=new ArrayList<>();
    private contactAdapter contactAdapter;
    private RecyclerView recyclerViewcontact;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerViewcontact=(RecyclerView) view.findViewById(R.id.recycler_contact);
        contactAdapter=new contactAdapter(contact);
        recyclerViewcontact.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerViewcontact.setAdapter(contactAdapter);

        contact.add(new Contact("mohammad","https://setare.com/files/fa/news/1398/11/29/348852_755.jpg"));
        contact.add(new Contact("mohammad","https://setare.com/files/fa/news/1398/11/29/348854_531.jpg"));
        contact.add(new Contact("mohammad","https://setare.com/files/fa/news/1398/11/29/348858_646.jpg"));
        contact.add(new Contact("mohammad","https://setare.com/files/fa/news/1398/11/29/348860_907.jpg"));
        contact.add(new Contact("mohammad","https://setare.com/files/fa/news/1398/11/29/348864_315.jpg"));
        contact.add(new Contact("mohammad","https://setare.com/files/fa/news/1398/11/29/348866_391.jpg"));
        contact.add(new Contact("mohammad","https://setare.com/files/fa/news/1398/11/29/348870_352.jpg"));
        contact.add(new Contact("mohammad","https://setare.com/files/fa/news/1398/11/29/348856_401.jpg"));
        contact.add(new Contact("mohammad","https://cdn.nody.ir/files/2021/05/11/nody-%D8%B9%DA%A9%D8%B3-%D9%BE%D8%B1%D9%88%D9%81%D8%A7%DB%8C%D9%84-%D9%BE%D8%B3%D8%B1%D8%A7%D9%86%D9%87-%DA%A9%D9%84%D8%A7%D8%B3%DB%8C%DA%A9-1620734423.jpg"));

        return view;
    }
}