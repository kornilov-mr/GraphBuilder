package ui.display

import ui.toBufferedImage
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Image
import java.awt.event.*
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JPanel
import javax.swing.SwingUtilities

/**
 * Class, ui component, which is responsible for displaying the specified graph
 * With zooming and mouse scrolling
 * @property originalImage image without scaling or moving to different position
 * @property scale double value for scaling image size
 * @property imageX X-position of the left top corner of displayed image
 * @property imageY Y-position of the left top corner of displayed image
 * @property lastX last X-position of the mouse before dragging
 * @property lastY last Y-position of the mouse before dragging
 */
class MainDisplayField : JPanel(), MouseListener, MouseMotionListener, MouseWheelListener {
    private var originalImage: BufferedImage
    private var scale: Double = 1.0
    private var imageX = 0
    private var imageY = 0
    private var lastX = 0
    private var lastY = 0

    init {
        originalImage =  ImageIO.read(File("src/main/resources/emptyIcon.png"))
        addMouseListener(this)
        addMouseMotionListener(this)
        addMouseWheelListener(this)
    }

    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        val g2d = g as Graphics2D
        g2d.clearRect(0, 0, width, height)

        val scaledWidth = (originalImage.width * scale).toInt()
        val scaledHeight = (originalImage.height * scale).toInt()
        g2d.drawImage(
            originalImage,
            imageX, imageY, scaledWidth, scaledHeight, null
        )
    }

    override fun mouseClicked(e: MouseEvent?) {

    }

    override fun mousePressed(e: MouseEvent) {
        lastX = e.x
        lastY = e.y
    }

    override fun mouseReleased(e: MouseEvent?) {
    }

    override fun mouseEntered(e: MouseEvent?) {
    }

    override fun mouseExited(e: MouseEvent?) {
    }

    override fun mouseDragged(e: MouseEvent) {
        val deltaX = e.x - lastX
        val deltaY = e.y - lastY
        imageX += deltaX
        imageY += deltaY
        lastX = e.x
        lastY = e.y

        repaint()
    }

    override fun mouseMoved(e: MouseEvent?) {
    }

    override fun mouseWheelMoved(e: MouseWheelEvent) {
        val zoomFactor = if (e.wheelRotation < 0) 1.1 else 0.9

        scale *= zoomFactor
        scale = 0.1.coerceAtLeast(scale.coerceAtMost(5.0))

        imageX = ((imageX + e.x) - e.x * zoomFactor).toInt()
        imageY = ((imageY + e.y) - e.y * zoomFactor).toInt()

        repaint()
    }

    /**
     * Sets scale for image, so the image takes the most of the display place
     */
    private fun spreadImage(){
        SwingUtilities.invokeLater {
            scale = (height/originalImage.height).toDouble()
        }
    }

    /**
     * Function to change image, resets position to default
     * @param image image to change
     */
    fun changeImage(image: Image) {
        originalImage = toBufferedImage(image)
        spreadImage()
        imageX = 0
        imageY = 0
        lastX = 0
        lastY = 0
        repaint()
    }
}