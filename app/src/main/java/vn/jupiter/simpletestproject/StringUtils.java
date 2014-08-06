package vn.jupiter.simpletestproject;

import android.text.Editable;

/**
 * @author Jupiter (vu.cao.duy@gmail.com) on 6/4/14.
 */
public class StringUtils {
    /**
     * Check if a text is empty or not.
     *
     * @param editableText
     * @return
     */
    public static boolean isNotEmpty(Editable editableText) {
        return (editableText != null) && isNotEmpty(editableText.toString());
    }

    /**
     * Check if a text is empty or not.
     *
     * @param editableText
     * @return
     */
    public static boolean isNotEmpty(CharSequence editableText) {
        return (editableText != null) && (editableText.toString() != null)
                && (!editableText.toString().trim().equals(""));
    }



}
