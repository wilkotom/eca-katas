def palindrome(sentence):
    filtered = ''
    for c in sentence:
        if c.isalnum():
            filtered += c.lower()
    half_length = len(filtered) / 2
    return len(filtered) > 0 and \
           filtered[:half_length] == \
           filtered[-1:-1 - half_length:-1]


def palindrome(sentence):
    filtered = filter(lambda c: c.isalnum(), sentence).lower()
    return len(filtered) > 0 and \
           filtered == ''.join(reversed(filtered))


def palindrome(sentence):
    filtered = filter(lambda c: c.isalnum(), sentence).lower()
    return len(filtered) > 0 and filtered == filtered[::-1]


def palindrome(sentence):
    filtered = ''.join([c if c.isalnum() else ''
                        for c in sentence]).lower()
    return len(filtered) > 0 and filtered == filtered[::-1]


def palindrome(sentence):
    filtered = filter(lambda c: c.isalnum(), sentence).lower()
    if len(filtered) == 0:
        return False
    elif len(filtered) == 1:
        return True
    elif len(filtered) == 2:
        return filtered[0] == filtered[1]
    elif filtered[0] == filtered[-1]:
        return palindrome(filtered[1:len(filtered) - 1])
    else:
        return False


import re


def palindrome(sentence):
    filtered = re.sub("[^A-Za-z0-9]", "", sentence).lower()
    return len(filtered) > 0 and filtered == filtered[::-1]
