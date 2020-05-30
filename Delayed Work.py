
def costEvaluation(k, p, x):
    found = 0
    m = 1
    costArray = []
    while(found==0):
        costArray = progressCosts(k, p, x, costArray, m)
        proposedMin = findMinUni(costArray)
        if(proposedMin != -1 and proposedMin!=0):
            return proposedMin
        else:
            costArray = progressCosts(k, p, x, costArray, m)


def progressCosts(k, p, x, costArray, m):
    counter = len(costArray)
    until = counter*3
    while(counter<=until):
        cost = (k / m) * p + x * m
        costArray.append(cost)
        counter+=1
        m += 1
    return costArray

def TernySerny(searchdis):
    l = 0
    r = len(searchdis)
    m1 = int(l + ((r - l) / 3))
    m2 = int(r - ((r - l) / 3))
    while (m1 != m2):
        if(searchdis[m1]<searchdis[m2]):
            l = m1
        if(searchdis[m1]>searchdis[m2]):
            r = m2
        if(searchdis[m1] == searchdis[m2]):
            return searchdis[m1]
        m1 = int(l + ((r - l) / 3))
        m2 = int(r - ((r - l) / 3))

    return -1

def findMinUni(array):
    minindex = 0
    min = array[0]
    for i in range(len(array)):
        if(array[i]<min):
            min = array[i]
            minindex = i
    if (minindex!=0 and minindex!=len(array)):
        if (array[minindex-1]> min and min<array[minindex+1]):
            return min
    else:
        return -1



values = input().split(" ")

print(costEvaluation(int(values[0]), int(values[1]), int(values[2])))

