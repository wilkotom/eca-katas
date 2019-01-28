def fibonacci(n):
    prev_numbers = (0, 1)
    while n > 1:
        n -= 1
        prev_numbers = (prev_numbers[1], prev_numbers[0] + prev_numbers[1])
    return prev_numbers[0]

def fibonacci(n):
    o = 0
    def fib():
        a, b = 0, 1
        while True:
            yield a
            a, b = b, a + b
    
    for i in range (n+1):
        o = fib.next()
    return o
 
def fibonacci(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    return fibonacci(n-1) + fibonacci(n-2)
 
 
def fibonacci(n):
    cache = {}
    def fib(n):
        if n < 0:
            n = 0
        if n not in cache:
            if n == 0:
                cache[n] = 0
            elif n == 1:
                cache[n] = 1
            else:
                cache[n] = fib(n-1) + fib(n-2)
        return cache[n]
    return fib(n)
 
 
def fibonacci(n, fibs=[0, 1]):
    if n <=0:
        n = 0
    if len(fibs) >= n+1:
        return fibs[n]
    else:
        fibs.append(fibs[-1] + fibs[-2])
        return fibonacci(n, fibs)
 
 
def fibonacci(n, fibs=(0, 1):
    if n <=0:
        return fibs[0]
    else:
        return fibonacci(n-1, (fibs[1], fibs[0]+ fibs[1]))


from functools import lru_cache
@lru_cache()
def fibonacci_decorator(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)