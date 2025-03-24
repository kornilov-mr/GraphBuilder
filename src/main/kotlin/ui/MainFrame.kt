package ui

import ui.display.MainDisplayField
import ui.display.OnTextChangedCallback
import ui.input.ExampleComboBox
import ui.input.MainInputField
import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JPanel

/**
 * Main JFrame which is responsible for element positioning
 */
class MainFrame(title: String?) : JFrame(title) {
    init {
        val content = JPanel()
        content.layout = BorderLayout()

        val inputField = JPanel()

        val mainInputField = MainInputField()
        val mainDisplayField = MainDisplayField()

        val onTextChangedCallback = OnTextChangedCallback(mainDisplayField)
        mainInputField.textChangesListener.addTextChangedListener(onTextChangedCallback)

        val exampleComboBox = ExampleComboBox(mainInputField)


        inputField.add(mainInputField)
        inputField.add(exampleComboBox)

        content.add(mainDisplayField)
        content.add(inputField, BorderLayout.SOUTH)
        add(content)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(800, 800)
        isVisible = true
    }
}