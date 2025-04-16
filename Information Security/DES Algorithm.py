from Crypto.Cipher import DES
from Crypto.Util.Padding import pad, unpad
import base64

def get_des_key(key):
    return key[:8].ljust(8, '0').encode()

def des_encrypt(plaintext, key):
    key = get_des_key(key)
    cipher = DES.new(key, DES.MODE_ECB)
    padded_text = pad(plaintext.encode(), DES.block_size)
    encrypted = cipher.encrypt(padded_text)
    return base64.b64encode(encrypted).decode()

def des_decrypt(ciphertext, key):
    key = get_des_key(key)
    cipher = DES.new(key, DES.MODE_ECB)
    decrypted = cipher.decrypt(base64.b64decode(ciphertext))
    return unpad(decrypted, DES.block_size).decode()

if __name__ == "__main__":
    message = input("Enter your message: ")
    key = input("Enter 8-character key: ")

    encrypted = des_encrypt(message, key)
    print("Encrypted:", encrypted)

    decrypted = des_decrypt(encrypted, key)
    print("Decrypted:", decrypted)
