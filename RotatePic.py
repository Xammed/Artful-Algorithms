#! /usr/bin/env python3

# RotatePic.py - for each source pixel, figure out where it should go
#
# DFP, 29 Mar 2016

import math
from graphics import *

pic = Image(Point(0, 0), "duck150.gif")

# make a window the size of the image
win = GraphWin("Original Picture", pic.getWidth(), pic.getHeight())

# move image to center of window
pic.move(pic.getWidth() / 2, pic.getHeight() / 2)

pic.draw(win)

newpic = Image(Point(0, 0), int(pic.getWidth() * 1.5), int(pic.getHeight() * 1.5))

betternewpic = Image(Point(0, 0), int(pic.getWidth()*1.5), int(pic.getHeight()*1.5))

# convert theoretical x to actual x
# ie, "0" will become "halfway across the picture"
def shiftX(pic, x):
    return x + pic.getWidth() / 2


# convert actual x to theoretical x
def unShiftX(pic, x):
    return x - pic.getWidth() / 2


# convert theoretical y to actual y
# ie, "0" will become "halfway down the picture"
# also change so positive y is up coming in and down going out
def shiftY(pic, y):
    return pic.getHeight() / 2 - y


# convert actual y to theoretical y
def unShiftY(pic, y):
    return pic.getHeight() / 2 - y


angle = float(input("Enter the rotation angle in degrees: "))
theta = angle / 180.0 * 3.1415926358979323

for rx in range(pic.getWidth()):
    for ry in range(pic.getHeight()):
        color = pic.getPixel(rx, ry)
        x = unShiftX(pic, rx)
        y = unShiftY(pic, ry)

        nx = x * math.cos(theta) - y * math.sin(theta)
        ny = x * math.sin(theta) + y * math.cos(theta)

        nrx = int(shiftX(newpic, nx))
        nry = int(shiftY(newpic, ny))

        if 0 <= nrx < newpic.getWidth() and 0 <= nry < newpic.getHeight():
            newpic.setPixel(nrx, nry, color_rgb(color[0], color[1], color[2]))

# make a window the size of the new image
win2 = GraphWin("Poorly Rotated Picture", newpic.getWidth(), newpic.getHeight())

# move new image to center of window
newpic.move(newpic.getWidth() / 2, newpic.getHeight() / 2)

newpic.draw(win2)

for rnx in range(newpic.getWidth()):
    for rny in range(newpic.getHeight()):

        cx = unShiftX(pic, rnx)
        cy = unShiftY(pic, rny)

        unrotatedx = cx*math.cos(-theta) - cy*math.sin(-theta)
        unrotatedy = cx*math.sin(-theta) + cy*math.cos(-theta)

        origshiftx = int(shiftX(pic, unrotatedx))
        origshifty = int(shiftY(pic, unrotatedy))
        color = newpic.getPixel(rnx, rny)
        if 0<=origshiftx<pic.getWidth() and 0<= origshifty<pic.getHeight():
            color = pic.getPixel(origshiftx, origshifty)
            betternewpic.setPixel(rnx, rny, color_rgb(color[0], color[1], color[2]))


win3 = GraphWin("Better Rotated Picture", betternewpic.getWidth(), betternewpic.getHeight())

betternewpic.move(betternewpic.getWidth()/2, betternewpic.getHeight()/2)
betternewpic.draw(win3)
input("Hit ENTER to quit.")
