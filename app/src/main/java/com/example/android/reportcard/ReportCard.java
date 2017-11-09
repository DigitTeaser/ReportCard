package com.example.android.reportcard;

import android.content.Context;
import android.widget.Toast;

/**
 * {@link ReportCard} represents a subject category word and the corresponding grade.
 */
public class ReportCard {
    /**
     * Default subject category
     */
    private String mCategory;

    /**
     * The corresponding grade of the category
     */
    private String mGrade;

    @Override
    public String toString() {
        return "Your " + mCategory + " subject grade is " + mGrade + " .";
    }

    /**
     * Create a new ReportCard object.
     *
     * @param context  is the application/activity context pass in the class
     * @param category is the subject category
     * @param grade    is the corresponding grade, only accept A or B or C or D or E or F
     */
    public ReportCard(Context context, String category, String grade) {
        mCategory = category;
        // See whether or not the grade input is within the [ABCDEF] scope.
        if (grade.matches("[ABCDEF]")) {
            mGrade = grade;
        } else {
            mGrade = context.getString(R.string.grade_error);
            // Toast a message display there are some data errors about grades
            Toast.makeText(context, context.getString(R.string.grades_data_errors), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Get the default subject category.
     */
    public String getCategory() {
        return mCategory;
    }

    /**
     * Get the corresponding grade of the category.
     */
    public String getGrade() {
        return mGrade;
    }

    /**
     * Set the default subject category.
     */
    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    /**
     * Set the corresponding grade of the category.
     */
    public void setmGrade(String mGrade) {
        this.mGrade = mGrade;
    }
}
