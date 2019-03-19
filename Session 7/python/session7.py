def validate(ccnum):
    if len(ccnum) == 0:
        return False
    doubles = ccnum[-2::-2]
    singles = ccnum[-1::-2]
    total = sum([int(num) for num in singles])
    for num in doubles:
        total += 2* int(num)
        if int(num) >=5:
            total -= 9
    return (total % 10) == 0


def validate(ccnum):
    numbers = [int(n) for n in ccnum]
    doubles = numbers[-2::-2]
    singles = numbers[-1::-2]
    total = sum(singles)
    for num in doubles:
        total += 2* num
        if num >=5:
            total -= 9
    return (total % 10) == 0 if len(ccnum) > 0 else False


def validate(ccnum):
    doubles = [ 2*int(n) if int(n) < 5 else (2*int(n) -9) for n in ccnum[-2::-2] ]
    total = sum (doubles + [int(n) for n in ccnum[-1::-2]] )
    return len(ccnum) > 0 and not (total % 10)


def validate(ccnum):
    numbers = [int(n) for n in ccnum]
    return (sum(
          [ 2*n if n < 5 else (2*n - 9) for n in numbers[-2::-2] ] +
          numbers[-1::-2]
        ) % 10) == 0 if len(ccnum) > 0 else False


def validate(ccnum):
    return (sum(
          [2*int(n) if int(n) < 5 else 2*int(n) - 9 for n in ccnum[-2::-2]] +
          [int(n) for n in ccnum[-1::-2]]
        ) % 10) == 0 if len(ccnum) > 0 else False


def validate(ccnum):
    numbers = map(int, ccnum)
    return (sum(
          [(2 * n) % 9 if n!= 9 else 9 for n in numbers[-2::-2]] +
          numbers[-1::-2]
        ) % 10) == 0 if len(ccnum) > 0 else False


def validate(ccnum):
    return len(ccnum) > 0 and not sum([
            ((2 * n) % 9 if n != 9 else 9) if i % 2 == len(ccnum) % 2
            else n
            for i, n in enumerate([int(n) for n in ccnum])]
        ) % 10
