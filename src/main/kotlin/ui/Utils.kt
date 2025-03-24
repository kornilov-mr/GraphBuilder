package ui

import java.awt.Image
import java.awt.image.BufferedImage


fun toBufferedImage(img: Image): BufferedImage {
    if (img is BufferedImage) {
        return img
    }
    val bImage = BufferedImage(
        img.getWidth(null), img.getHeight(null),
        BufferedImage.TYPE_INT_ARGB
    )
    val bGr = bImage.createGraphics()
    bGr.drawImage(img, 0, 0, null)
    bGr.dispose()

    return bImage
}