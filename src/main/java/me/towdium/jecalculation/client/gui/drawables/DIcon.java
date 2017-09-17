package me.towdium.jecalculation.client.gui.drawables;

import mcp.MethodsReturnNonnullByDefault;
import me.towdium.jecalculation.client.gui.JecGui;
import me.towdium.jecalculation.client.gui.Resource;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Author: towdium
 * Date:   17-8-18.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DIcon extends DTooltip {
    public int xPos, yPos, xSize, ySize;
    public Resource normal, focused;

    public DIcon(int xPos, int yPos, int xSize, int ySize, Resource normal, Resource focused) {
        this(xPos, yPos, xSize, ySize, normal, focused, null);
    }

    public DIcon(int xPos, int yPos, int xSize, int ySize,
                 Resource normal, Resource focused, @Nullable String name) {
        super(name);
        this.xPos = xPos;
        this.yPos = yPos;
        this.xSize = xSize;
        this.ySize = ySize;
        this.normal = normal;
        this.focused = focused;
    }

    @Override
    public void onDraw(JecGui gui, int xMouse, int yMouse) {
        super.onDraw(gui, xMouse, yMouse);
        gui.drawRectangle(xPos, yPos, xSize, ySize, JecGui.COLOR_GREY);
        Resource r = mouseIn(xMouse, yMouse) ? focused : normal;
        gui.drawResource(r, (xSize - r.getXSize()) / 2 + xPos, (ySize - r.getYSize()) / 2 + yPos);
    }

    @Override
    boolean mouseIn(int xMouse, int yMouse) {
        return JecGui.mouseIn(xPos + (xSize - normal.getXSize()) / 2,
                yPos + (ySize - normal.getYSize()) / 2, normal.getXSize(), normal.getYSize(), xMouse, yMouse);
    }
}