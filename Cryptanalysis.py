
def known_plaintext_attack(plaintext, ciphertext):
    plaintext = plaintext.upper()
    ciphertext = ciphertext.upper()

    if len(plaintext) != len(ciphertext):
        return None

    key = None

    for p, c in zip(plaintext, ciphertext):
        if 'A' <= p <= 'Z' and 'A' <= c <= 'Z':
            shift = (ord(c) - ord(p)) % 26

            if key is None:
                key = shift
            elif key != shift:
                return None

      # if not eng letter check if the same, if not return none
        elif p != c:
            return None

    return key


