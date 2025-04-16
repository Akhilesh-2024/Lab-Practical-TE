import math

plainttext = input("Enter your plain text: ")
key = int(input("Enter key: "))

ciphertext = [''] * key


for column in range(key):
    pointer = column;

    while pointer < len(plainttext):
        ciphertext[column] += plainttext[pointer]
        pointer+=key

print(''.join(ciphertext))


def main():
    myMessage = input("Enter cipher text: ")
    myKey = int(input("Enter key: "))

    text = decryptMessage(myKey, myMessage)
    
    print(text)

def decryptMessage(key, message):
    numOfColumns = int(math.ceil(len(message) / key))
    numOfRows = key
    numOfShadedBoxes = (numOfColumns * numOfRows) - len(message)


    text = [''] * numOfColumns
    column = 0
    row = 0

    for symbol in message:
        text[column] += symbol
        column += 1 

        if (column == numOfColumns) or (column == numOfColumns - 1 and row >= numOfRows - numOfShadedBoxes):
            column = 0
            row += 1

    return ''.join(text)

if __name__ == '__main__':
    main()
