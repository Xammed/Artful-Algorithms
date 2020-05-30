import math

def getArea(ptset):
    area = 0
    for i in range(len(ptset)-1):
        area += 0.5 * (float(ptset[i+1][0]) - float(ptset[i][0]))*(float(ptset[i][1])+float(ptset[i+1][1]))
    return math.fabs(area)


def testPoly():
    numpoly = int(input("Num poly: "))
    areas = []
    for i in range(numpoly):
        numpts = int(input("num pts: "))
        points = []
        for k in range(numpts):
            holder = []
            point = input("x y: ").split(" ")
            holder.append(float(point[0]))
            holder.append(float(point[1]))
            points.append(holder)
        points = translatePoints(points)
        areas.append(getArea(points))
    return areas


def testPoly2():
    numpts = int(input("num pts: "))
    points = []
    areas = []
    for k in range(numpts):
        holder = []
        point = input("x y: ").split(" ")
        holder.append(float(point[0]))
        holder.append(float(point[1]))
        points.append(holder)
    points = translatePoints(points)
    areas.append(getArea(points))
    return areas


def translatePoints(points):
    minxval = points[0][0]
    minyval = points[0][1]
    for i in range(1, len(points)):
        if (points[i][0]<minxval):
            minxval = points[i][0]
        if (points[i][1]<minyval):
            minyval = points[i][1]
    if(minxval<0):
        for point in points:
            point[0]+= (-1*minxval)
    if(minyval<0):
        for point in points:
            point[1]+= (-1*minyval)
    return points


def printResults(areas):
    for i in range(len(areas)):
        print("Area of Polygon " + str(i+1) +": "+ str(areas[i]))

    return 1

printResults(testPoly2())

