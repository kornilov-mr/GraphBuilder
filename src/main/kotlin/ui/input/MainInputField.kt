package ui.input

import java.awt.TextArea

/**
 * UI component for user graph input area
 */
class MainInputField : TextArea() {
    val textChangesListener = TextChangesListener(this)

    init {
        addTextListener(textChangesListener)
    }

    fun changeText(newText: String) {
        firePropertyChange("text", text, newText)
        text = newText
    }
}