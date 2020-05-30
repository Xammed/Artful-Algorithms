# M Sarosh Khan
# PREP FOR CODE INT
# D PROVINE AKA KILROY
# 3D Trilaterate
# This was easy, I don't know why I put it off.

import math


def distance(p1, p2):
    return math.sqrt(((p1[0]-p2[0])**2) + ((p1[1]-p2[1])**2) + ((p1[2]-p2[2])**2))

def makeCube(x, y, z, dist):
    xmin = x- 2*dist
    ymin = y- 2*dist
    zmin = z- 2*dist
    xmax = x+ 2*dist
    ymax = y+ 2*dist
    zmax = z+ 2*dist
    pointmin = [int(xmin), int(ymin), int(zmin)]
    pointmax = [int(xmax), int(ymax), int(zmax)]
    return pointmin, pointmax

def findOverlap(c1, c2):
    maxC = c2
    minC = c1
    if c1[1][0] > c2[1][0]:
        maxC = c1
        minC = c2
    pointmin = [maxC[1][0],maxC[1][1], maxC[1][2]]
    pointmax = [minC[0][0], minC[0][1], minC[0][2]]
    return pointmin, pointmax

def trilaterate(xa, ya, za, da, xb, yb, zb, db, xc, yc, zc, dc):
    cube1 = makeCube(xa, ya, za, da)
    cube2 = makeCube(xb, yb, zb, db)
    cube3 = makeCube(xc, yc, zc, dc)
    spaceCons = findOverlap(findOverlap(cube1, cube2), findOverlap(cube2, cube3))
    for i in range(spaceCons[0][0], spaceCons[1][0]):
        for j in range(spaceCons[0][1], spaceCons[1][1]):
            for k in range(spaceCons[0][2], spaceCons[1][2]):
                test = (i, j, k)
                if (int(distance(test, (xa, ya, za))) == int(da)
                        and int(distance(test, (xb, yb, zb))) == int(db)
                        and int(distance(test, (xc, yc, zc))) == int(dc)):
                    return i, j, k

    return -1


def testTrilaterate():
    numcubes = int(input())
    for i in range(numcubes):
        cube1 = input("").split(" ")
        cube2 = input("").split(" ")
        cube3 = input("").split(" ")
        point = trilaterate(float(cube1[0]), float(cube1[1]), float(cube1[2]), float(cube1[3]),
                float(cube2[0]), float(cube2[1]), float(cube2[2]), float(cube2[3]),
                float(cube3[0]), float(cube3[1]), float(cube3[2]), float(cube3[3]))
        print(str(point[0]) + " " + str(point[1]) + " " + str(point[2]))
    return 0

testTrilaterate()

