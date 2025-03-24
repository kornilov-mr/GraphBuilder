import antlr4.parseUserInput
import kotlin.test.Test
import kotlin.test.assertEquals

class GraphParsingTests {
    @Test
    fun withoutListsVerticesTest(){
        val expected = "A --> B\nB --> C\nC --> A\n"
        val input = "A -> B\n" +
                "B -> C\n" +
                "C -> A"
        val graph = parseUserInput(input)
        assertEquals(graph.toListOfEdges(), expected)
    }
    @Test
    fun loopGraphTest(){
        val expected = "A --> A\nB --> B\n"
        val input = "A -> A\n" +
                "B -> B"
        val graph = parseUserInput(input)
        assertEquals(graph.toListOfEdges(), expected)
    }
    @Test
    fun listOfEdgesTest(){
        val expected = "A --> A\nA --> B\nA --> C\nB --> A\nB --> C\nC --> A\n"
        val input = "A -> [A,B,C]\n" +
                "B -> [A,C]\n" +
                "C -> [A]"
        val graph = parseUserInput(input)
        assertEquals(graph.toListOfEdges(), expected)
    }
    @Test
    fun differentFormatNotFailTest(){
        val input = "A -> [ A,  B,C  ]\n\n" +
                "B -> [    A ,C ]\n" +
                "C -> [A  ]\n"
        parseUserInput(input)
    }
}