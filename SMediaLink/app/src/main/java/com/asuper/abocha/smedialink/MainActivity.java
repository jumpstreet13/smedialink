package com.asuper.abocha.smedialink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

    private void updateUI() {
        HomeForElements homeForElements = HomeForElements.get(getApplicationContext());
        List<Element> elements = homeForElements.getElements();
        elementAdapter = new ElementAdapter(elements);
        recyclerView.setAdapter(elementAdapter);
    }

    private class ElementHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public ButtonWithProgress btn;
        public ImageButton imageButton;
        public int number;


        public ElementHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewListElements);
            textView.setOnClickListener(this);
            btn = (ButtonWithProgress) itemView.findViewById(R.id.buttonListElements);
            btn.setOnClickListener(this);
            imageButton = (ImageButton) itemView.findViewById(R.id.imageViewListElements);
            itemView.setOnClickListener(this);
        }

        public void bindELement(Element element) {
            textView.setText(String.valueOf(element.getNumber()));
            number = element.getNumber();
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonListElements:
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("number", number);
                    startActivity(intent);
                    break;

                case R.id.imageViewListElements:
                    Intent intent1 = new Intent(MainActivity.this, DetailActivity.class);
                    intent1.putExtra("number", number);
                    startActivity(intent1);
                    break;
            }

        }
    }

    private class ElementAdapter extends RecyclerView.Adapter<ElementHolder> {

        private List<Element> elements;

        public ElementAdapter(List<Element> elements) {
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
            holder.bindELement(element);

        }


        @Override
        public int getItemCount() {
            return elements.size();
        }
    }
}
