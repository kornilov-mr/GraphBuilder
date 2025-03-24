import UML.DiagramFactory
import UML.UmlOrientation
import antlr4.parseUserInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UmlStringCreationTests {
    @Test
    fun umlStringCreationTest1() {
        val expected = "@startuml\n" +
                "skinparam useBetaStyle true\n" +
                "A -> B\n" +
                "B -> C\n" +
                "C -> A\n" +
                "@enduml"
        val input = "A -> B\n" +
                "B -> C\n" +
                "C -> A"
        val graph = parseUserInput(input)
        val factory = DiagramFactory(UmlOrientation.RL)
        assertEquals(expected,factory.createUmlString(graph))
    }
    @Test
    fun umlStringCreationTest2(){
        val expected = "@startuml\n" +
                "skinparam useBetaStyle true\n" +
                "A -> A\n" +
                "B -> B\n" +
                "@enduml"
        val input = "A -> A\n" +
                "B -> B"
        val graph = parseUserInput(input)
        val factory = DiagramFactory(UmlOrientation.RL)
        assertEquals(expected,factory.createUmlString(graph))
    }
    @Test
    fun umlStringCreationTest3(){
        val expected = "@startuml\n" +
                "skinparam useBetaStyle true\n" +
                "A -> A\n" +
                "A -> B\n" +
                "A -> C\n" +
                "B -> A\n" +
                "B -> C\n" +
                "C -> A\n" +
                "@enduml"
        val input = "A -> [A,B,C]\n" +
                "B -> [A,C]\n" +
                "C -> [A]"
        val graph = parseUserInput(input)
        val factory = DiagramFactory(UmlOrientation.RL)
        assertEquals(expected,factory.createUmlString(graph))
    }
}