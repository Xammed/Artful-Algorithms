
import math

def trilaterate(ax, ay, adist, bx, by, bdist, cx, cy, cdist):
    abdist = math.sqrt(math.pow((bx-ax), 2) + math.pow((by-ay),2))
    normx = ((adist ** 2) - (bdist ** 2) + abdist ** 2) / (2 * abdist)
    normy = math.sqrt(adist ** 2 - normx ** 2)
    theta = math.atan2(by-ay, bx-ax)
    x = ax + normx*math.cos(-theta) + normy*math.sin(-theta)
    y = ay + -1*normx*math.sin(-theta) + normy*math.cos(-theta)

    if(math.fabs(math.sqrt(math.pow(cx-x, 2)+math.pow(cy-y, 2)) - cdist)>=0.01):
        normy = -normy
        x = ax + normx * math.cos(-theta) + normy * math.sin(-theta)
        y = ay + -1 * normx * math.sin(-theta) + normy * math.cos(-theta)

    print(round(x, 3), round(y, 3))
    return x, y


trilaterate(0, 0, 1.414, 0, 1, 1.000, 1, 0, 1.000)
trilaterate(-68.698, 65.18, 134.818, -99.904, 44.53, 149.734, 20.282, -61.965, 42.633)
