package net.rolodophone.goo

import org.openrndr.Extension
import org.openrndr.Program
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.Drawer
import org.openrndr.math.Matrix44

internal lateinit var pg: Program

internal object Colors {
	val BACKGROUND = ColorRGBa(64.0, 64.0, 64.0)
	val BACKGROUND_DARK = ColorRGBa(32.0, 32.0, 32.0)
	val ACCENT = ColorRGBa(32.0, 64.0, 160.0)
}

internal object Dim {
	const val CORNER_RADIUS = 1.0
}

class Goo(private val root: UIElement): Extension {

	override var enabled = true

	override fun afterDraw(drawer: Drawer, program: Program) {
		pg = program

		pg.drawer.model = Matrix44.IDENTITY
		pg.drawer.view = Matrix44.IDENTITY

		root.update()
		root.draw()
	}
}