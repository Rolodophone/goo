package net.rolodophone.goo

import org.openrndr.color.ColorRGBa
import org.openrndr.shape.Rectangle
import org.openrndr.shape.contour

open class TabBox(override var bounds: Rectangle) : Clickable() {

	companion object {
		const val TAB_HEIGHT = 40.0
	}

	open var tabs: List<Tab> = listOf(Tab("Tab 1"), Tab("Tab 2"))

	var currentTabIndex = 0


	final override fun abstractUpdate() {
		tabs[currentTabIndex].elements.forEach { it.update() }
	}

	final override fun abstractDraw() {
		val tabBackground = contour {
			moveTo(bounds.x, bounds.y + TAB_HEIGHT)
			lineTo(bounds.x, bounds.y - Dim.CORNER_RADIUS)
			arcTo(Dim.CORNER_RADIUS, Dim.CORNER_RADIUS, 90.0, false, false, bounds.x + Dim.CORNER_RADIUS, bounds.y)
			lineTo(bounds.x + bounds.width - Dim.CORNER_RADIUS, bounds.y)
			arcTo(Dim.CORNER_RADIUS, Dim.CORNER_RADIUS, 90.0, false, false, bounds.x + bounds.width, bounds.y + Dim.CORNER_RADIUS)
			lineTo(bounds.x + bounds.width, bounds.y + TAB_HEIGHT)
			close()
		}

		pg.drawer.fill = Colors.BACKGROUND_DARK
		pg.drawer.stroke = ColorRGBa.TRANSPARENT
		pg.drawer.contour(tabBackground)

		for (i in 0..tabs.size) {

		}

		// draw children
		tabs[currentTabIndex].elements.forEach { it.draw() }
	}


	open class Tab(var label: String) {
		open var elements = listOf<UIElement>() //TODO add text to each tab
	}
}