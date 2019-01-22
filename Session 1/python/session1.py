def redact(sentence, badwords):
    return None


def redact_naive(sentence, badwords):
    words = sentence.split()
    output = []
    for word in words:
        if word.lower() in badwords:
            output.append('****')
        else:
            output.append(word)
    return ' '.join(output)


def redact_inner_function(sentence, badwords):
    def censor(word):
        if word.lower() in badwords:
            return '****'
        else:
            return word

    output = []
    for word in sentence.split():
        output.append(censor(word))
    return ' '.join(output)


def redact_with_map(sentence, badwords):
    def censor(word):
        if word.lower() in badwords:
            return '****'
        else:
            return word

    return ' '.join(map(censor, sentence.split()))


def redact_with_map_truncate_censor(sentence, badwords):
    def censor(word):
        return word if word.lower() not in badwords else '****'

    return ' '.join(map(censor, sentence.split()))

def redact_with_map_lambda(sentence, badwords):
    return ' '.join(
        map(lambda x: x if x.lower() not in badwords else '****',
            sentence.split())
    )


def redact_list_comp(sentence, badwords):
    return ' '.join(
        [word if word.lower() not in badwords else '****'
         for word in sentence.split()]
    )


def redact_eliminate_negative(sentence, badwords):
    return ' '.join(
        ['****' if word.lower() in badwords else word
         for word in sentence.split()]
    )
