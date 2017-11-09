package com.example.android.reportcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of ReportCard
        ArrayList<ReportCard> reportCards = new ArrayList<>();
        reportCards.add(new ReportCard(this,
                getString(R.string.category_english), getString(R.string.grade_a)));
        reportCards.add(new ReportCard(this,
                getString(R.string.category_mathematics), getString(R.string.grade_b)));
        reportCards.add(new ReportCard(this,
                getString(R.string.category_second_language), getString(R.string.grade_b)));
        reportCards.add(new ReportCard(this,
                getString(R.string.category_physics), getString(R.string.grade_c)));
        reportCards.add(new ReportCard(this,
                getString(R.string.category_chemistry), getString(R.string.grade_a)));
        reportCards.add(new ReportCard(this,
                getString(R.string.category_biology), getString(R.string.grade_d)));
        reportCards.add(new ReportCard(this,
                getString(R.string.category_art), getString(R.string.grade_a)));
        reportCards.add(new ReportCard(this,
                getString(R.string.category_physical_education), getString(R.string.grade_f)));

        // Overall grade to calculate.
        int overall_grade = 0;

        for (int index = 0; index < reportCards.size(); index++) {
            switch (reportCards.get(index).getGrade()) {
                case "A":
                    overall_grade += 5;
                    break;
                case "B":
                    overall_grade += 4;
                    break;
                case "C":
                    overall_grade += 3;
                    break;
                case "D":
                    overall_grade += 2;
                    break;
                case "E":
                    overall_grade += 1;
                    break;
                case "F":
                    break;
                default:
                    break;
            }
        }

        // Calculate overall grade and set to the TextView
        overall_grade = Math.round(overall_grade / reportCards.size());
        TextView textView = findViewById(R.id.overall_grade);
        switch (overall_grade) {
            case 5:
                textView.setText(getString(R.string.grade_a));
                break;
            case 4:
                textView.setText(getString(R.string.grade_b));
                break;
            case 3:
                textView.setText(getString(R.string.grade_c));
                break;
            case 2:
                textView.setText(getString(R.string.grade_d));
                break;
            case 1:
                textView.setText(getString(R.string.grade_e));
                break;
            case 0:
                textView.setText(getString(R.string.grade_f));
                break;
            default:
                break;
        }

        // Create an {@link ReportCardAdapter}, whose data source is a list of {@link ReportCard}s.
        // The adapter knows how to create list items for each item in the list.
        ReportCardAdapter adapter = new ReportCardAdapter(this, reportCards);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }
}
