package com.asuper.abocha.smedialink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ElementAdapter elementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        updateUI();
    }

    private void updateUI(){
        HomeForElements homeForElements = HomeForElements.get(this);
        List<Element> elements = homeForElements.getElements();
        elementAdapter = new ElementAdapter(elements);
        recyclerView.setAdapter(elementAdapter);
    }

    private class ElementHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public Button btn;
        public ImageView imageView;


        public ElementHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textViewListElements);
            btn = (Button) itemView.findViewById(R.id.buttonListElements);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewListElements);
        }
    }

    private class ElementAdapter extends RecyclerView.Adapter<ElementHolder>{

        private List<Element> elements;

        public ElementAdapter(List<Element> elements){
            this.elements = elements;
        }

        @Override
        public ElementHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
            View view = layoutInflater.inflate(R.layout.listelements, parent, false);
            return new ElementHolder(view);
        }

        @Override
        public void onBindViewHolder(ElementHolder holder, int position) {
            Element element = elements.get(position);
            holder.textView.setText(String.valueOf(element.getNumber()));

        }

        @Override
        public int getItemCount() {
            return elements.size();
        }
    }
}
