def solution(cacheSize, cities):
    cache = []
    miss = 0
    hit = 0

    if cacheSize == 0:
        return len(cities) * 5

    for city in cities:
        city = city.lower()
        
        # city가 cache에 없는 경우(cache가 비어 있는 경우 포함)
        if city not in cache:
            miss += 1
            if len(cache) == cacheSize:
                cache.pop(0)
            cache.append(city)

        # city가 cache에 있는 경우
        else:
            hit += 1
            cache.remove(city)
            cache.append(city)

    return miss * 5 + hit