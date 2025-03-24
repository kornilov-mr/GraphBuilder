package ui.display

import UML.DiagramFactory
import UML.UmlOrientation
import antlr4.parseUserInput
import graph.Graph
import java.awt.Image

/**
 * subscriber, which should fire on text change,
 * creates graph from user input, making graph image with plantUML
 */
class OnTextChangedCallback(private val mainDisplayField: MainDisplayField) : OnTextChanged{

    override fun onTextChanged(newText: String) {
        val diagramFactory = DiagramFactory(UmlOrientation.BT)
        val graph: Graph = parseUserInput(newText)
        val image: Image = diagramFactory.createImageFromGraph(graph)

        mainDisplayField.changeImage(image)
    }
}