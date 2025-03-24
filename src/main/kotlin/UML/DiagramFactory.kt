package UML

import graph.Graph
import net.sourceforge.plantuml.SourceStringReader
import java.awt.Image
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import javax.imageio.ImageIO

/**
 * Class, Factory for better Uml input string formating
 * @property umlOrientation defines
 * right uml orientation in createUmlString function
 */
class DiagramFactory(private val umlOrientation: UmlOrientation) {
    fun createUmlString(graph: Graph): String {
        return "@startuml\n" +
                "skinparam useBetaStyle true\n" +
                graph.toListOfEdges() +
        "@enduml"
    }

    /**
     * function, which creates image of the graph in right format
     * @param graph graph to format
     * @return image of the graph
     */
    fun createImageFromGraph(graph: Graph): Image {
        val uml = createUmlString(graph)
        println(uml)
        val byteArrayOutputStream = ByteArrayOutputStream()
        val reader = SourceStringReader(uml)
        reader.outputImage(byteArrayOutputStream)
        val imageBytes = byteArrayOutputStream.toByteArray()
        val image = ImageIO.read(ByteArrayInputStream(imageBytes))
        return image
    }

}