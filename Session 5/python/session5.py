from functools import reduce

letter_score = {"a": 1, "b": 3, "c": 3, "d": 2, "e": 1,"f": 4,
                "g": 2, "h": 4, "i": 1, "j": 8, "k": 5,"l": 1,
                "m": 3, "n": 1, "o": 1, "p": 3, "q": 10, "r": 1,
                "s": 1, "t": 1, "u": 1, "v": 4, "w": 4, "x": 8,
                "y": 4, "z": 10}

def scrabble_score(played):
    total = 0
    if len(played) >= 8 or not played.isalpha():
        return 0
    elif len(played) == 7:
        total = 50
    words = []
    with open('words.txt') as wordlist:
        for word in wordlist:
            words.append(word.strip())
    for letter in played.lower():
        total += letter_score[letter]
    if played not in words:
        return 0
    return total


def scrabble_score(played):
    words = []
    bonus = 0
    with open('words.txt') as wordlist:
        for word in wordlist:
            words.append(word.strip())
    if len(played) == 7:
        bonus = 50
    return bonus + sum(
        [letter_score[x] for x in played.lower()]
    ) if played.lower() in words and len(played) < 8 \
        else 0


def scrabble_score(played):
    words = open('words.txt').read().split('\n')
    bonus = 50 if len(played) == 7 else 0
    return bonus + sum(
        [letter_score[x] for x in played.lower()]
    ) if played.lower() in words and len(played) < 8 else 0



def scrabble_score(played):
    words = [ word.strip() for word  in open('words.txt').readlines()]
    bonus = 50 if len(played) == 7 else 0
    return bonus + sum(
        [letter_score[x] for x in played.lower()]
    ) if played.lower() in words and len(played) < 8 else 0


def scrabble_score(played):
    return (50 if len(played) == 7 else 0) + \
           sum([letter_score[x] for x in played.lower()]) \
           if played.lower() in open('words.txt').read().split('\n') and len(played) < 8 \
           else 0

def scrabble_score(played):
    words = [ word.strip() for word  in open('words.txt').readlines()]
    bonus = 50 if len(played) == 7 else 0
    score = reduce(lambda total, current: total + letter_score.get(current,0), played.lower(), bonus)
    return (bonus + score) if (played.lower() in words and len(played) <8) else 0


def scrabble_score(played):
    words = [word.strip() for word in open('words.txt').readlines()]
    bonus = 50 if len(played) == 7 else 0
    return reduce(
        lambda total, current: total + letter_score.get(current, 0),
        played.lower(), bonus) \
        if (played.lower() in words and len(played) < 8) else 0
