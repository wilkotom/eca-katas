def decode(keypresses):
    return None

lookup_table = {
    "1": "1",
    "2": "ABC2",
    "3": "DEF3",
    "4": "GHI4",
    "5": "JKL5",
    "6": "MNO6",
    "7": "PQRS7",
    "8": "TUV8",
    "9": "WXYZ9",
    "0": " 0",
    " ": ["", ""]
}

def decode(keypresses):
    output = ''
    last_char = ''
    keypress_count = 1
    for char in keypresses:
        if char == last_char:
            keypress_count += 1
        else:
            output += lookup_table[last_char][(keypress_count - 1) % len(lookup_table[last_char])]
            last_char = char
            keypress_count = 1
    output += lookup_table[last_char][(keypress_count - 1) % len(lookup_table[last_char])]
    return output



from itertools import groupby

def decode(keypresses):
    output = ''
    for key, presses in groupby(keypresses):
        index = len(list(presses)) % len(lookup_table[key]) - 1
        output += lookup_table[key][index]
    return output


def decode(keypresses):
    return "".join(lookup_table[ch][(len(list(it)) -1) % len(lookup_table[ch])] for ch, it in groupby(keypresses))
