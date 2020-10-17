package ua.kpi.comsys.iv7112;


import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    private String[] titles = {
            "Star Wars: Episode IV - A New Hope",
            "Star Wars: Episode V - The Empire Strikes Back",
            "Star Wars: Episode VI - Return of the Jedi",
            "Star Wars: Episode VII - The Force Awakens",
            "Star Wars: Episode I - The Phantom Menace",
            "Star Wars: Episode III - Revenge of the Sith",
            "Star Wars: Episode II - Attack of the Clones",
            "Star Trek",
            "Star Wars: Episode VIII - The Last Jedi",
            "Rogue One: A Star Wars Story"
    };

    private String[] years = {"1977", "1980", "1983", "", "1999", "2005", "2002", "2009", "2017", "2016"};

    private String[] type = {"movie"};
    int[] posters = {
            R.drawable.poster_01,
            R.drawable.poster_02,
            R.drawable.background,
            R.drawable.poster_04,
            R.drawable.poster_05,
            R.drawable.poster_06,
            R.drawable.poster_07,
            R.drawable.poster_08,
            R.drawable.background,
            R.drawable.poster_10};

    private FilmAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new FilmAdapter(this);
        setListAdapter(mAdapter);
    }

    private class FilmAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;

        FilmAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = mLayoutInflater.inflate(R.layout.activity_customlist, null);

            ImageView image = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            image.setImageResource(posters[position]);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.textViewTitle);
            titleTextView.setText(titles[position]);

            TextView dateTextView = (TextView) convertView.findViewById(R.id.textViewDate);
            dateTextView.setText(years[position]);

            TextView typeTextView = (TextView) convertView.findViewById(R.id.textViewType);
            typeTextView.setText(type[0]);

            return convertView;
        }

        String getString(int position) {
            return titles[position] + " (" + years[position] + ")" + " (" + type[0] + ")";
        }
    }
}