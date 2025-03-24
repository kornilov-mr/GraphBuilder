package ui.input

import java.io.File
import javax.swing.JComboBox

/**
 * UI component, which represents combobox with pre-defined examples
 * After selecting option calls to MainInputField to change text
 */
class ExampleComboBox(private val mainInputField: MainInputField) : JComboBox<String>() {

    private val option:MutableList<File> = mutableListOf()

    init {
        for(example in Examples.entries){
            option.add(example.file)
            addItem(example.name)
        }
        addActionListener {
            val selectedFile = option[selectedIndex]
            mainInputField.changeText(selectedFile.readText())
        }
    }
}