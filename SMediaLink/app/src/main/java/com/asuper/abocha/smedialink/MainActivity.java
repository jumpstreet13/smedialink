package com.asuper.abocha.smedialink;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final String NUMBER = "number";
    private RecyclerView recyclerView;
    private ElementAdapter elementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        updateUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
            imageButton.setOnClickListener(this);
        }

        public void bindELement(Element element) {
            textView.setText(String.valueOf(element.getNumber()));
            number = element.getNumber();
            btn.setRatio(element.getGreen());
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonListElements:
                    sendIntent(number);
                    break;

                case R.id.imageViewListElements:
                    sendIntent(number);
                    break;

                case R.id.textViewListElements:
                    sendIntent(number);
                    break;
            }

        }
    }

    private void sendIntent(int number) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(NUMBER, number);
        startActivity(intent);
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
