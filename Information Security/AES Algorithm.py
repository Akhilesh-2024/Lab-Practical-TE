from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
import base64

def get_aes_key(key):
    return key[:16].ljust(16, '0').encode()

def aes_encrypt(plaintext, key):
    key = get_aes_key(key)
    cipher = AES.new(key, AES.MODE_CBC)
    iv = cipher.iv
    padded_text = pad(plaintext.encode(), AES.block_size)
    encrypted = cipher.encrypt(padded_text)
    return base64.b64encode(iv + encrypted).decode()

def aes_decrypt(ciphertext, key):
    key = get_aes_key(key)
    raw = base64.b64decode(ciphertext)
    iv = raw[:AES.block_size]
    encrypted_data = raw[AES.block_size:]
    cipher = AES.new(key, AES.MODE_CBC, iv)
    decrypted = cipher.decrypt(encrypted_data)
    return unpad(decrypted, AES.block_size).decode()

if __name__ == "__main__":
    message = input("Enter your message: ")
    key = input("Enter 16-character key: ")

    encrypted = aes_encrypt(message, key)
    print("Encrypted:", encrypted)

    decrypted = aes_decrypt(encrypted, key)
    print("Decrypted:", decrypted)