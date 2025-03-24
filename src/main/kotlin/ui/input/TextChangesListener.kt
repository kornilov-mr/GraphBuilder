package ui.input

import ui.display.OnTextChanged
import java.awt.event.TextEvent
import java.awt.event.TextListener

/**
 * Listener for text changed, which fires OnTextChanged subscribers
 */
class TextChangesListener(private val mainInputField: MainInputField) : TextListener {
    private val onTextChanged: MutableList<OnTextChanged> = mutableListOf()
    override fun textValueChanged(e: TextEvent?) {
        for(sub:OnTextChanged in onTextChanged) {
            sub.onTextChanged(mainInputField.text)
        }
    }
    fun addTextChangedListener(listener: OnTextChanged) {
        onTextChanged.add(listener)
    }
}