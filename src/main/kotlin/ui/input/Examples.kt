package ui.input

import java.io.File

/**
 * Enum with file with example graphs
 * (Stored in enum for better use in ComboBox)
 */
enum class Examples(val file: File) {
    EXAMPLE1(File("src/main/resources/GraphExample1.txt")),
    EXAMPLE2(File("src/main/resources/GraphExample2.txt"));

}